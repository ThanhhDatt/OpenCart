package com.opencart;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

public class OpenCartInitializer extends AbstractDispatcherServletInitializer {
    private static final String SPRING_PROFILE = "jpa";
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext webAppContext = new XmlWebApplicationContext();
        webAppContext.setConfigLocation("classpath:spring/mvc-core-config.xml");
        return webAppContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        XmlWebApplicationContext rootAppContext = new XmlWebApplicationContext();
        rootAppContext.setConfigLocations("classpath:spring/business-config.xml", "classpath:spring/tools-config.xml");
        rootAppContext.getEnvironment().setDefaultProfiles(SPRING_PROFILE);
        return rootAppContext;
    }
    @Override
    protected Filter[] getServletFilters() {
        // Used to provide the ability to enter Chinese characters inside the Owner Form
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        return new Filter[]{characterEncodingFilter};
    }
}
