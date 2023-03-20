package com.ju.antelope.ex.a0.service;

import com.ju.antelope.ex.a0.dao.ExR001Dao;
import com.ju.antelope.ex.a0.vo.ExR001Vo;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExR001Service {

  private static final String URI = "https://tw.rter.info/capi.php";
  private static final String USD = "USD";
  private static final Logger log = LoggerFactory.getLogger(ExR001Service.class);
  @Autowired private RestTemplate restTemplate;

  @Autowired private SqlSessionFactory sqlSessionFactory;

  /** 下載資料 */
  public void downLoadData() {

    try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH)) {
      Map<String, Map<String, Object>> rawMap = restTemplate.getForObject(URI, Map.class);
      if (MapUtils.isEmpty(rawMap)) {
        return;
      }
      for (Map.Entry<String, Map<String, Object>> currencyMap : rawMap.entrySet()) {
        String currency = currencyMap.getKey();

        Map<String, Object> currDetailMap = currencyMap.getValue();
        Double exrate = MapUtils.getDouble(currDetailMap, "Exrate", (double) -1);
        String dataTime = MapUtils.getString(currDetailMap, "UTC");
        if (StringUtils.isBlank(dataTime)
            || StringUtils.isBlank(currency)
            || Double.compare(-1, exrate) == 0) {
          continue;
        }
        try {
          ExR001Vo exR001Vo = new ExR001Vo();
          exR001Vo.setCurrency(
              StringUtils.contains(currency, USD) && !StringUtils.equals(currency, USD)
                  ? StringUtils.substringAfter(currency, USD)
                  : currency);
          exR001Vo.setDataTime(dataTime);
          exR001Vo.setExrate(
              BigDecimal.valueOf(exrate).setScale(8, RoundingMode.CEILING).doubleValue());
          sqlSession.getMapper(ExR001Dao.class).insertUnique(exR001Vo);
        } catch (Exception e) {
          log.error("currency:{},dataTime:{},exrate:{} insert fail", currency, dataTime, exrate, e);
        }
      }
      sqlSession.commit();
    }
  }
}
