package model;

import java.util.Date;

/**
 * Classe prontuario, responsável por modelar o objeto referente as consultas do paciente
 * @author Edu
 */

public class Prontuario{
    private int idProntuario;
    private Date dataProntuario;
    private String denteProntuario;
    private String descricaoProntuario;
    private double tempoProntuario;
    private Paciente paciente;
    private Procedimento procedimento;
    private int idProcedimento;

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }
     
    public Prontuario() {
    }

    public Prontuario(Date dataProntuario, String denteProntuario, String descricaoProntuario, double tempoProntuario, Paciente paciente, Procedimento procedimento) {
        this.dataProntuario = dataProntuario;
        this.denteProntuario = denteProntuario;
        this.descricaoProntuario = descricaoProntuario;
        this.tempoProntuario = tempoProntuario;
        this.paciente = paciente;
        this.procedimento = procedimento;
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Date getDataProntuario() {
        return dataProntuario;
    }

    public void setDataProntuario(Date dataProntuario) {
        this.dataProntuario = dataProntuario;
    }

    public String getDenteProntuario() {
        return denteProntuario;
    }

    public void setDenteProntuario(String denteProntuario) {
        this.denteProntuario = denteProntuario;
    }

    public String getDescricaoProntuario() {
        return descricaoProntuario;
    }

    public void setDescricaoProntuario(String descricaoProntuario) {
        this.descricaoProntuario = descricaoProntuario;
    }

    public double getTempoProntuario() {
        return tempoProntuario;
    }

    public void setTempoProntuario(double tempoProntuario) {
        this.tempoProntuario = tempoProntuario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    
}
