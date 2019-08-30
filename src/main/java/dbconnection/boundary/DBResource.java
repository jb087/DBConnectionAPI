package dbconnection.boundary;

import dbconnection.control.DBManager;
import dbconnection.entity.Temperature;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(DBResource.DB_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class DBResource {

    public static final String DB_PATH = "db";
    private static final String ALL_PATH = "all";
    private static final String SENSOR_MEASUREMENT_PATH = "sensor/{id}";
    private static final String GENERATE_MEASUREMENTS = "generate-measurements";
    @Inject
    private DBManager dbManager;

    @GET
    @Path(ALL_PATH)
    public Response selectAll() {
        List<Temperature> temperatures = dbManager.getAllMeasurement();
        return Response.ok(temperatures).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path(SENSOR_MEASUREMENT_PATH)
    public Response getSensorMeasurement(@PathParam("id") String sensorId) {
        List<Temperature> temperatures = dbManager.getMeasurementForSensor(sensorId);
        return Response.ok(temperatures).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Path(GENERATE_MEASUREMENTS)
    public Response generateMeasurements() {
        dbManager.generateTemperatures();
        return Response.ok().header("Access-Control-Allow-Origin", "*").build();
    }
}
