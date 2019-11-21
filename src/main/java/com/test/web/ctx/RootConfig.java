package com.test.web.ctx;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@EnableAspectJAutoProxy
//@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages= {"com.test.web"})
@Import({
	MybatisConfig.class, ServletConfig.class
})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		/*HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/wego?serverTimezone=UTC");
		hikariConfig.setUsername("wego");
		hikariConfig.setPassword("wego");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);*/
		
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();

		    dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		    dataSource.setUrl("jdbc:mariadb://172.168.0.89/hanrabong?serverTimezone=UTC");
		    dataSource.setUsername("hanrabong");
		    dataSource.setPassword("hanrabong");

		    return dataSource;
	}
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	
}