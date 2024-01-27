package com.example.eureka.service.eureka.filter;// EurekaRequestLoggingFilter.java
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*") // Specify the URL pattern to intercept
public class EurekaRequestLoggingFilter extends OncePerRequestFilter implements Ordered {

    private final Logger logger = LoggerFactory.getLogger(EurekaRequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException {
        try {
            // Log relevant information about the incoming request
            logger.info("Incoming request to Eureka: {} {}", request.getMethod(), request.getRequestURI());

            // Continue the filter chain
            filterChain.doFilter(request, response);
        } finally {
            // Log any additional information or clean-up if needed
        }
    }

    @Override
    public int getOrder() {
        // Set the filter order (should be a value less than 0 to execute before other filters)
        return Ordered.HIGHEST_PRECEDENCE;
    }
}