package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.service.AppUserService;


@Path("/users")
@RolesAllowed({"Admin", "User"})
@Tag(name = "Users", description = "Handling of users")
public class AppUserController {
  
  @Inject
  AppUserService userService;

  @GET
  @RolesAllowed({"Admin"})
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Index all users.", 
      description = "Returns a list of all users."
  )
  public List<AppUser> index() {
      return userService.findAll();
  }

  @Path("/{id}")
  @RolesAllowed({"Admin"})
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public AppUser getUser(@PathParam("id") Long id, AppUser user) {
    return userService.getUser(id);
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Creates a new user. Also known as registration.", 
      description = "Creates a new user and returns the newly added user."
  )
  @PermitAll
  public AppUser create(AppUser user) {
     return userService.createUser(user);
  }

  @Path("/{id}")
  @DELETE
  @RolesAllowed({"Admin"})
  @Operation(
      summary = "Deletes an user.",
      description = "Deletes an user by its id."
  )
  public void delete(@PathParam("id") Long id) {
      userService.deleteUser(id);
  }

  @Path("/{id}")
  @PUT
  
  @Operation(
      summary = "Updates an user.",
      description = "Updates an user by its id."
  )
  public AppUser update(@PathParam("id") Long id, AppUser user) {
      return userService.updateUser(id, user);
  }
}
