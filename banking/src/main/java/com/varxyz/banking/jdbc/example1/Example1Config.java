package com.varxyz.banking.jdbc.example1;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.varxyz.banking.jdbc.example1")
public class Example1Config {

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
}
