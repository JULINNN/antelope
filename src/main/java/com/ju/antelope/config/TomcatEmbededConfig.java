package com.ju.antelope.config;

import javax.sql.DataSource;
import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Profile("dev")
public class TomcatEmbededConfig {

  @Autowired private Environment env;

  @Bean
  public TomcatServletWebServerFactory tomcatFactory() {
    return new TomcatServletWebServerFactory() {
      @Override
      protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
        tomcat.enableNaming();
        return super.getTomcatWebServer(tomcat);
      }

      @Override
      protected void postProcessContext(Context context) {
        ContextResource resource = new ContextResource();
        resource.setName(env.getProperty("jdbc.jndi"));
        resource.setAuth("Container");
        resource.setProperty("factory", "org.apache.commons.dbcp2.BasicDataSourceFactory");
        resource.setType(DataSource.class.getName());
        resource.setProperty("driverClassName", env.getProperty("jdbc.driver.class.name"));
        resource.setProperty("url", env.getProperty("jdbc.url"));
        resource.setProperty("username", env.getProperty("jdbc.userName"));
        resource.setProperty("password", env.getProperty("jdbc.pwd"));
        context.getNamingResources().addResource(resource);
      }
    };
  }
}
