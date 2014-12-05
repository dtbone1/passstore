package com.home.passstore.test.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.home.passstore.dao.User;
import com.home.passstore.dao.UserDao;

@Configuration
@EnableWebMvc
@ComponentScan("com.home.passstore")
public class WebappConfigTest extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.mediaType("html", MediaType.TEXT_HTML);
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	@Bean
    public ViewResolver viewResolver() {
        ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
        contentNegotiatingViewResolver.setViewResolvers(viewResolvers());
        contentNegotiatingViewResolver.setDefaultViews(defaultView());
        return contentNegotiatingViewResolver;
    }

    private List<View> defaultView() {
        return Arrays.<View> asList(new MappingJackson2JsonView());
    }

    private List<ViewResolver> viewResolvers() {
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/views/");
        jspViewResolver.setSuffix(".jsp");

        List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
        viewResolvers.add(jspViewResolver);

        return viewResolvers;
    }

	
}
