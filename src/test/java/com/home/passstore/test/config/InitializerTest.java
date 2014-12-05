package com.home.passstore.test.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//This class provides ability to use Java to setup the Web Application instead of using web.xml.
public class InitializerTest extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfigTest.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebappConfigTest.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
