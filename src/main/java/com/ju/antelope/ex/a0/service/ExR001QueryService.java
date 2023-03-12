package com.ju.antelope.ex.a0.service;

import com.ju.antelope.ex.a0.dao.ExR001Dao;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExR001QueryService {

  @Autowired private ExR001Dao exR001Dao;

  /** 取得彙總資料 */
  public Object queryAggregate(Map<String, Object> paramMap) throws SQLException {
    return exR001Dao.queryAggregate(paramMap);
  }

  /** 取得即時資料 */
  public Object queryTimely(Map<String, Object> paramMap) throws SQLException {
    return exR001Dao.queryTimely(paramMap);
  }
}
