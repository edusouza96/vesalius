package br.com.vesalius.dominio;

import java.util.Date;

/**
 * Classe Financeiro, responsável por modelar o objeto referente a movimentação de caixa da clinica
 * @author Edu
 */
public class Financeiro{
    private int idFinanceiro;
    private Paciente paciente;
    private int idPaciente;
    private String tituloFinanceiro;
    private String descricaoFinanceiro;
    private double valorFinanceiro;
    private Date vencimentoFinanceiro;
    private String vencimentoFinanceiroStr;
    private boolean tipoFinanceiro;
    private boolean statusFinanceiro;
    private Forma_Pagamento formaPagamento;
    private int idFormaPagamento;
    

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

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getVencimentoFinanceiroStr() {
        return vencimentoFinanceiroStr;
    }

    public void setVencimentoFinanceiroStr(String vencimentoFinanceiroStr) {
        this.vencimentoFinanceiroStr = vencimentoFinanceiroStr;
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

    public Forma_Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Forma_Pagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    
    
}
