package com.ju.antelope.ex.a0.task;

import com.ju.antelope.ex.a0.service.ExR001Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ExR001Task {

  private static final Logger log = LoggerFactory.getLogger(ExR001Task.class);
  @Autowired private ExR001Service exR001Service;

  @Scheduled(fixedDelay = 5 * 60 * 1000)
  public void downLoadData() {

    log.info("downLod data start...");
    try {
      exR001Service.downLoadData();
    } finally {
      log.info("downLoad data finish");
    }
  }
}
