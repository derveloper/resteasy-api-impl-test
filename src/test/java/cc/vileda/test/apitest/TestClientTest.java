package cc.vileda.test.apitest;

import org.junit.Test;

import javax.ws.rs.core.Response;

import java.net.URI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestClientTest {

    private String baseUri = "http://localhost:8080/api-test";
    private TestClient testClient = new TestClient(baseUri);

    @Test
    public void test1() throws Exception {
        assertThat(testClient.test(), is("Hello World!"));
    }

    @Test
    public void test2() throws Exception {
        assertThat(testClient.test2("foo"), is("foo"));
    }

    @Test
    public void test3() throws Exception {
        assertThat(testClient.test3(new TestRequest("foo")).getId(), is(new TestResponse("foo").getId()));
    }

    @Test
    public void test4() throws Exception {
        Response foo = testClient.test4("foo");
        URI uri = new URI(baseUri +"/test4/foo");
        assertThat(foo.getLocation(), is(uri));
    }
}