package com.uni.mpro;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
public class MproApplication {

	public static void main(String[] args) {
		SpringApplication.run(MproApplication.class, args);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		SqlSessionFactoryBean seb = new SqlSessionFactoryBean();
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*mapper.xml"); //왜 io냐면... mapper를 만들어야 함 쿼리 작성한게 있어야 하는데(아직 만들진 않았지만)읽어들여야 함 mapper.xml로 끝나는 파일 읽어오익
		//config 사용하려면 필수
		seb.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));

		seb.setMapperLocations(res); //mapper 위치 = res
		seb.setTypeAliasesPackage("com.uni.mpro.*.dto"); //패키지로 별칭 잡기
		
		seb.setDataSource(datasource); //데이터소스 자료들은 다 application.properties에 있음
		return seb.getObject();
	}
}
