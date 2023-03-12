package com.ju.antelope.ex.a0.vo;

import com.ju.antelope.ex.a0.vo.base.ExR001BaseVo;
import java.util.List;

/** 全球匯率主檔 */
public class ExR001Vo extends ExR001BaseVo {

  public static class CommonQuery extends ExR001Vo {

    /** 時區偏移 */
    private Integer offset;

    /** 起始時間 */
    private String dataStart;

    /** 結束時間 */
    private String dataEnd;

    /** 幣別 */
    private List<String> currencies;

    public Integer getOffset() {
      return offset;
    }

    public void setOffset(Integer offset) {
      this.offset = offset;
    }

    public String getDataStart() {
      return dataStart;
    }

    public void setDataStart(String dataStart) {
      this.dataStart = dataStart;
    }

    public String getDataEnd() {
      return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
      this.dataEnd = dataEnd;
    }

    public List<String> getCurrencies() {
      return currencies;
    }

    public void setCurrencies(List<String> currencies) {
      this.currencies = currencies;
    }
  }

  public static class CommonResult extends ExR001Vo {

    /** 資料區間 */
    private String interval;

    /** 資料量 */
    private String dataCount;

    public String getInterval() {
      return interval;
    }

    public void setInterval(String interval) {
      this.interval = interval;
    }

    public String getDataCount() {
      return dataCount;
    }

    public void setDataCount(String dataCount) {
      this.dataCount = dataCount;
    }
  }
}
