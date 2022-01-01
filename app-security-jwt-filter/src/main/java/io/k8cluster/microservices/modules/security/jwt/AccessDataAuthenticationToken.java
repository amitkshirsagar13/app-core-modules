package io.k8cluster.microservices.modules.security.jwt;

import io.k8cluster.microservices.modules.access.model.AccessData;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class AccessDataAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final AccessData accessData;
    private final boolean test;
    private final boolean federated;

    public AccessDataAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,
                                         AccessData accessData, boolean isTest, boolean federated) {
        super(principal, credentials, authorities);
        this.accessData = accessData;
        this.test = isTest;
        this.federated = federated;
    }
}
