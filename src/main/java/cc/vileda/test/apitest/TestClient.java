package cc.vileda.test.apitest;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;

public class TestClient {

    private final TestResource proxy;

    public TestClient(final String baseUri) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(baseUri);
        proxy = target.proxy(TestResource.class);
    }

    public String test() {
        return proxy.test();
    }

    public String test2(String id) {
        return proxy.test2(id);
    }

    public TestResponse test3(TestRequest request) {
        return proxy.test3(request);
    }

    public Response test4(String id) {
        return proxy.test4(id);
    }
}
