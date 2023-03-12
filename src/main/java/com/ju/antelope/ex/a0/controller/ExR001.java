package com.ju.antelope.ex.a0.controller;

import com.ju.antelope.ex.a0.check.ExR001Check;
import com.ju.antelope.ex.a0.service.ExR001QueryService;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ExR001/api/v1")
public class ExR001 {

  private static final Logger log = LoggerFactory.getLogger(ExR001.class);

  @Autowired private ExR001QueryService exR001QueryService;

  @Autowired private ExR001Check exR001Check;

  @RequestMapping(
      value = "/query/agg",
      method = {RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST})
  public Object queryAggregate(@RequestBody Map<String, Object> paramMap) {
    try {
      return exR001QueryService.queryAggregate(paramMap);
    } catch (Exception e) {
      log.error("param:{} errorMsg:{}", paramMap, e.getMessage(), e);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @RequestMapping(
      value = "/query",
      method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
  public Object query(@RequestBody Map<String, Object> paramMap) {
    try {
      return exR001QueryService.queryTimely(paramMap);
    } catch (Exception e) {
      log.error("param:{} errorMsg:{}", paramMap, e.getMessage(), e);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @RequestMapping(
      value = "${line.bot.handler.path}",
      method = {RequestMethod.POST, RequestMethod.OPTIONS})
  public Object linebotCallback(
      @RequestBody String requestBody, @RequestHeader("x-line-signature") String signature) {
    if (!exR001Check.isVaildMsg(requestBody, signature)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
