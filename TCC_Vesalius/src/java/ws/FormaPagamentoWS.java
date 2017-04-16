package ws;

import com.google.gson.Gson;
import dao.FormaPagamentoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Forma_Pagamento;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("formaPagamento")
public class FormaPagamentoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FormaPagamentoWS
     */
    public FormaPagamentoWS() {
    }

    /**
     * Retrieves representation of an instance of ws.FormaPagamentoWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return " ";
    }
   
    @GET
    @Produces("application/json")
    @Path("busca/{id}")
    public String busca(@PathParam("id") int id){
        Forma_Pagamento fPagamento = new Forma_Pagamento();
        fPagamento.setIdFormaPagamento(id);
        FormaPagamentoDAO dao = new FormaPagamentoDAO();
        fPagamento = dao.procurarPorId(id);
        Gson g = new Gson();
        return g.toJson(fPagamento);
    }
   
    @GET
    @Produces("application/json")
    @Path("listar")
    public String lista() {
        List<Forma_Pagamento> lista;
        FormaPagamentoDAO dao = new FormaPagamentoDAO();
        lista = dao.listar();
       
        Gson g = new Gson();
        return g.toJson(lista);
    }
}
