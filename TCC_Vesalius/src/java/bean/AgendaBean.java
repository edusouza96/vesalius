package bean;

import dao.AgendaDAO;
import java.util.ArrayList;
import model.Agenda;
import java.util.List;
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
        return("/index?faces-redirect=true");
    }

    public String adicionar()
    {
        new AgendaDAO().salvar(agendaSelecionada);
        return(this.novo());
    }

    public String editar(Agenda agenda){
        agendaSelecionada = agenda;
        return("/View/Index?faces-redirect=true");
    }
    public String atualizar()
    {
        new AgendaDAO().salvar(agendaSelecionada);
        return("/View/Index?faces-redirect=true");
    }

    public void remover(Agenda agenda){
        new AgendaDAO().deletar(agenda);
    }
    
}
