package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Estoque, responsável por modelar o objeto referente aos produtos em estoque da Clinica
 * @author Edu
 */
@Entity
@XmlRootElement
public class Estoque implements Serializable{
    @Id 
    @GeneratedValue
    private int idEstoque;
    private String itemEstoque;
    private int quantidadeItemEstoque;

    public Estoque() {
    }

    public Estoque(int idEstoque, String itemEstoque, int quantidadeItemEstoque) {
        this.idEstoque = idEstoque;
        this.itemEstoque = itemEstoque;
        this.quantidadeItemEstoque = quantidadeItemEstoque;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getItemEstoque() {
        return itemEstoque;
    }

    public void setItemEstoque(String itemEstoque) {
        this.itemEstoque = itemEstoque;
    }

    public double getQuantidadeItemEstoque() {
        return quantidadeItemEstoque;
    }

    public void setQuantidadeItemEstoque(int quantidadeItemEstoque) {
        this.quantidadeItemEstoque = quantidadeItemEstoque;
    }

        
}
