package com.kino.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.StringUtils;

public class CustomAuthenticationManager implements AuthenticationManager{

    @Autowired
    private RoleDefiner roleDefiner;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getCredentials();

        if (authentication.getClass() != PreAuthenticatedAuthenticationToken.class
                || StringUtils.isEmpty(token)) {
            return null;
        }

        String role = roleDefiner.define(token);
        if (role == null) {
            return null;
        }

        return new TokenAuthentication(role);
    }

    public static class TokenAuthentication extends AbstractAuthenticationToken {

        public TokenAuthentication(String role) {
            super(AuthorityUtils.createAuthorityList(role));
            setAuthenticated(true);
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getPrincipal() {
            return null;
        }
    }
}
