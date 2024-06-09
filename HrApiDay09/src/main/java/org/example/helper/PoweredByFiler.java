package org.example.helper;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class PoweredByFiler implements ContainerResponseFilter {
    @Context UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
//        responseContext.getHeaders().add("Path", uriInfo.getAbsolutePath());
        responseContext.getHeaders().add("Path", requestContext.getUriInfo().getAbsolutePath());


    }
}