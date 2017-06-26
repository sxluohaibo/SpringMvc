package com.luohaibo.config;


import com.luohaibo.Interceptor.CommonInterceptor;
import com.luohaibo.util.ArrayUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luohaibo on 2017/6/12.
 */

@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.luohaibo.Interceptor", "com.luohaibo.controller","com.luohaibo.service","com.luohaibo.entity"})
@EnableJpaRepositories(
        basePackages = "com.luohaibo.repository",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
@ImportResource({"classpath:config.xml"})

public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private ApplicationContext applicationContext;



    @Autowired
    private CommonInterceptor commonInterceptor;
////    private  final ThymeleafViewResolver htmlViewResolver;
//
//
////    private MvcConfig(CommonInterceptor commonInterceptor){
////        this.commonInterceptor = commonInterceptor;
////
////    }
//
//
//
//
    //加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/**/*");
//                .addPathPatterns("/alimama/**", "/api/**", "/hotUser/**", "/task/**", "/weChatGroup/**", "/huotao/**", "/widePlace/**").excludePathPatterns("/widePlace/login","/widePlace/update","/widePlace/do");
    }


    //格式转换器
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        super.addFormatters(registry);
//        registry.addFormatterForFieldType(LocalDateTime.class, localDateTimeFormatter);
//        registry.addFormatterForFieldType(BigDecimal.class, bigDecimalConverter);
//        registry.addFormatterForFieldType(Date.class, dateConverter);
//    }


    //以下是一个例子，展示了如何在MVC Java编程配置方式下将所有"/"请求直接转发给名字为"home"的视图：
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
//        registry.addViewController("/home").setViewName("hello");
//        registry.addRedirectViewController("/**/favicon.ico", "/assets/images/_favicon.ico");
//    }


//    //视图解析器
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver(htmlViewResolver());
//        registry.viewResolver(redirectViewResolver());
//        registry.viewResolver(forwardViewResolver());
//    }
//
//    private ViewResolver redirectViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setViewNames(ArrayUtil.array("redirect:*"));
//        return resolver;
//    }
//
//    private ViewResolver forwardViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setViewNames(ArrayUtil.array("forward:*"));
//        return resolver;
//    }


    //消息类型转换器
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);


        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(converter);

//        // 必须确保 json MappingJackson2HttpMessageConverter 比 xml MappingJackson2XmlHttpMessageConverter 优先级高
//        HttpMessageConverter xml = converters.stream().filter(httpMessageConverter
//                -> httpMessageConverter instanceof MappingJackson2XmlHttpMessageConverter)
//                .findAny().orElse(null);
//
//
//
//        HttpMessageConverter json = converters.stream().filter(httpMessageConverter
//                -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter)
//                .findAny().orElse(null);
//
//
//
//        if (xml != null && json != null) {
//            int index = converters.indexOf(xml);
//            converters.remove(json);
//            converters.add(index, json);
//        }
    }



//    @Bean
//    public UrlBasedViewResolver viewResolver() {
//
//        InternalResourceViewResolver url = new InternalResourceViewResolver();
//        url.setPrefix("/View/");
//        url.setSuffix(".jsp");
//        return url;
//    }




    /**
     * thymeleaf解析
     *
     * @return  thymeleaf解析器
     */
    @Bean
    public ThymeleafViewResolver htmlViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(htmlViewTemplateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }




    @Bean
    public SpringTemplateEngine htmlViewTemplateEngine() {

        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/View/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        springTemplateEngine.setTemplateResolver(templateResolver);
        return  springTemplateEngine;
    }


}
