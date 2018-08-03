package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by jiyajie on 16/9/11.
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.dao.manageMappper", sqlSessionFactoryRef = "secondarySessionFactory")
@EnableTransactionManagement
public class MCDataSourceConfig {
    @Autowired
    private Environment env;

    private static final Logger LOGGER = LoggerFactory.getLogger(MCDataSourceConfig.class);

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    public DataSource manageDataSource() throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName", env.getProperty("driverClassName"));
        properties.put("url", manageUrl);
        properties.put("username", manageUserName);
        properties.put("password", managePassword);
        properties.put("initialSize", env.getProperty("initialSize"));
        properties.put("maxActive", env.getProperty("maxActive"));
        properties.put("minIdle", env.getProperty("minIdle"));
        properties.put("maxWait", env.getProperty("maxWait"));
        properties.put("removeAbandoned", env.getProperty("removeAbandoned"));
        properties.put("removeAbandonedTimeout", env.getProperty("removeAbandonedTimeout"));
        properties.put("timeBetweenEvictionRunsMillis", env.getProperty("timeBetweenEvictionRunsMillis"));
        properties.put("minEvictableIdleTimeMillis", env.getProperty("minEvictableIdleTimeMillis"));
        properties.put("validationQuery", env.getProperty("validationQuery"));
        properties.put("testWhileIdle", env.getProperty("testWhileIdle"));
        properties.put("testOnBorrow", env.getProperty("testOnBorrow"));
        properties.put("testOnReturn", env.getProperty("testOnReturn"));
        properties.put("poolPreparedStatements", env.getProperty("poolPreparedStatements"));
        properties.put("maxPoolPreparedStatementPerConnectionSize", env.getProperty("maxPoolPreparedStatementPerConnectionSize"));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("load druid datasource.");
        }
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean(name = "secondarySessionFactory")
    public SqlSessionFactory manageSqlSessionFactory(@Qualifier("secondaryDataSource")DataSource dataSource) {
        try {
            final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources("classpath:mapper/*.xml"));
            return sessionFactory.getObject();
        } catch (Exception e) {

        }
        return null;
    }

    @Bean(name="secondaryJdbcTemplate")
    public JdbcTemplate jdbcTemplate() throws Exception {
        return new JdbcTemplate(manageDataSource());
    }

    @Bean(name = "secondaryTransactionManagery")
    public DataSourceTransactionManager manageransactionManager() throws Exception {
        return new DataSourceTransactionManager(manageDataSource());
    }

    private
    @Value("${manage.url}")
    String manageUrl;
    private
    @Value("${manage.username}")
    String manageUserName;
    private
    @Value("${manage.password}")
    String managePassword;
}
