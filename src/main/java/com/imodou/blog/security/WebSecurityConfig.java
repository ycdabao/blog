package com.imodou.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //全局
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
  private SpringSecurityUserService springSecurityUserService;  //实现了UserDetailsService接口


    /**
     * @Author: Galen
     * @Description: 配置userDetails的数据源，密码加密格式
     * @Date: 2019/3/28-9:24
     * @Param: [auth]
     * @return: void
     **/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(springSecurityUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * @Author: Galen
     * @Description: 配置放行的资源
     * @Date: 2019/3/28-9:23
     * @Param: [web]
     * @return: void
     **/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/login_p", "/favicon.ico","/resources/**")
                // 给 swagger 放行；不需要权限能访问的资源
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/images/**", "/webjars/**", "/v2/api-docs", "/configuration/ui", "/configuration/security");

    }

    /**
     * @Author: Galen
     * @Description: HttpSecurity包含了原数据（主要是url）
     * 通过withObjectPostProcessor将MyFilterInvocationSecurityMetadataSource和MyAccessDecisionManager注入进来
     * 此url先被MyFilterInvocationSecurityMetadataSource处理，然后 丢给 MyAccessDecisionManager处理
     * 如果不匹配，返回 MyAccessDeniedHandler
     * @Date: 2019/3/27-17:41
     * @Param: [http]
     * @return: void
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                       // o.setSecurityMetadataSource(filterMetadataSource);
                      //  o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                })
                .antMatchers("/admin/**").authenticated()
                .and()
                .formLogin()
               // .loginPage("/login_p")
               // .loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/admin/main.html")
               // .failureHandler(new MyAuthenticationFailureHandler())
               // .successHandler(new MyAuthenticationSuccessHandler())
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
               // .logoutSuccessHandler(new MyLogoutSuccessHandler())
                .permitAll()
                .and().csrf().disable()
                .headers().frameOptions().sameOrigin()

                ;
              //  .exceptionHandling().accessDeniedHandler(deniedHandler);
    }

}
