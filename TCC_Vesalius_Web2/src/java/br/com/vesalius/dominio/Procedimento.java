package br.com.vesalius.dominio;

/**
 * Classe procedimento, responsável por modelar o objeto referente aos procedimentos realizados na clinica
 * @author Edu
 */
public class Procedimento{
    private int idProcedimento;
    private String nomeProcedimento;
    private double valorProcedimento;

    public Procedimento() {
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    public double getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(double valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

    public Procedimento(int idProcedimento, String nomeProcedimento, double valorProcedimento) {
        this.idProcedimento = idProcedimento;
        this.nomeProcedimento = nomeProcedimento;
        this.valorProcedimento = valorProcedimento;
    }    
}
