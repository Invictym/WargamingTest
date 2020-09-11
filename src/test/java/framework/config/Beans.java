package framework.config;

import framework.entity.BrowserValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class Beans {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(true);
        configurer.setIgnoreUnresolvablePlaceholders(true);

        List<Resource> resources = new ArrayList<>();
        resources.add(new ClassPathResource("browser.properties"));

        configurer.setLocations(resources.toArray(new Resource[]{}));

        return configurer;
    }
    private boolean isRemote = false;
    private String host = "";
    private String browser = "";
    private int port = -1;
    private String url = "";
    private long timeout = 0;

    @Bean
    @Lazy
    public static BrowserValues browserValues(@Value("${browser.url}") String url,
                                              @Value("${browser.timeout}") int timeout,
                                              @Value("${browser.browser}") String browser,
                                              @Value("${browser.port}") int port,
                                              @Value("${browser.host}") String host,
                                              @Value("${browser.remote}") boolean isRemote) {
    return new BrowserValues(isRemote, host, browser, port, url, timeout);
    }
}
