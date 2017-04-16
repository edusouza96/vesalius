package ws;

import com.google.gson.Gson;
import dao.FinanceiroDAO;
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
import model.Financeiro;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("financeiro")
public class FinanceiroWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FinanceiroWS
     */
    public FinanceiroWS() {
    }

    /**
     * Retrieves representation of an instance of ws.FinanceiroWS
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
        Financeiro financeiro = new Financeiro();
        financeiro.setIdFinanceiro(id);
        FinanceiroDAO dao = new FinanceiroDAO();
        financeiro = dao.procurarPorId(id);
        Gson g = new Gson();
        return g.toJson(financeiro);
    }
    
    @GET
    @Produces("application/json")
    @Path("listar")
    public String lista() {
        List<Financeiro> lista;
        FinanceiroDAO dao = new FinanceiroDAO();
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @GET
    @Produces("application/json")
    @Path("listaFiltrada")
    public String listaFiltrada() {
        List<Financeiro> lista;
        FinanceiroDAO dao = new FinanceiroDAO();
        lista = dao.listaFiltrada();
        Gson g = new Gson();
        return g.toJson(lista);
    }
 
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        Gson g = new Gson();
        Financeiro financeiro = (Financeiro) g.fromJson(content, Financeiro.class);
        FinanceiroDAO dao =  new FinanceiroDAO();
        dao.salvar(financeiro);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Financeiro financeiro = (Financeiro) g.fromJson(content, Financeiro.class);
        FinanceiroDAO dao =  new FinanceiroDAO();
        dao.salvar(financeiro);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Financeiro financeiro = (Financeiro) g.fromJson(content, Financeiro.class);
        FinanceiroDAO dao =  new FinanceiroDAO();
        dao.deletar(financeiro);
    }
}
