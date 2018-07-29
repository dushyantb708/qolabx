package com.qolabx.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.qolabx.config.ApplicationConfiguration;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	 protected Class < ? > [] getRootConfigClasses() {
	  return new Class[] {
	   ApplicationConfiguration.class
	  };
	 }
	 @Override
	 protected Class < ? > [] getServletConfigClasses() {
	  return null;
	 }
	 @Override
	 protected String[] getServletMappings() {
	  return new String[] {
	   "/rest/*"
	  };
	 }
}
