package com.app.system.service;

import com.app.system.domain.dto.UserDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public interface IUserService {

    @GET
    String getUser();

    @GET
    @Path("/all")
    List<UserDTO> getAllUsers();

}
