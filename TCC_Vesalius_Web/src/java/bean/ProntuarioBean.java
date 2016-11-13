package bean;

import dao.HttpProntuarioDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.Prontuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.Paciente;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped 
public class ProntuarioBean {
    
    private Prontuario prontuarioSelecionado;
    private Paciente pacienteSelecionado;

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }
    
    public ProntuarioBean() {
        prontuarioSelecionado = new Prontuario();
    }
    
     public List getListaProntuarios() {
        Prontuario[] lista;
        List prontuarios = new ArrayList();
         try {
            lista = new HttpProntuarioDAO().listar();
            for(Prontuario pront: lista){
                if(pront.getPaciente().getIdPaciente() == pacienteSelecionado.getIdPaciente()){
                    prontuarios.add(pront);
                }
            }
           
            return prontuarios;
        } catch (Exception ex) {
            return null;
        }
        
    }
   
    public Prontuario getProntuarioSelecionado() {
        return prontuarioSelecionado;
    }
    
    public void setProntuarioSelecionado(Prontuario prontuarioSelecionado) {
        this.prontuarioSelecionado = prontuarioSelecionado;
    }
        
    public String novo(){
        prontuarioSelecionado =new Prontuario();
        return("/prontuario/CadastroProntuario?faces-redirect=true");
    }
    
    public String view(Paciente paciente){
        this.pacienteSelecionado = paciente;
        return("/prontuario/Prontuario?faces-redirect=true");
    }
    
    public String adicionar(){
        try {
            prontuarioSelecionado.setPaciente(pacienteSelecionado);
            new HttpProntuarioDAO().salvar(prontuarioSelecionado);
            new HttpProntuarioDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(ProntuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        prontuarioSelecionado =new Prontuario();
        return("/prontuario/Prontuario?faces-redirect=true");
    }

    public String editar(Prontuario prontuario){
        prontuarioSelecionado = prontuario;
        return("/prontuario/Prontuario?faces-redirect=true");
    }
    public String atualizar()
    {
        try {
            new HttpProntuarioDAO().salvar(prontuarioSelecionado);
            new HttpProntuarioDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(ProntuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(this.editar(prontuarioSelecionado));
    }

    public String remover(Prontuario prontuario){
        try {
            new HttpProntuarioDAO().remover(prontuario);
        } catch (Exception ex) {
            Logger.getLogger(ProntuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("/prontuario/Prontuario?faces-redirect=true");
    }
    
}
