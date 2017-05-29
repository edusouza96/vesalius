package ws;

import com.google.gson.Gson;
import dao.RelatorioDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Relatorio;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("relatorio")
public class RelatorioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RelatorioWS
     */
    public RelatorioWS() {
    }

    /**
     * Retrieves representation of an instance of ws.RelatorioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        return "Meu primeiro WebService RestFull";
    }
   
    @GET
    @Produces("application/json")
    @Path("consultasPorMes/{dataInicio}/{dataFim}/")
    public String consultasPorMes(@PathParam("dataInicio") String dataInicio, @PathParam("dataFim") String dataFim){
        List<Relatorio> lista;
        RelatorioDAO dao = new RelatorioDAO();
        lista = dao.consultasPorMes(dataInicio, dataFim);
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @GET
    @Produces("application/json")
    @Path("pacientesNovosPorMes/{dataInicio}/{dataFim}/")
    public String pacientesNovosPorMes(@PathParam("dataInicio") String dataInicio, @PathParam("dataFim") String dataFim){
        List<Relatorio> lista;
        RelatorioDAO dao = new RelatorioDAO();
        lista = dao.pacientesNovosPorMes(dataInicio, dataFim);
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @GET
    @Produces("application/json")
    @Path("procedimentosMes/{ano}/{mes}/")
    public String procedimentosMes(@PathParam("ano") int ano, @PathParam("mes") int mes){
        List<Relatorio> lista;
        RelatorioDAO dao = new RelatorioDAO();
        lista = dao.procedimentosMes(ano, mes);
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @GET
    @Produces("application/json")
    @Path("financeiroAno/{ano}/")
    public String financeiroAno(@PathParam("ano") int ano){
        List<Relatorio> lista;
        RelatorioDAO dao = new RelatorioDAO();
        lista = dao.financeiroAno(ano);
        Gson g = new Gson();
        return g.toJson(lista);
    }
}
