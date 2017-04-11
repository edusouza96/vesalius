package ws;

import com.google.gson.Gson;
import dao.NotificacaoDAO;
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
import model.Notificacao;
import model.Paciente;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("notificacao")
public class NotificacaoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NotificacaoWS
     */
    public NotificacaoWS() {
    }

    /**
     * Retrieves representation of an instance of ws.NotificacaoWS
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
        List<Notificacao> lista;
        NotificacaoDAO dao = new NotificacaoDAO();
        lista = dao.listar();
       
        Gson g = new Gson();
        return g.toJson(lista);
    }
 
    @GET
    @Produces("application/json")
    @Path("inserirFcm/{token}/{idPaciente}")
    public String inserirFcm(@PathParam("token") String token, @PathParam("idPaciente") int idPaciente) {
        Notificacao notificacao = new Notificacao();
        notificacao.setTokenNotificacao(token);
        Paciente pac = new Paciente();
        pac.setIdPaciente(idPaciente);
        notificacao.setPaciente(pac);
        NotificacaoDAO dao =  new NotificacaoDAO();
        dao.salvar(notificacao);
        return "";
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        System.out.println("verificação");
        System.out.println(content);
        Gson g = new Gson();
        Notificacao notificacao = (Notificacao) g.fromJson(content, Notificacao.class);
        NotificacaoDAO dao =  new NotificacaoDAO();
        dao.salvar(notificacao);
    }
    
    @GET
    @Produces("application/json")
    @Path("buscaToken/{id}")
    public String buscaToken(@PathParam("id") int id){
        List<Notificacao> lista;
        NotificacaoDAO dao = new NotificacaoDAO();
        lista = dao.listarToken(id);
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Notificacao notificacao = (Notificacao) g.fromJson(content, Notificacao.class);
        NotificacaoDAO dao =  new NotificacaoDAO();
        dao.salvar(notificacao);
    }
        
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Notificacao notificacao = (Notificacao) g.fromJson(content, Notificacao.class);
        NotificacaoDAO dao =  new NotificacaoDAO();
        dao.deletar(notificacao);
    }
}
