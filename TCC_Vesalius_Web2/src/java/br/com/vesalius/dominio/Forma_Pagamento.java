package br.com.vesalius.dominio;

/**
 * Classe Forma pagamento, responsável por modelar o objeto referente as formas de pagamentos do modulo financeiro
 * @author Edu
 */
public class Forma_Pagamento {
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
