package filter;

import bean.LoginBean;
import dao.HttpTipoAcessosDAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tipo_Acessos;

/**
 *
 * @author Edu
 */
@WebFilter(filterName = "AgendaFilter", urlPatterns = {"/faces/Agenda.xhtml"})
public class AgendaFilter implements Filter {
   

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int acesso = 0;
        try {
            System.out.println("Verificando acesso!");
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            String link = req.getPathInfo();
            LoginBean login = (LoginBean) req.getSession().getAttribute("loginBean");
            if(login != null){
                acesso = verificacao(link, login.pacienteLogado.getTipoAcessos());
            }
            if((login!=null && acesso != 0) || link.equals("/login.xhtml"))
                chain.doFilter(request, response);
            else
                resp.sendRedirect(req.getContextPath()+"/faces/login.xhtml");
        } catch (Exception ex) {
            System.out.println(ex);
        }
   
    }
    
    private int verificacao(String link, int acesso) throws Exception{
        Tipo_Acessos tipoAcesso = HttpTipoAcessosDAO.buscar(acesso);
        
        switch(link){
            case "/Agenda.xhtml":
                return tipoAcesso.getAgendaTipoAcessos();
            case "/ListaPacientes.xhtml":
                return tipoAcesso.getPacienteTipoAcessos();
            case "/CadastroPaciente.xhtml":
                return tipoAcesso.getPacienteTipoAcessos();
            default:
                return 0;
        }
    }

   
    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
    }

   
}
