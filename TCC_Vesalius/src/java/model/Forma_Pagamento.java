package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe Forma pagamento, responsável por modelar o objeto referente as formas de pagamentos do modulo financeiro
 * @author Edu
 */
@Entity
@XmlRootElement
public class Forma_Pagamento implements Serializable {
    @Id 
    @GeneratedValue
    private int idFormaPagamento;
    private String tituloFormaPagamento;

    public Forma_Pagamento() {
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getTituloFormaPagamento() {
        return tituloFormaPagamento;
    }

    public void setTituloFormaPagamento(String tituloFormaPagamento) {
        this.tituloFormaPagamento = tituloFormaPagamento;
    }

   
    
    
}
