package org.example.helper;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.example.dao.AuthDAO;
import org.example.dto.ErrorMessage;
import org.example.models.Doctors;
import org.example.models.Patients;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Inject
    AuthDAO authentication;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (!requestContext.getUriInfo().getPath().contains("secures")) return;

        List<String> authHeaders = requestContext.getHeaders().get("Authorization");
        if (authHeaders != null && !authHeaders.isEmpty()) {
            String authHeader = authHeaders.get(0);
            authHeader = authHeader.replace("Basic ", "");
            authHeader = new String(Base64.getDecoder().decode(authHeader));
            StringTokenizer tokenizer = new StringTokenizer(authHeader, ":");
            String email = tokenizer.nextToken();
            String password = tokenizer.nextToken();

            try {
                Doctors d = (Doctors) authentication.Auth("DOCTORS", email, password);
                Patients p = (Patients) authentication.Auth("PATIENTS", email, password);

                if (d != null || p != null) {
                    return;
                } else {
                    ErrorMessage err = new ErrorMessage();
                    err.setErrorContent("Invalid email or password");
                    err.setErrorCode(Response.Status.UNAUTHORIZED.getStatusCode());
                    err.setDocumentationUrl("https://google.com");

                    Response res = Response.status(Response.Status.UNAUTHORIZED)
                            .entity(err)
                            .build();

                    requestContext.abortWith(res);
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // No Authorization header
        ErrorMessage err = new ErrorMessage();
        err.setErrorContent("Please login");
        err.setErrorCode(Response.Status.UNAUTHORIZED.getStatusCode());
        err.setDocumentationUrl("https://google.com");

        Response res = Response.status(Response.Status.UNAUTHORIZED)
                .entity(err)
                .build();

        requestContext.abortWith(res);
    }
}
