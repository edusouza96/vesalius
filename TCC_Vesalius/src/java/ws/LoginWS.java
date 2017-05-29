package ws;

import com.google.gson.Gson;
import dao.LoginDAO;
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
import model.Login;

/**
 * REST Web Service
 *
 * @author Edu
 */
@Path("login")
public class LoginWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginWS
     */
    public LoginWS() {
    }

    /**
     * Retrieves representation of an instance of ws.LoginWS
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
        Login login = new Login();
        login.setIdLogin(id);
        LoginDAO dao = new LoginDAO();
        login = dao.procurarPorId(id);
        Gson g = new Gson();
        return g.toJson(login);
    }
    
    @GET
    @Produces("application/json")
    @Path("listar")
    public String lista() {
        List<Login> lista;
        LoginDAO dao = new LoginDAO();
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @GET
    @Produces("application/json")
    @Path("procurarPorLogin/{userLogin}/{passwordLogin}")
    public String procurarPorLogin(@PathParam("userLogin") String userLogin, @PathParam("passwordLogin") String passwordLogin) {
        Login login = new Login();
        LoginDAO dao = new LoginDAO();
        login = dao.procurarPorLogin(userLogin, passwordLogin);
        Gson g = new Gson();
        return g.toJson(login);        
    }
 
    @POST
    @Consumes({"application/json"})
    @Path("inserir")
    public void inserir(String content){
        Gson g = new Gson();
        Login login = (Login) g.fromJson(content, Login.class);
        LoginDAO dao =  new LoginDAO();
        dao.salvar(login);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("alterar")
    public void alterar(String content){
        Gson g = new Gson();
        Login login = (Login) g.fromJson(content, Login.class);
        LoginDAO dao =  new LoginDAO();
        dao.salvar(login);
    }
    
    @PUT
    @Consumes("application/json")
    @Path("excluir")
    public void excluir(String content) {
        Gson g = new Gson();
        Login login = (Login) g.fromJson(content, Login.class);
        LoginDAO dao =  new LoginDAO();
        dao.deletar(login);
    }
}
