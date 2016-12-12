package cc.vileda.test.apitest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TestResource {

    String TEST2_ROUTE = "/test2";
    String TEST4_ROUTE = "/test4";

    @GET
    String test();

    @GET
    @Path(TEST2_ROUTE)
    String test2(@QueryParam("id") final String id);

    @POST
    TestResponse test3(final TestRequest request);

    @GET
    @Path(TEST4_ROUTE)
    Response test4(@QueryParam("id") final String id);
}
