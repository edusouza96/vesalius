package br.com.vesalius.dominio;

import java.util.Date;

/**
 * @author Edu
 */
public class Notification {
    private int idAgenda;
    private Paciente paciente;
    private String nomePaciente;
    private Date dataAgenda;
    private String dataConsultaAgenda;
    private String horaFimAgenda;
    private String horaAgenda;
    private int servico;

    /**
     * Construtor da classe com os parametros:
     * @param paciente = relaciona o paciente com a consulta
     * @param dataAgenda = data da consulta
     * @param servico = relaciona um serviço com a consulta
     */
    public Notification(Paciente paciente, Date dataAgenda, int servico) {
        this.paciente = paciente;
        this.dataAgenda = dataAgenda;
        this.servico = servico;
    }
    /**
     * Construtor da classe vazio
     */
    public Notification() {
    }

    /**
     * getter de idgenda
     * @return um int
     */
    public int getIdAgenda() {
        return idAgenda;
    }

    /**
     * setter de idAgenda
     * recebe por parametro um int
     * @param idAgenda 
     */
    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    /**
     * getter de paciente
     * @return um paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * setter de paciente
     * recebe por parametro um paciente
     * @param paciente 
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * getter da dataAgenda
     * @return um data
     */
    public Date getDataAgenda() {
        return dataAgenda;
    }

    /**
     * Setter de dataAgenda
     * Recebe por parametro uma data
     * @param dataAgenda 
     */
    public void setDataAgenda(Date dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    /**
     * getter de horaAgenda
     * @return uma string
     */
    public String getHoraAgenda() {
        return horaAgenda;
    }

    /**
     * setter de horaAgenda
     * recebe por parametro uma string
     * @param horaAgenda 
     */
    public void setHoraAgenda(String horaAgenda) {
        this.horaAgenda = horaAgenda;
    }

    /**
     * getter de serviço
     * @return um int
     */
    public int getServico() {
        return servico;
    }

    /**
     * setter de serviço
     * recebe por parametro um int
     * @param servico 
     */
    public void setServico(int servico) {
        this.servico = servico;
    }

    public String getDataConsultaAgenda() {
        return dataConsultaAgenda;
    }

    public void setDataConsultaAgenda(String dataConsultaAgenda) {
        this.dataConsultaAgenda = dataConsultaAgenda;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getHoraFimAgenda() {
        return horaFimAgenda;
    }

    public void setHoraFimAgenda(String horaFimAgenda) {
        this.horaFimAgenda = horaFimAgenda;
    }
    
    
}
