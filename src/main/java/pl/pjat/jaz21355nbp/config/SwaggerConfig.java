//package pl.pjat.jaz21355nbp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Collections;
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket atividadeApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("pl.pjat.jaz21355nbp"))
//                .paths(PathSelectors.any())
//                .build().apiInfo(myApiInfo());
//
//    }
//    private ApiInfo myApiInfo() {
//        return new ApiInfo(
//                "API Documentation",
//                "API Documentation\"",
//                "over9000",
//                "NbpService",
//                new Contact("Szymon Ciemny", "localhost:8080", "s21355@pjwstk.edu.pl"),
//                "Nice license", "localhost:8080", Collections.emptyList());
//
//    }
//}