package gamebase.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){

            public void addCorsMappings (CorsRegistry registry){
                registry.addMapping("/").allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET","PUT","POST","DELETE")
                        .maxAge(3600);
            }
        };
    }
}
