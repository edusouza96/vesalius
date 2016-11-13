package ws;

import com.google.gson.Gson;
import dao.ProcedimentoDAO;
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
import model.Procedimento;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("procedimento")
public class ProcedimentoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProcedimentoWS
     */
    public ProcedimentoWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ProcedimentoWS
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
        List<Procedimento> lista;
        ProcedimentoDAO dao = new ProcedimentoDAO();
        lista = dao.listar();
       
        Gson g = new Gson();
        return g.toJson(lista);
    }
 
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        Gson g = new Gson();
        Procedimento procedimento = (Procedimento) g.fromJson(content, Procedimento.class);
        ProcedimentoDAO dao =  new ProcedimentoDAO();
        dao.salvar(procedimento);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Procedimento procedimento = (Procedimento) g.fromJson(content, Procedimento.class);
        ProcedimentoDAO dao =  new ProcedimentoDAO();
        dao.salvar(procedimento);
    }
    
    /*@DELETE
    @Path("excluir/{idProcedimento}")
    public void excluir(@PathParam("idProcedimento") int idProcedimento) {
        Procedimento procedimento = new Procedimento();
        procedimento.setIdProcedimento(idProcedimento);
        ProcedimentoDAO dao = new ProcedimentoDAO();
        dao.deletar(procedimento);
    }*/
    
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Procedimento procedimento = (Procedimento) g.fromJson(content, Procedimento.class);
        ProcedimentoDAO dao =  new ProcedimentoDAO();
        dao.deletar(procedimento);
    }
}
