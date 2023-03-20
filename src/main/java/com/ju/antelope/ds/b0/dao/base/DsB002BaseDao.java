package com.ju.antelope.ds.b0.dao.base;

import com.ju.antelope.ds.b0.vo.base.DsB002BaseVo;
import java.util.List;

public interface DsB002BaseDao {

  Integer count(Object params);

  List<DsB002BaseVo> query(Object params);

  Integer deleteByPk(Long id);

  Integer insert(Object params);

  DsB002BaseVo getByPk(Long id);

  Integer update(Object params);
}
