package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import static model.Procedimento_.nomeProcedimento;
import static model.Procedimento_.valorProcedimento;

/**
 * Classe Financeiro, responsável por modelar o objeto referente a movimentação de caixa da clinica
 * @author Edu
 */
@Entity
@XmlRootElement
public class Financeiro{
    @Id 
    @GeneratedValue
    private int idFinanceiro;
    @ManyToOne
    private Paciente paciente;
    private String tituloFinanceiro;
    private String descricaoFinanceiro;
    private double valorFinanceiro;
    private Date vencimentoFinanceiro;
    private boolean tipoFinanceiro;
    private boolean statusFinanceiro;
    @ManyToOne
    private Forma_Pagamento formaPagamento;

    public Forma_Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Forma_Pagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    

    public Financeiro() {
    }

    public Financeiro(int idFinanceiro, Paciente paciente, String tituloFinanceiro, String descricaoFinanceiro, double valorFinanceiro, Date vencimentoFinanceiro, boolean tipoFinanceiro, boolean statusFinanceiro) {
        this.idFinanceiro = idFinanceiro;
        this.paciente = paciente;
        this.tituloFinanceiro = tituloFinanceiro;
        this.descricaoFinanceiro = descricaoFinanceiro;
        this.valorFinanceiro = valorFinanceiro;
        this.vencimentoFinanceiro = vencimentoFinanceiro;
        this.tipoFinanceiro = tipoFinanceiro;
        this.statusFinanceiro = statusFinanceiro;
    }

    public int getIdFinanceiro() {
        return idFinanceiro;
    }

    public void setIdFinanceiro(int idFinanceiro) {
        this.idFinanceiro = idFinanceiro;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTituloFinanceiro() {
        return tituloFinanceiro;
    }

    public void setTituloFinanceiro(String tituloFinanceiro) {
        this.tituloFinanceiro = tituloFinanceiro;
    }

    public String getDescricaoFinanceiro() {
        return descricaoFinanceiro;
    }

    public void setDescricaoFinanceiro(String descricaoFinanceiro) {
        this.descricaoFinanceiro = descricaoFinanceiro;
    }

    public double getValorFinanceiro() {
        return valorFinanceiro;
    }

    public void setValorFinanceiro(double valorFinanceiro) {
        this.valorFinanceiro = valorFinanceiro;
    }

    public Date getVencimentoFinanceiro() {
        return vencimentoFinanceiro;
    }

    public void setVencimentoFinanceiro(Date vencimentoFinanceiro) {
        this.vencimentoFinanceiro = vencimentoFinanceiro;
    }

    public boolean isTipoFinanceiro() {
        return tipoFinanceiro;
    }

    public void setTipoFinanceiro(boolean tipoFinanceiro) {
        this.tipoFinanceiro = tipoFinanceiro;
    }

    public boolean isStatusFinanceiro() {
        return statusFinanceiro;
    }

    public void setStatusFinanceiro(boolean statusFinanceiro) {
        this.statusFinanceiro = statusFinanceiro;
    }

    
}
