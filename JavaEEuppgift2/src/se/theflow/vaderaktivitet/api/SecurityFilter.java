package se.theflow.vaderaktivitet.api;


import sun.misc.BASE64Decoder;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    private static final String SECURED_URL_PREFIX = "secured";

    //@Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
            List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if (authHeader != null && authHeader.size() > 0) {
                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
                byte[] credDecoded = new BASE64Decoder().decodeBuffer(String.valueOf(authToken));
                String credentials = new String(credDecoded);
                StringTokenizer tokenizer = new StringTokenizer(credentials, ":");
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();

                if ("user".equals(username) && "password".equals(password)) {
                    return;
                }
            }
            Response unautherizedStatus = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the resource.")
                    .build();
            containerRequestContext.abortWith(unautherizedStatus);
        }
    }
}
