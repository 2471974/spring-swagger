package guru.spring.swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

//NOTE FOLLOWING ARE AVAILABLE IN SPRINGFOX SWAGGER VER 2.10.5
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//NOTE END

//@EnableSwagger2WebMvc
//@EnableSwagger2WebFlux
@EnableSwagger2
@Configuration
public class SwaggerConfig {


    //NOTE FOLLOWING CODE IS OPTIONAL IF YOU LIKE TO OVERWRITE THE SWAGGER DOCUMENT CONTENTS
    //NOTE CODE BELOW RETURNS WHAT IS DEFAULT TO SWAGGER
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SPRING_WEB.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }
    //NOTE END

    private ApiInfo metaData() {

        Contact contact = new Contact("Arul Rao", "www.arulrao.com", "arulrao@gmail.com");

        return new ApiInfo(
                "Spring Framework Guru by JT",
                "Swagger Magic",
                "1.0",
                "Terms of Service: Hahahhaha",
                contact,
                "Apache License Version 2.0",
                "apache.org",
                new ArrayList<>()
        );
    }
}
















