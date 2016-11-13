package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe procedimento, responsável por modelar o objeto referente aos procedimentos realizados na cliinica
 * @author Edu
 */
@Entity
@XmlRootElement
public class Procedimento{
    @Id 
    @GeneratedValue
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
