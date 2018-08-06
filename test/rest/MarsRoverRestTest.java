package rest;

import java.util.concurrent.Future;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import service.MarsRoversService;

public class MarsRoverRestTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MarsRoversService.class);
    }

    @Test
    public void marsRoverRestServiceFormInput1Test() throws Exception {
        Form form = new Form();
        form.param("plateauX", "5")
            .param("plateauY", "5")
            .param("positionX", "1")
            .param("positionY", "2")
            .param("direction", "N")
            .param("instructions", "LMLMLMLMM");
        
        WebTarget target = target("mars");
        Future<String> response = target.request(MediaType.APPLICATION_FORM_URLENCODED)
                  .accept(MediaType.TEXT_PLAIN)
                  .buildPost(Entity.form(form)).submit(String.class);
        
		Assert.assertEquals("1 3 N", response.get());
    }
    
    @Test
    public void marsRoverRestServiceFormInput2Test() throws Exception {
        Form form = new Form();
        form.param("plateauX", "5")
            .param("plateauY", "5")
            .param("positionX", "3")
            .param("positionY", "3")
            .param("direction", "E")
            .param("instructions", "MMRMMRMRRM");
        
        WebTarget target = target("mars");
        Future<String> response = target.request(MediaType.APPLICATION_FORM_URLENCODED)
                  .accept(MediaType.TEXT_PLAIN)
                  .buildPost(Entity.form(form)).submit(String.class);
        
		Assert.assertEquals("5 1 E", response.get());
    }
}
