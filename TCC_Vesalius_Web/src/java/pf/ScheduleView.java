package pf;

import bean.AgendaBean;
import dao.HttpAgendaDAO;
import dao.HttpPacienteDAO;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Agenda;
import model.Paciente;
 
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
 
@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {
 
    private ScheduleModel eventModel;
     
    private ScheduleModel lazyEventModel;
 
    private ScheduleEvent event = new DefaultScheduleEvent();
 
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        try {
            Agenda[] agenda = new HttpAgendaDAO().listar();
            for(Agenda a : agenda){
                eventModel.addEvent(new DefaultScheduleEvent(a.getPaciente().getNomePaciente(), a.getDataAgenda(),horaFinal(a.getDataAgenda()),a));
            }
        } catch (Exception ex) {
        }
        lazyEventModel = new LazyScheduleModel() {
             
            @Override
            public void loadEvents(Date start, Date end) {
                Date random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));
                 
                random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
            }   
        };
    }
     
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
         
        return date.getTime();
    }
     
    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
         
        return calendar.getTime();
    }
     
    public ScheduleModel getEventModel() {
        return eventModel;
    }
     
    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }
 
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
     
    private Date horaFinal(Date dataAgenda) {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.setTime(dataAgenda);
        t.add(Calendar.MINUTE, 30); 
        return t.getTime();
    }
    
    public ScheduleEvent getEvent() {
        return event;
    }
 
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null){
            eventModel.addEvent(event);
            try {
                Paciente[] listaPaciente = new HttpPacienteDAO().listar();
                Paciente paciente = new Paciente();
                for(Paciente pac: listaPaciente){
                    if(pac.getNomePaciente().equalsIgnoreCase(event.getTitle())){
                        paciente = pac;
                    }
                }
                Agenda agenda = new Agenda(paciente,event.getStartDate() , 2);
                AgendaBean agendaBean = new AgendaBean();
                agendaBean.setAgendaSelecionada(agenda);
                agendaBean.adicionar();
            } catch (Exception ex) {
                System.err.println(ex);
            }
            
            
        }else{
            eventModel.updateEvent(event);
            Agenda agenda = (Agenda)event.getData();
            agenda.setDataAgenda(event.getStartDate());
            AgendaBean agendaBean = new AgendaBean();
            agendaBean.setAgendaSelecionada(agenda);
            agendaBean.atualizar();
        }
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), horaFinal((Date)selectEvent.getObject()));
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta Movida", "");
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta extendida", "");
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}