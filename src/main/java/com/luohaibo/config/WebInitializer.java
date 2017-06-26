package com.luohaibo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Created by luohaibo on 2017/6/12.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
