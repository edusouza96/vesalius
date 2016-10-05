package bean;

import dao.*;
import java.util.ArrayList;
import model.Agenda;
import java.util.List;
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
    
    public List<Agenda> getListaAgendas() {
        return new AgendaDAO().listar();
        
    }
    
    public String novo(){
        agendaSelecionada =new Agenda();
        return("/View/index?faces-redirect=true");
    }

    public String adicionar()
    {
        try {
            new HttpExemplo().salvar(agendaSelecionada);
            new HttpExemplo().listar();
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
            new HttpExemplo().salvar(agendaSelecionada);
             new HttpExemplo().listar();
        } catch (Exception ex) {
            Logger.getLogger(AgendaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(this.editar(agendaSelecionada));
    }

    public void remover(Agenda agenda){
        new AgendaDAO().deletar(agenda);
    }
    
}
