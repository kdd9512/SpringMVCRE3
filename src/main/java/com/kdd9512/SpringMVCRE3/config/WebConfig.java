package com.kdd9512.SpringMVCRE3.config;//package org.kdd9512.config;
//
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.Filter;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletRegistration;
//
//public class WebConfig
//        extends AbstractAnnotationConfigDispatcherServletInitializer {
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{
//                RootConfig.class
//        };
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{ServletConfig.class};
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
//    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter charFilter = new CharacterEncodingFilter();
//        charFilter.setEncoding("UTF-8");
//        charFilter.setForceEncoding(true);
//
//        return new Filter[]{
//                charFilter
//        };
//    }
//
//}
