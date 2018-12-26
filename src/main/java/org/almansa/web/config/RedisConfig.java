package org.almansa.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;

// @EnableRedisHttpSession 어노테이션이 SpringSessionRepositoryFilter(Filter의 구현체) 라는 빈을 생성합니다
// 이 필터는 HttpSession의 구현체를 바꾸는 역할을 합니다.  
@EnableRedisWebSession
@Configuration
public class RedisConfig {
	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("localhost", 6379);
		
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(redisConfig);
		return connectionFactory;
	}
	
}
