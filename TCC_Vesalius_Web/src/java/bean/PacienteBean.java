package bean;

import dao.HttpPacienteDAO;
import java.util.List;
import model.Paciente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped 
public class PacienteBean {
    
    private Paciente pacienteSelecionado;
    
    public PacienteBean() {
        pacienteSelecionado = new Paciente();
    }
    
     public Paciente[] getListaPacientes() {
        try {
            return new HttpPacienteDAO().listar();
        } catch (Exception ex) {
            return null;
        }
        
    }
   
    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }

    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }
        
    public String novo(){
        pacienteSelecionado =new Paciente();
        return("ListaPacientes?faces-redirect=true");
    }

    public String adicionar(){
        try {
            String nascimento = pacienteSelecionado.getNascimentoPaciente();
            if(!nascimento.equals("")){                
                pacienteSelecionado.setNascimentoPaciente(nascimento+" 00:00:00");
            }else{
                pacienteSelecionado.setNascimentoPaciente("00/00/0000 00:00:00");
            }
            
            String inicio = pacienteSelecionado.getInicioTratamentoPaciente();
            if(!inicio.equals("")){
                pacienteSelecionado.setInicioTratamentoPaciente(inicio+" 00:00:00");
            }else{
                pacienteSelecionado.setInicioTratamentoPaciente("00/00/0000 00:00:00");
            }
            
            String termino = pacienteSelecionado.getTerminoTratamentoPaciente();
            if(!termino.equals("")){
                pacienteSelecionado.setTerminoTratamentoPaciente(termino+" 00:00:00");
            }else{
                pacienteSelecionado.setTerminoTratamentoPaciente("00/00/0000 00:00:00");
            }
            new HttpPacienteDAO().salvar(pacienteSelecionado);
            new HttpPacienteDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(this.novo());
    }

    public String editar(Paciente paciente){
        pacienteSelecionado = paciente;
        return("CadastroPaciente?faces-redirect=true");
    }
    public String atualizar()
    {
        try {
            new HttpPacienteDAO().salvar(pacienteSelecionado);
            new HttpPacienteDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(this.editar(pacienteSelecionado));
    }

    public String remover(Paciente paciente){
        try {
            new HttpPacienteDAO().remover(paciente);
        } catch (Exception ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("ListaPacientes?faces-redirect=true");
    }
    
}
