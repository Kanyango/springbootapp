package com.lengolyte.config;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.lengolyte.domain.ChartInfo;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan("com.lengolyte")
public class ApplicationConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	@Value("${app.name:lengolyte}")
	private String appName;
	
	@Value("${spark.home}")
	private String sparkHome;
	
	@Value("${master.uri:local}")
	private String masterUri;
	
	@Override
	public void configureDefaultServletHandling
				(DefaultServletHandlerConfigurer configurer)
				{
					configurer.enable();
				}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() 
	{
	       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	       resolver.setViewClass(JstlView.class);
	       resolver.setPrefix("/WEB-INF/views/");
	       resolver.setSuffix(".jsp");
	       
	       return resolver;
	}
	
	@Bean
	public SparkConf sparkConf()
	{
		 SparkConf sparkConf = new SparkConf()
				.setAppName(appName)
				.setSparkHome(sparkHome)
				.setMaster(masterUri);
		 
		 return sparkConf;
	}
	
	@Bean
	public JavaSparkContext javaSparkContext()
	{
		return new JavaSparkContext(sparkConf());
	}
	
	@Bean
	public SparkSession sparkSession()
	{
		return SparkSession
				.builder()
				.sparkContext(javaSparkContext().sc())
				.appName("lengolytics")
				.getOrCreate();
		
	}
	
	
//	@Bean
//	public ChartInfo chartFields()
//	{
//		
//		//List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
//		
//		return  chartFields();
//		
//	}
	
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
		{
			return new PropertySourcesPlaceholderConfigurer();
		}	
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
        		.addResourceLocations("/assets/");
    }
}
