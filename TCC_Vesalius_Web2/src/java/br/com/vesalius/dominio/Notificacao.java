package br.com.vesalius.dominio;

/**
 * Classe notificacao, responsável por modelar o objeto referente as notificacoes
 * @author Edu
 */
public class Notificacao{
    private int idNotificacao;
    private String tokenNotificacao;
    private Paciente paciente;

    public Notificacao() {
    }

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public String getTokenNotificacao() {
        return tokenNotificacao;
    }

    public void setTokenNotificacao(String tokenNotificacao) {
        this.tokenNotificacao = tokenNotificacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    

    public Notificacao(int idNotificacao, String tokenNotificacao, Paciente paciente) {
        this.idNotificacao = idNotificacao;
        this.tokenNotificacao  = tokenNotificacao;
        this.paciente = paciente;
    }    
}
