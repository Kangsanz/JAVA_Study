package com.varxyz.jvx330.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifecycle.example1.Dog;
import com.varxyz.jvx330.lifecycle.example2.Eagle;
import com.varxyz.jvx330.lifecycle.example3.Goat;
import com.varxyz.jvx330.lifecycle.example3.Horse;

@Configuration
public class AppConfig {
	/**
	 * <bean name="dog" class="com.varxyz.jvx330.lifecycle.example1.Dog">
	 * <constructor-arg index=0 type="java.lang.String value="플루토" />
	 * <property name="name" value="볼트" /> </bean>
	 * 
	 * @return
	 */

	@Bean
	public Dog dog() {
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
	}

	@Bean(initMethod = "attachWings", destroyMethod = "detachWings") // 기존 파일을 수정하지 않고, 속성 파일에서 해당 메서드를 불러옴
	public Eagle eagle() {
		Eagle e = new Eagle("");
		e.setName("에디");
		return e;
	}

	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	
	@Bean()
	@Scope("prototype")
	public Horse horse() {
		return new Horse();
	}
}
