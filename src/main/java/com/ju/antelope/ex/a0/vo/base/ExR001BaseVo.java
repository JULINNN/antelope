package com.ju.antelope.ex.a0.vo.base;

import com.ju.antelope.common.AbstractBaseVo;

public class ExR001BaseVo extends AbstractBaseVo {

  private Long exrateNum;
  /** 建立時間 */
  private String createAt;

  /** 建立者 */
  private Long createBy;

  /** 更新時間 */
  private String updateAt;

  /** 更新者 */
  private Long updateBy;

  /** 幣別 */
  private String currency;

  private Double exrate;

  /** 抓資料時間 */
  private String dataTime;

  public Long getExrateNum() {
    return exrateNum;
  }

  public void setExrateNum(Long exrateNum) {
    this.exrateNum = exrateNum;
  }

  public String getCreateAt() {
    return createAt;
  }

  public void setCreateAt(String createAt) {
    this.createAt = createAt;
  }

  public Long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Long createBy) {
    this.createBy = createBy;
  }

  public String getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(String updateAt) {
    this.updateAt = updateAt;
  }

  public Long getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(Long updateBy) {
    this.updateBy = updateBy;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getExrate() {
    return exrate;
  }

  public void setExrate(Double exrate) {
    this.exrate = exrate;
  }

  public String getDataTime() {
    return dataTime;
  }

  public void setDataTime(String dataTime) {
    this.dataTime = dataTime;
  }
}
