package bean;

import bean.PacienteBean;
import dao.HttpTipoAcessosDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Paciente;
import model.Tipo_Acessos;

@ManagedBean
@SessionScoped
public class LoginBean {

    public Paciente pacienteLogado;

   
    public String verificarAcesso(int id, String pagina) {
        try {
            FacesContext contexto = FacesContext.getCurrentInstance();
            PacienteBean pacienteBean = new PacienteBean();
            Paciente[] listaPacientes = pacienteBean.getListaPacientes();
            for (Paciente paciente : listaPacientes) {
                if (paciente.getIdPaciente() == id) {
                    Tipo_Acessos tAcesso  = new HttpTipoAcessosDAO().buscar(paciente.getTipoAcessos());
                    pacienteLogado = paciente;
                    if(tAcesso.getPacienteTipoAcessos() == 1){
                        return ("/"+pagina+"?faces-redirect=true");
                    }else{
                        return ("index?faces-redirect=true");
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ("/Template");
    }


}
