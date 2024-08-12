package br.com.projetos.gametracker.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@Component
@Log4j2
public class RequestLoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        // Proceed with the next filter in the chain
        filterChain.doFilter(wrappedRequest, wrappedResponse);

        // Log request and response after the request is processed
        logRequestDetails(wrappedRequest);
        logResponseDetails(wrappedResponse);

        // Ensure that the response body is written out
        wrappedResponse.copyBodyToResponse();
    }

    private void logRequestDetails(ContentCachingRequestWrapper request) {
        String requestBody = getRequestBody(request);
        log.info("HTTP METHOD: {} | REQUEST URI: {} | REQUEST BODY: {}", request.getMethod(), request.getRequestURI(), requestBody);
    }

    private void logResponseDetails(ContentCachingResponseWrapper response) {
        String responseBody = getResponseBody(response);
        log.info("RESPONSE STATUS: {} | RESPONSE BODY: {}", response.getStatus(), responseBody);
    }

    private String getRequestBody(ContentCachingRequestWrapper request) {
        byte[] buf = request.getContentAsByteArray();
        return buf.length > 0 ? new String(buf, StandardCharsets.UTF_8) : "";
    }

    private String getResponseBody(ContentCachingResponseWrapper response) {
        byte[] buf = response.getContentAsByteArray();
        return buf.length > 0 ? new String(buf, StandardCharsets.UTF_8) : "";
    }

}
