package org.sgitario.quarkus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* import javax.inject.Inject; */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.cache.NoCache;

/* import io.quarkus.security.identity.SecurityIdentity; */

@Path("/api/user")
public class UserResource {

   /*  @Inject
    SecurityIdentity identity; */
    @GET
    @Path("/me")
    @Produces(MediaType.APPLICATION_JSON)
    @NoCache
    public User me() {
        return new User();
    }

    public static class User {

        private final String userName;
        private final Set<String> roles;

       /*  User(SecurityIdentity identity) {
            this.userName = identity.getPrincipal().getName();
            this.roles = identity.getRoles();
        } */

        User() {

            String arr[] = { "user", "admin" };

            this.userName = "test";// identity.getPrincipal().getName();""
            this.roles = new HashSet<>(Arrays.asList(arr));
        }

        public String getUserName() {
            return userName;
        }

        public Set<String> getRoles() {
            return roles;
        }
    }
}