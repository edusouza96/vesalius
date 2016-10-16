package bean;

import dao.PacienteDAO;
import java.util.ArrayList;
import model.Paciente;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped 
public class PacienteBean {
    
    private Paciente pacienteSelecionada;
    
    public PacienteBean() {
        pacienteSelecionada = new Paciente();
    }

   
    public Paciente getPacienteSelecionada() {
        return pacienteSelecionada;
    }

    public void setPacienteSelecionada(Paciente pacienteSelecionada) {
        this.pacienteSelecionada = pacienteSelecionada;
    }
    
    public List<Paciente> getListaPacientes() {
        return new PacienteDAO().listar();
        
    }
    
    public String novo(){
        pacienteSelecionada =new Paciente();
        return("/index?faces-redirect=true");
    }

    public String adicionar()
    {
        new PacienteDAO().salvar(pacienteSelecionada);
        return(this.novo());
    }

    public String editar(Paciente paciente){
        pacienteSelecionada = paciente;
        return("/View/Index?faces-redirect=true");
    }
    public String atualizar()
    {
        new PacienteDAO().salvar(pacienteSelecionada);
        return("/View/Index?faces-redirect=true");
    }

    public void remover(Paciente paciente){
        new PacienteDAO().deletar(paciente);
    }
    
}
