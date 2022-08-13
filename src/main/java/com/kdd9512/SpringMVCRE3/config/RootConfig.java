package com.kdd9512.SpringMVCRE3.config;// JAVA 로 Root 설정.

//package org.kdd9512.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ComponentScan(basePackages = {"org.kdd9512.sample"})
//@MapperScan(basePackages = {"org.kdd9512.mapper"})
//public class RootConfig {
//
//    @Bean
//    public DataSource dataSource() {
//
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
//        hikariConfig.setUsername("book_ex");
//        hikariConfig.setPassword("hwhw9512");
//
//        return new HikariDataSource(hikariConfig);
//
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource());
//
//        return (SqlSessionFactory) sqlSessionFactory.getObject();
//
//    }
//}
