package com.staystrong.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
@Configuration
@ComponentScans({@ComponentScan("com.staystrong.controller"),@ComponentScan("com.staystrong.service")})
@MapperScan("com.staystrong.mapper")
@EnableWebMvc
public class TestSuperMaperClassCofig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FastJsonHttpMessageConverter());
    }
    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://116.62.214.72:3306/shirotest?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
        dataSource.setUsername("root");
        dataSource.setPassword(System.getProperty("password"));
        return dataSource;
    }
    @Bean("sqlSessionFactory")
    public MybatisSqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource){
        MybatisSqlSessionFactoryBean sqlSessionFactory=new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mappings/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

}
