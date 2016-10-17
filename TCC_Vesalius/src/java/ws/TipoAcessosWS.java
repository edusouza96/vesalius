package ws;

import com.google.gson.Gson;
import dao.TipoAcessosDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Tipo_Acessos;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("tipoAcessos")
public class TipoAcessosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TipoAcessosWS
     */
    public TipoAcessosWS() {
    }

    /**
     * Retrieves representation of an instance of ws.TipoAcessosWS
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
        Tipo_Acessos tAcesso = new Tipo_Acessos();
        tAcesso.setIdTipoAcessos(id);
        TipoAcessosDAO dao = new TipoAcessosDAO();
        tAcesso = dao.procurarPorId(id);
        Gson g = new Gson();
        return g.toJson(tAcesso);
    }
   
}
