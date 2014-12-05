//package com.home.passstore.config;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//Just by extending this class, it loads the necessary springSecurityFilterChain automatically

//The equivalent of Spring Security in web.xml file :
//
//	<filter>
//		<filter-name>springSecurityFilterChain</filter-name>
//		<filter-class>org.springframework.web.filter.DelegatingFilterProxy
//                </filter-class>
//	</filter>
// 
//	<filter-mapping>
//		<filter-name>springSecurityFilterChain</filter-name>
//		<url-pattern>/*</url-pattern>
//	</filter-mapping>

//@Order(2)
//public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
//	//do nothing
//}
