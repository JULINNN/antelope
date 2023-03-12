package com.ju.antelope;

import java.util.ArrayList;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.ju.antelope.*.*.dao")
@PropertySource("classpath:default.properties")
public class AntelopeApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(AntelopeApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();

    SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

    clientHttpRequestFactory.setConnectTimeout(1000); // 1秒
    restTemplate.setRequestFactory(clientHttpRequestFactory);

    List<HttpMessageConverter<?>> converters = new ArrayList<>();
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setSupportedMediaTypes(List.of(MediaType.ALL));
    converters.add(converter);
    restTemplate.setMessageConverters(converters);
    return restTemplate;
  }
}
