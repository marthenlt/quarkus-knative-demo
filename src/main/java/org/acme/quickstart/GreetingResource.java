package org.acme.quickstart;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.quickstart.service.QuoteOfTheDay;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

	@ConfigProperty(name="message", defaultValue = "Quarkus!")
	private String loadFromProperty;
	
	@Inject
	QuoteOfTheDay quoteOfTheDay;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @Path("/greet")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        return loadFromProperty;
    }
    
    @Path("/quote/{index}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String quote(@PathParam("index") int index) {
        return quoteOfTheDay.getQuote(index);
    }
    
}