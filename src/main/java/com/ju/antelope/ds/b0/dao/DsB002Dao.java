package com.ju.antelope.ds.b0.dao;

import com.ju.antelope.ds.b0.dao.base.DsB002BaseDao;
import java.sql.SQLException;

public interface DsB002Dao extends DsB002BaseDao {

  Integer insertOrUpdate(Object params) throws SQLException;
}
