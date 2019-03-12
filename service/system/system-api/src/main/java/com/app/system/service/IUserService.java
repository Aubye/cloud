package com.app.system.service;

import com.app.system.domain.dto.UserDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/user")
public interface IUserService {

    @GET
    String getUser();

    @GET
    @Path("/all")
    List<UserDTO> getAllUsers();

}
