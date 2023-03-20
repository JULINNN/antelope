package com.ju.antelope.config;

import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@Profile("!test")
public class DataSourceConfig {

  private static final String JNDI_PREFIX = "java:comp/env/";

  @Bean
  @Primary
  public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setTypeAliasesPackage("com.ju.antelope.*.*.vo");
    bean.setMapperLocations(
        new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/**/*.xml"));
    bean.setDataSource(dataSource);
    SqlSessionFactory sqlSessionFactory = bean.getObject();
    org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
    configuration.setMapUnderscoreToCamelCase(Boolean.TRUE);
    return sqlSessionFactory;
  }

  @Bean
  @Primary
  public DataSourceTransactionManager dataSourceTransactionManager(
      @Autowired DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  @Primary
  public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean
  @Primary
  public DataSource jndiDataSource(@Value("${jdbc.jndi}") String jndi)
      throws IllegalArgumentException, NamingException {
    JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
    bean.setJndiName(JNDI_PREFIX + jndi);
    bean.setProxyInterface(DataSource.class);
    bean.setLookupOnStartup(false);
    bean.afterPropertiesSet();

    return (DataSource) bean.getObject();
  }
}
