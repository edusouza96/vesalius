package ws;

import com.google.gson.Gson;
import dao.EstoqueDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Estoque;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("estoque")
public class EstoqueWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EstoqueWS
     */
    public EstoqueWS() {
    }

    /**
     * Retrieves representation of an instance of ws.EstoqueWS
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
        List<Estoque> lista;
        EstoqueDAO dao = new EstoqueDAO();
        lista = dao.listar();
       
        Gson g = new Gson();
        return g.toJson(lista);
    }
 
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        Gson g = new Gson();
        Estoque estoque = (Estoque) g.fromJson(content, Estoque.class);
        EstoqueDAO dao =  new EstoqueDAO();
        dao.salvar(estoque);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Estoque estoque = (Estoque) g.fromJson(content, Estoque.class);
        EstoqueDAO dao =  new EstoqueDAO();
        dao.salvar(estoque);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Estoque estoque = (Estoque) g.fromJson(content, Estoque.class);
        EstoqueDAO dao =  new EstoqueDAO();
        dao.deletar(estoque);
    }
    
    @GET
    @Produces("application/json")
    @Path("busca/{id}")
    public String busca(@PathParam("id") int id){
        Estoque estoque = new Estoque();
        estoque.setIdEstoque(id);
        EstoqueDAO dao = new EstoqueDAO();
        estoque = dao.procurarPorId(id);
        Gson g = new Gson();
        return g.toJson(estoque);
    }
}
