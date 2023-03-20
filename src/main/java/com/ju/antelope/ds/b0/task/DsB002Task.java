package com.ju.antelope.ds.b0.task;

import com.ju.antelope.ds.b0.service.DsB002Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DsB002Task {

  private static final Logger log = LoggerFactory.getLogger(DsB002Task.class);

  @Autowired private DsB002Service dsB002Service;

  @Scheduled(cron = "0 0 * * *")
  public void insertDailyData() {

    log.info("insert daily data start!!");
    try {
      dsB002Service.insertDailyData();
    } catch (Exception e) {
      log.error("message:{}", e.getMessage(), e);
    }
    log.info("insert daily data end!!");
  }
}
