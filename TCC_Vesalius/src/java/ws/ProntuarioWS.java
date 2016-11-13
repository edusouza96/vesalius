package ws;

import com.google.gson.Gson;
import dao.ProntuarioDAO;
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
import model.Prontuario;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("prontuario")
public class ProntuarioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProntuarioWS
     */
    public ProntuarioWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ProntuarioWS
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
        List<Prontuario> lista;
        ProntuarioDAO dao = new ProntuarioDAO();
        lista = dao.listar();
       
        Gson g = new Gson();
        return g.toJson(lista);
    }
 
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        Gson g = new Gson();
        Prontuario prontuario = (Prontuario) g.fromJson(content, Prontuario.class);
        ProntuarioDAO dao =  new ProntuarioDAO();
        dao.salvar(prontuario);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Prontuario prontuario = (Prontuario) g.fromJson(content, Prontuario.class);
        ProntuarioDAO dao =  new ProntuarioDAO();
        dao.salvar(prontuario);
    }
    
    /*@DELETE
    @Path("excluir/{idProntuario}")
    public void excluir(@PathParam("idProntuario") int idProntuario) {
        Prontuario prontuario = new Prontuario();
        prontuario.setIdProntuario(idProntuario);
        ProntuarioDAO dao = new ProntuarioDAO();
        dao.deletar(prontuario);
    }*/
    
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Prontuario prontuario = (Prontuario) g.fromJson(content, Prontuario.class);
        ProntuarioDAO dao =  new ProntuarioDAO();
        dao.deletar(prontuario);
    }
}
