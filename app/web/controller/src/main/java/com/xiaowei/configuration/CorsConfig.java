package com.xiaowei.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域配置
 *  https://www.cnblogs.com/cityspace/p/6858969.html
 */
@Configuration
public class CorsConfig {
    //这里为支持的请求头，如果有自定义的header字段请自己添加（不知道为什么不能使用*）
    private static final String ALLOWED_HEADERS = "Cache-Control,Content-Language,Content-Type,Expires,Last-Modified,Pragma";
    private static final Long EXPIRSE_TIME = 60 * 60L;

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        //它的值要么是请求时Origin字段的具体值，要么是一个*，表示接受任意域名的请求。
        config.setAllowedOrigins(Arrays.asList("*")); //http:www.a.com
        config.setAllowedHeaders(Arrays.asList("POST"," GET"," OPTIONS"," DELETE","PUT"));
        //它的值是逗号分隔的一个具体的字符串或者*，表明服务器支持的所有跨域请求的方法。
        // 注意，返回的是所有支持的方法，而不单是浏览器请求的那个方法。这是为了避免多次"预检"请求。
        config.setAllowedMethods(Arrays.asList("*"));
        //该字段可选。CORS请求时，XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：
        // Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。如果想拿到其他字段，
        // 就必须在Access-Control-Expose-Headers里面指定。
        config.setExposedHeaders(Arrays.asList(ALLOWED_HEADERS));
        config.setMaxAge(EXPIRSE_TIME);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
