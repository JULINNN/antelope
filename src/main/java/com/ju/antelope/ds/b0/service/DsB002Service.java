package com.ju.antelope.ds.b0.service;

import com.ju.antelope.ds.b0.dao.DsB002Dao;
import com.ju.antelope.ds.b0.vo.DsB002Vo;
import com.ju.antelope.ex.a0.dao.ExR001Dao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DsB002Service {

  private static final Logger log = LoggerFactory.getLogger(DsB002Service.class);
  private static String DATE_FROM = LocalDate.MIN.toString();
  @Autowired private ExR001Dao exR001Dao;
  @Autowired private DsB002Dao dsB002Dao;

  public void insertDailyData() throws SQLException {

    String dateTo = LocalDate.now().toString();
    List<DsB002Vo> dsB002Vos = exR001Dao.queryDateAvg(DATE_FROM, dateTo);
    for (DsB002Vo dsB002Vo : dsB002Vos) {
      try {
        dsB002Dao.insertOrUpdate(dsB002Vo);
      } catch (Exception e) {
        log.error("message:{}", e.getMessage(), e);
      }
    }
    DATE_FROM = dateTo;
  }
}
