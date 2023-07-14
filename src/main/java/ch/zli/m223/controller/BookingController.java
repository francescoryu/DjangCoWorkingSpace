package ch.zli.m223.controller;

import java.util.List;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/bookings")
@RolesAllowed({"Admin", "User"})
@Tag(name = "Bookings", description = "Handling of bookings")
public class BookingController {
    @Inject
    BookingService bookingService;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking getUser(@PathParam("id") Long id, Booking booking) {
        return bookingService.getBooking(id);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all bookings.", description = "Returns a list of all bookings.")
    public List<Booking> index(@Context SecurityContext securityContext) {
        String email = securityContext.getUserPrincipal().getName();
        return bookingService.findAll(email);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new Booking",
        description = "Creates a new category and returns the newly added Booking."
    )
    public Booking create(Booking booking) {
        return bookingService.createBooking(booking);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "Deletes a booking",
        description = "Deletes a booking by its id"
    )
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates an booking",
        description = "Updates a booking by its id"
    )
    public Booking update(@PathParam("id") Long id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }
}