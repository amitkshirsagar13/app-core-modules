package io.k8cluster.microservices.modules.security.jwt;

import io.k8cluster.microservices.modules.security.jwt.cache.JWTVerifierCache;
import io.k8cluster.microservices.modules.security.jwt.config.OAuthApplicationsConfig;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@AutoConfigureBefore(SecurityTokenConfig.class)

public class SelfSignedTokenValidatorConfig {

    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "app.oauth", name = "defaultAuthType", havingValue = "SELFSIGNED")
    TokenValidator selfSignedTokenValidator(OAuthApplicationsConfig oAuthApplicationsConfig, JWTVerifierCache jwtVerifierCache) {
        return new SelfSignedTokenValidator(oAuthApplicationsConfig, jwtVerifierCache);
    }
}
