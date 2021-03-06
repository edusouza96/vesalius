package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Classe agenda, responsável por modelar o objeto referente a agenda, com atributos, id,paciente, data, hora, serviço
 * @author Edu
 */
@Entity
@XmlRootElement
public class Agenda {
    @Id 
    @GeneratedValue
    private int idAgenda;
    @ManyToOne
    private Paciente paciente;
    private Date dataAgenda;
    private String horaAgenda;
    private int servico;
    private int statusAgenda;
    /**
     * status da agenda
     * 1 - Confirmado
     * 0 - Aguardando confirmação
     */

    /**
     * Construtor da classe com os parametros:
     * @param idAgenda = id do registro da agenda
     * @param paciente = relaciona o paciente com a consulta
     * @param dataAgenda = data da consulta
     * @param horaAgenda = hora da consulta
     * @param servico = relaciona um serviço com a consulta
     */
    public Agenda(int idAgenda, Paciente paciente, Date dataAgenda, String horaAgenda, int servico) {
        this.idAgenda = idAgenda;
        this.paciente = paciente;
        this.dataAgenda = dataAgenda;
        this.horaAgenda = horaAgenda;
        this.servico = servico;
    }
    /**
     * Construtor da classe vazio
     */
    public Agenda() {
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
     * @return um int
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * setter de paciente
     * recebe por parametro um int
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

    /**
     * getter de statusAgenda
     * @return um int
     */
    public int getStatusAgenda() {
        return statusAgenda;
    }

    /**
     * setter de statusAgenda
     * recebe por parametro um int 
     * @param statusAgenda
     */
    public void setStatusAgenda(int statusAgenda) {
        this.statusAgenda = statusAgenda;
    }
    
    
}
