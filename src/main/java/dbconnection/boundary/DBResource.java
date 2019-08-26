package dbconnection.boundary;

import dbconnection.control.DBManager;
import dbconnection.entity.Temperature;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("db")
@Produces(MediaType.APPLICATION_JSON)
public class DBResource {

    @Inject
    private DBManager dbManager;

    @GET
    public Response selectAll() {
        List<Temperature> temperatures = dbManager.getAllTemperatures();
        return Response.ok(temperatures).build();
    }
}
