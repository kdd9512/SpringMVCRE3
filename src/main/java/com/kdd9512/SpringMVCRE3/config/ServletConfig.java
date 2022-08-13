package com.kdd9512.SpringMVCRE3.config;//package org.kdd9512.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//import java.io.IOException;
//
//@EnableWebMvc
//@ComponentScan(basePackages = {"org.kdd9512.controller", "org.kdd9512.exception"})
//public class ServletConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/views/");
//        bean.setSuffix(".jsp");
//        registry.viewResolver(bean);
//
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }
//
//    // 파일 업로드
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getResolver() throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//
//        // 최대용량 10MB
//        resolver.setMaxUploadSize(1024 * 1024 * 10);
//        // 개별 2MB
//        resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);
//        // 최대 메모리 용량 1MB
//        resolver.setMaxInMemorySize(1024 * 1024);
//        // 임시 저장 경로
//        resolver.setUploadTempDir(new FileSystemResource("C:\\JAVA\\galupload"));
//
//        resolver.setDefaultEncoding("UTF-8");
//
//        return resolver;
//
//    }
//
//}
