package ws;

import com.google.gson.Gson;
import dao.AgendaDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Agenda;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("agenda")
public class AgendaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AgendaWS
     */
    public AgendaWS() {
    }

    /**
     * Retrieves representation of an instance of ws.AgendaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "Meu primeiro WebService RestFull";
    }
   @GET
    @Produces("application/json")
    @Path("listar")
    public String lista() {
        List<Agenda> lista;
        AgendaDAO dao = new AgendaDAO();
        lista = dao.listar();
       
        Gson g = new Gson();
        return g.toJson(lista);
    }
 
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        Gson g = new Gson();
        Agenda agenda = (Agenda) g.fromJson(content, Agenda.class);
        AgendaDAO dao =  new AgendaDAO();
        dao.salvar(agenda);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Agenda agenda = (Agenda) g.fromJson(content, Agenda.class);
        AgendaDAO dao =  new AgendaDAO();
        dao.salvar(agenda);
    }
    
    /*@DELETE
    @Path("excluir/{idAgenda}")
    public void excluir(@PathParam("idAgenda") int idAgenda) {
        Agenda agenda = new Agenda();
        agenda.setIdAgenda(idAgenda);
        AgendaDAO dao = new AgendaDAO();
        dao.deletar(agenda);
    }*/
    
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Agenda agenda = (Agenda) g.fromJson(content, Agenda.class);
        AgendaDAO dao =  new AgendaDAO();
        dao.deletar(agenda);
    }
    
    @GET
    @Produces("application/json")
    @Path("consultasPorPaciente/{id}")
    public String busca(@PathParam("id") int id){
        List<Agenda> lista;
        AgendaDAO dao = new AgendaDAO();
        lista = dao.consultasPorPaciente(id);
       
        Gson g = new Gson();
        return g.toJson(lista);
    }
}
