package com.example.concurrentpayment.config;

import com.example.concurrentpayment.support.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import lombok.NoArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@NoArgsConstructor
@OpenAPIDefinition(
        info = @Info(
                title = "선착순 이벤트 결제 시스템 API",
                description = "선착순 이벤트 결제 시스템 프로젝트에 사용되는 API 명세",
                version = "v1"
        )
)
public class SwaggerConfig {

    @Bean
    @Profile("!Prod") // 특정 환경에서 Swagger를 비활성화 할 때
    public OpenAPI customOpenAPI() {
        String jwtSchemeName = JwtTokenProvider.AUTHORIZATION_HEADER;
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme(JwtTokenProvider.BEARER_TYPE)
                        .bearerFormat(JwtTokenProvider.TYPE));

        // Swagger UI 접속 후, 딱 한 번만 accessToken을 입력해주면 모든 API에 토큰 인증 작업이 적용
        return new OpenAPI()
                .addSecurityItem(securityRequirement)
                .components(components);
    }

    @Bean
    public GroupedOpenApi publicApi() {
        String paths[] = {"/apis/v1/**"};

        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch(paths)
                .build();
    }

}

