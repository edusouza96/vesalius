package ws;

import com.google.gson.Gson;
import dao.PacienteDAO;
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
import model.Paciente;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("paciente")
public class PacienteWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PacienteWS
     */
    public PacienteWS() {
    }

    /**
     * Retrieves representation of an instance of ws.PacienteWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "Meu primeiro WebService RestFull";
    }
   
    @GET
    @Produces("application/json")
    @Path("busca/{id}")
    public String busca(@PathParam("id") int id){
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(id);
        PacienteDAO dao = new PacienteDAO();
        paciente = dao.procurarPorId(id);
        Gson g = new Gson();
        return g.toJson(paciente);
    }
    
    @GET
    @Produces("application/json")
    @Path("listar")
    public String lista() {
        List<Paciente> lista;
        PacienteDAO dao = new PacienteDAO();
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }
 
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        Gson g = new Gson();
        Paciente paciente = (Paciente) g.fromJson(content, Paciente.class);
        PacienteDAO dao =  new PacienteDAO();
        dao.salvar(paciente);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Paciente paciente = (Paciente) g.fromJson(content, Paciente.class);
        PacienteDAO dao =  new PacienteDAO();
        dao.salvar(paciente);
    }
    
    /*@DELETE
    @Path("excluir/{idPaciente}")
    public void excluir(@PathParam("idPaciente") int idPaciente) {
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);
        PacienteDAO dao = new PacienteDAO();
        dao.deletar(paciente);
    }*/
    
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Paciente paciente = (Paciente) g.fromJson(content, Paciente.class);
        PacienteDAO dao =  new PacienteDAO();
        dao.deletar(paciente);
    }
}
