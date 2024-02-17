package com.vh.springquickstart.configuration.security;

import com.vh.springquickstart.core.usecase.GetSubjectUseCase;
import com.vh.springquickstart.core.usecase.GetUserByUserNameUseCase;
import com.vh.springquickstart.shared.adapters.UserEntityAdapter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private GetSubjectUseCase subjectUseCase;

    @Autowired
    private GetUserByUserNameUseCase getUserByUserNameUseCase;

    @Autowired
    private UserEntityAdapter userEntityAdapter;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = retrieveToken(request);
        if (token != null) {
            var subject = subjectUseCase.getSubject(token);
            var user = userEntityAdapter.toUserEntity(getUserByUserNameUseCase.getUserByUserName(subject));
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }

    private String retrieveToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || authHeader.isBlank() || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer", "");
    }

}
