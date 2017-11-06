package edu.matc.restdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.restdemo.entity.User;
import edu.matc.restdemo.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/getusers")
public class RetrieveUser {
    private final Logger log = Logger.getLogger(this.getClass());

    @GET
    @Produces("text/html")
    public Response getMessage() {
        UserDao userDao = new UserDao();
        List<User> users = userDao.getAllUsers();
        ObjectMapper mapper = new ObjectMapper();
        String output = null;
        try {
            output = mapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: " + e);
        }
        return Response.status(200).entity(output).build();
    }


    @GET
    @Path("/{login}")
    @Produces("text/html")
    public Response getMessage(@PathParam("login") String login) {
        UserDao userDao = new UserDao();
        User user = userDao.getUser(login);
        ObjectMapper mapper = new ObjectMapper();
        String output = null;
        try {
            output = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: " + e);
        }
    return Response.status(200).entity(output).build();
    }


}