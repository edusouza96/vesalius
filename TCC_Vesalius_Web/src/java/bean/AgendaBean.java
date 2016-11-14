package bean;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import model.Agenda;
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
public class AgendaBean {
    
    private Agenda agendaSelecionada;
    
    public AgendaBean() {
        agendaSelecionada = new Agenda();
    }

   
    public Agenda getAgendaSelecionada() {
        return agendaSelecionada;
    }
    
    public void setAgendaSelecionada(Agenda agendaSelecionada) {
        this.agendaSelecionada = agendaSelecionada;
    }
    
    public Agenda[] getListaAgendas() {
        try {
            return new HttpAgendaDAO().listar();
        } catch (Exception ex) {
            System.out.println("");
            return null;
        } 
    }
    
    public String novo(){
        agendaSelecionada =new Agenda();
        return("/View/index?faces-redirect=true");
    }

    public String adicionar()
    {
        try {
            new HttpAgendaDAO().salvar(agendaSelecionada);
            new HttpAgendaDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(AgendaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(this.novo());
    }

    public String editar(Agenda agenda){
        agendaSelecionada = agenda;
        return("/View/Index?faces-redirect=true");
    }
    public String atualizar()
    {
        try {
            new HttpAgendaDAO().salvar(agendaSelecionada);
             new HttpAgendaDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(AgendaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(this.editar(agendaSelecionada));
    }

    public String remover(Agenda agenda){
        try {
            new HttpAgendaDAO().remover(agenda);
        } catch (Exception ex) {
            Logger.getLogger(PacienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("Agenda?faces-redirect=true");
    }
    
}
