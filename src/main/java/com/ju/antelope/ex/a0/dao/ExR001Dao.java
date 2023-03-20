package com.ju.antelope.ex.a0.dao;

import com.ju.antelope.ds.b0.vo.DsB002Vo;
import com.ju.antelope.ex.a0.vo.ExR001Vo;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExR001Dao {

  Integer insertUnique(Object object) throws SQLException;

  /** 取得彙總資料 */
  List<ExR001Vo.CommonResult> queryAggregate(Object object) throws SQLException;

  /** 取得即時資料 */
  List<ExR001Vo.CommonResult> queryTimely(Object object) throws SQLException;

  /** 取得每日平均 */
  List<DsB002Vo> queryDateAvg(@Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo)
      throws SQLException;
}
