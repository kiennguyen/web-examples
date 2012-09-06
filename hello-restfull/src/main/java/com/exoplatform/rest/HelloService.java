package com.exoplatform.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

@Path("/hello")
public class HelloService
{
   @GET
   @Path("/{param}")
   public Response getMsg(@PathParam("param") String msg)
   {
      String output = "RESTFul hello: " + msg;
      return Response.status(200).entity(output).build();
   }
}
