package com.varxyz.banking.jdbc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.jdbc.example1.AccountDao;
import com.varxyz.banking.jdbc.example1.CustomerDao;

@Configuration
public class DataSourceConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jvx330?serverTimezone=Asia/Seoul");
		ds.setUsername("jvx330");
		ds.setPassword("jvx330");
		ds.setInitialSize(2); // 커넥션 풀 초기화 시 생성할 초기 커넥션 갯수 (기본값 10)
		ds.setMaxActive(10); // 풀에서 가져올 수 있는 최대 커넥션 갯수 (기본값 100)
		ds.setMaxIdle(10); // 풀에 유지할 수 있는 최대 커넥션 수 (기본값은 maxActive와 동일)
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() { // JDBC를 쉽게 연결하는 템플릿, Bean에서 직접 만드는 방식
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public CustomerDao customerDao() {
		return new CustomerDao(dataSource());
	}

	@Bean
	public AccountDao accountDao() {
		return new AccountDao(dataSource());
	}
}