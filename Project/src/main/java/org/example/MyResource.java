package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import jakarta.inject.Singleton;

import java.time.LocalDate;

/**
 * Root resource (exposed at "myresource" path)
 */
@Singleton
@Path("myresource")
public class MyResource {

    int count = 0;
    @Context HttpHeaders headers;
    @Context UriInfo uriInfo;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(
            @HeaderParam("apiKey") String apiKey,
            @CookieParam("username") String username
    ) {

        System.out.println(headers.getDate());
        System.out.println(headers.getLanguage());
        System.out.println(headers.getMediaType());
        System.out.println(headers.getCookies());
        System.out.println("---------------");
        System.out.println(uriInfo.getAbsolutePath());
        System.out.println(uriInfo.getPathSegments());
        System.out.println(uriInfo.getQueryParameters());
        System.out.println(uriInfo.getQueryParameters().get("locId"));

        count += 1;

        return "Got it! " + count + " name: " + username + " , apiKey: " + apiKey;
    }


}
