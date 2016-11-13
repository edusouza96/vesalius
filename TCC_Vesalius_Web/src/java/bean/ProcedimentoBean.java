package bean;

import dao.HttpProcedimentoDAO;
import java.util.List;
import model.Procedimento;
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
public class ProcedimentoBean {
    
    private Procedimento procedimentoSelecionado;
    
    public ProcedimentoBean() {
        procedimentoSelecionado = new Procedimento();
    }
    
     public Procedimento[] getListaProcedimentos() {
        try {
            return new HttpProcedimentoDAO().listar();
        } catch (Exception ex) {
            return null;
        }
        
    }
   
    public Procedimento getProcedimentoSelecionado() {
        return procedimentoSelecionado;
    }

    public void setProcedimentoSelecionado(Procedimento procedimentoSelecionado) {
        this.procedimentoSelecionado = procedimentoSelecionado;
    }
        
    public String novo(){
        procedimentoSelecionado =new Procedimento();
        return("/procedimento/CadastroProcedimento?faces-redirect=true");
    }

    public String adicionar(){
        try {
            
            new HttpProcedimentoDAO().salvar(procedimentoSelecionado);
            new HttpProcedimentoDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(ProcedimentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        procedimentoSelecionado =new Procedimento();
        return("/procedimento/ListaProcedimentos?faces-redirect=true");
    }

    public String editar(Procedimento procedimento){
        procedimentoSelecionado = procedimento;
        return("/procedimento/CadastroProcedimento?faces-redirect=true");
    }
    public String atualizar()
    {
        try {
            new HttpProcedimentoDAO().salvar(procedimentoSelecionado);
            new HttpProcedimentoDAO().listar();
        } catch (Exception ex) {
            Logger.getLogger(ProcedimentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(this.editar(procedimentoSelecionado));
    }

    public String remover(Procedimento procedimento){
        try {
            new HttpProcedimentoDAO().remover(procedimento);
        } catch (Exception ex) {
            Logger.getLogger(ProcedimentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return("/procedimento/ListaProcedimentos?faces-redirect=true");
    }
    
}
