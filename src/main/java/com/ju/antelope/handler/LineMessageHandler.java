package com.ju.antelope.handler;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@com.linecorp.bot.spring.boot.annotation.LineMessageHandler
public class LineMessageHandler {

  private static final Logger log = LoggerFactory.getLogger(LineMessageHandler.class);

  @EventMapping
  public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
    log.info("event:{}", event);
    return new TextMessage(event.getMessage().getText());
  }
}
