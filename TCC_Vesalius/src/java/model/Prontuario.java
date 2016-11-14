package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe prontuario, responsável por modelar o objeto referente as consultas do paciente
 * @author Edu
 */
@Entity
@XmlRootElement
public class Prontuario implements Serializable{
    @Id 
    @GeneratedValue
    private int idProntuario;
    private Date dataProntuario;
    private String denteProntuario;
    private String descricaoProntuario;
    private double tempoProntuario;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Procedimento procedimento;

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
