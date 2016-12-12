package cc.vileda.test.apitest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public class TestResourceImpl implements TestResource {
    @Context
    UriInfo uriInfo;

    @Override
    public String test() {
        return "Hello World!";
    }

    @Override
    public String test2(String id) {
        return id;
    }

    @Override
    public TestResponse test3(TestRequest request) {
        return new TestResponse(request.getId());
    }

    @Override
    public Response test4(String id) {
        UriBuilder builder = UriBuilder.fromResource(TestResource.class);
        builder.path(id);
        return Response.created(builder.build()).build();
    }
}
