package com.ju.antelope.ex.a0.dao;

import com.ju.antelope.ex.a0.vo.ExR001Vo;
import java.sql.SQLException;
import java.util.List;

public interface ExR001Dao {

  Integer insertUnique(Object object) throws SQLException;

  /** 取得彙總資料 */
  List<ExR001Vo.CommonResult> queryAggregate(Object object) throws SQLException;

  /** 取得即時資料 */
  List<ExR001Vo.CommonResult> queryTimely(Object object) throws SQLException;
}
