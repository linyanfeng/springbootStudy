package lykos.springboot;

import cn.creditease.bdp.auth.interceptor.AuthInterceptor;
import cn.creditease.bdp.auth.interceptor.LoginSessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author zhiyingyang
 * @version 2017-02-16 19:46
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginSessionInterceptor());
        registry.addInterceptor(new AuthInterceptor());
        super.addInterceptors(registry);
    }
}
