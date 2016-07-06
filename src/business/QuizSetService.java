package business;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class QuizSetService {

    @Path("/quizsetservice")
    public class PoundToEuroConverter {

        @GET
        @Produces("application/json")
        public Response convertPoundToEuro() throws JSONException {
            JSONObject jsonObject = new JSONObject();
            Double pound = 1d;
            Double euro = pound * 1.24671d;

            jsonObject.put("Pound value", pound);
            jsonObject.put("Euro value", euro);

            return Response.status(200).entity(jsonObject).build();
        }

        @Path("{p}")
        @GET
        @Produces("application/json")
        public Response convertEuroToPound(@PathParam("p") Double p) throws JSONException {
            JSONObject jsonObject = new JSONObject();
            Double euro = 1d;
            Double pound = euro * 1.24671d;

            jsonObject.put("Pound value", pound);
            jsonObject.put("Euro value", euro);

            return Response.status(200).entity(jsonObject).build();
        }
    }
}
