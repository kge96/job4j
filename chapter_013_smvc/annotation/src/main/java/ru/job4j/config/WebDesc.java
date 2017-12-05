package ru.job4j.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.12.2017.
 */
public class WebDesc extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringRootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"*.do"};
    }
}
