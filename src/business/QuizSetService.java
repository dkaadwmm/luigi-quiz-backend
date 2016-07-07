package business;

import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.QuizSet;

@Path("/quizsetservice")
public class QuizSetService {

	@GET
    @Produces("application/json")
	public Response getQuizSetAllAnswers() {
		Gson gson = new GsonBuilder().create();
        QuizSet quizSet = QuizUtils.generateRandomQuizSet(9);
        StringWriter stringWriter = new StringWriter();
        gson.toJson(quizSet, stringWriter);
        return Response.status(200).entity(stringWriter.toString()).build();
	}
	
    @Path("{count}")
    @GET
    @Produces("application/json")
    public Response getQuizSetSomeAnswers(@PathParam("count") int count) throws JSONException {
    	return null;
    }
}