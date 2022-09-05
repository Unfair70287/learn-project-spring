package fourth.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView; 
//相當於mvc-servlet.xml的java程式組態
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"fourth"})
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr1 = new InternalResourceViewResolver();
		irvr1.setPrefix("/WEB-INF/pages/");
		irvr1.setSuffix(".jsp");
		irvr1.setOrder(6);
		return irvr1;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
//		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("Index");
		registry.addRedirectViewController("/list", "memberList");
		registry.addViewController("/ExamMainView").setViewName("Exam");
//		registry.addViewController("/").setViewName("Exam");
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("UTF-8");
		return cmr;
	}
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView myJsonView = new MappingJackson2JsonView();
		myJsonView.setPrettyPrint(true);
		return myJsonView;
	}
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2 = new Jaxb2Marshaller();
		jaxb2.setPackagesToScan("fourth");
		return jaxb2;
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() {
		ContentNegotiatingViewResolver cnvr1 = new ContentNegotiatingViewResolver();
		ArrayList<View> list = new ArrayList<View>();
		list.add(jsonView());
		cnvr1.setDefaultViews(list);
		return cnvr1;
	}

}
