package se.theflow.vaderaktivitet.api;


import se.theflow.vaderaktivitet.business.HashPasswordGenerator;
import se.theflow.vaderaktivitet.repository.UserLogin;
import sun.misc.BASE64Decoder;

import javax.inject.Inject;
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

    @Inject
    private UserLogin userLogin;

    @Inject
    HashPasswordGenerator hashPasswordGenerator;

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

                for (int i = 1; i < userLogin.getAllUsers().size()+1; i++) {
                    String hashedPassword = hashPasswordGenerator.checkPassword(password, i);
                    String checkIfValidUser = userLogin.findUserByUserName(i).getUserName();
                    String checkIfValidPassword = userLogin.findUserByUserName(i).getUserPassword();

                    if (checkIfValidUser.equals(username) && checkIfValidPassword.equals(hashedPassword)) {
                        return;
                    }
                }


            }
            Response unautherizedStatus = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("ACCESS DENIED: to the resource.")
                    .build();
            containerRequestContext.abortWith(unautherizedStatus);
        }
    }
}
