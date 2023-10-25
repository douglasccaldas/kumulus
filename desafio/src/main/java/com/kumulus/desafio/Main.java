package com.kumulus.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;

@SpringBootApplication
public class Main{

    public static void main (String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    @SuppressWarnings({ "rawtypes", "unchecked" })
    ServletRegistrationBean jsfServletRegistration (ServletContext servletContext) {
        //Ativação do Spring boot 
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

        //Registrando o FacesServlet
		ServletRegistrationBean srb = new ServletRegistrationBean();
        srb.setServlet(new FacesServlet());
        srb.setUrlMappings(Arrays.asList("*.xhtml"));
        srb.setLoadOnStartup(1);
        return srb;
    }
}