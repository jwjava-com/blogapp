/**
 * 
 */
package info.jonwarren.blog.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the h2 database console.
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 * @see {@link https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/}
 */
@Configuration
public class H2WebConfiguration {

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2console/*");
        return registrationBean;
    }
}
