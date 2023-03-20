package com.ju.antelope.ds.b0.vo.base;

import com.ju.antelope.common.AbstractBaseVo;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/** dsbboard db @TableName ds_b002 */
@Data
public class DsB002BaseVo extends AbstractBaseVo implements Serializable {
  private static final long serialVersionUID = 1L;
  /** */
  private Long infoNum;
  /** 建立日期 */
  private String createAt;
  /** 建立者 */
  private Long createBy;
  /** 更新日期 */
  private String updateAt;
  /** 更新者 */
  private Long updateBy;
  /** */
  private Long typeNum;
  /** */
  private BigDecimal info;
  /** */
  private String col1;
  /** */
  private String col2;
  /** */
  private String col3;
  /** */
  private String col4;
  /** */
  private String dataTime;
}
