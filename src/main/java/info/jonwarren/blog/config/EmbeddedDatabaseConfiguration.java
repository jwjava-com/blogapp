/**
 * 
 */
package info.jonwarren.blog.config;

import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Configuration class for the embedded database.
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
@Configuration
@EnableAutoConfiguration
public class EmbeddedDatabaseConfiguration {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource dataSource() throws URISyntaxException {
        String dsUrl = env.getProperty("BLOG_DS_URL", "");
        String dsUsr = env.getProperty("BLOG_DS_USR", "");
        String dsPwd = env.getProperty("BLOG_DS_PWD", "");

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dsUrl);
        dataSource.setUsername(dsUsr);
        dataSource.setPassword(dsPwd);

        return dataSource;
    }

    /**
     * Configuration for the h2 database console.
     * 
     * @return
     * @see {@literal https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/}
     */
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2console/*");
        return registrationBean;
    }
}
