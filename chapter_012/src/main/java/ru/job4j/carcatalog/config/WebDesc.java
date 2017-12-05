package ru.job4j.carcatalog.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Class for creating webdesc.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.12.2017.
 */
public class WebDesc extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"*.do"};
    }
}
