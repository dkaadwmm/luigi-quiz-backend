package business;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.QuizSet;
import model.Qwa;

public class QwaService {
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Qwa create(Qwa qwa) {
        QuizUtils.createQwa(qwa);
    }

    @PUT
    @Path("{qwa}")
    @Consumes("application/json")
    @Produces("application/json")
    public Qwa update(Qwa qwa) {
        QuizUtils.updateQwa(qwa);
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Qwa remove(@PathParam("id") int questionID) {
    	QuizUtils.removeQwa(questionID);
    }
}