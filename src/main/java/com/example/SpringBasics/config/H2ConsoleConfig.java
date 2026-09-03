package com.example.SpringBasics.config;

import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Manually registers the H2 web console servlet.
 * Required because Spring Boot 4.x autoconfiguration may not
 * register the H2 console servlet automatically.
 *
 * Access at: http://localhost:8080/h2-console
 */
@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<JakartaWebServlet> h2ConsoleServlet() {
        ServletRegistrationBean<JakartaWebServlet> registration =
                new ServletRegistrationBean<>(new JakartaWebServlet(), "/h2-console/*");
        registration.addInitParameter("webAllowOthers", "true");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
