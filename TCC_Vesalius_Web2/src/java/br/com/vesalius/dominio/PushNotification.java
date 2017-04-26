package br.com.vesalius.dominio;

/**
 * @author Edu
 */
 class Notification {
    private String title;
    private String body;
    private String icon;
    private String click_action;

    /**
     * Construtor da classe 
     */
    public Notification() {
        this.body = "Voce tem consulta no dentista amanha";
        this.title = "Lembrete";
        this.icon = "/images/profile_placeholder.png";
        this.click_action = "http://localhost:5000";
    }
    
    /**
     * Construtor da classe com mensagem personalizada
     */
    public Notification(String body) {
        this.body = body;
        this.title = "Aviso";
        this.icon = "/images/profile_placeholder.png";
    }

}

public class PushNotification {
    private Notification notification;
    private String to;

    /**
     * Contrutor da classe com parametro to
     * @param to token do usuario a receber a notificação
     */
    public PushNotification(String to) {
        this.notification = new Notification();
        this.to = to;
    }
    
    /**
     * Contrutor da classe para envio de consulta confirmada
     * @param to token do usuario a receber a notificação
     * @param msg mensagem a ser enviada
     */
    public PushNotification(String to, String msg) {
        this.notification = new Notification(msg);
        this.to = to;
    }

    /**
     * contrutor da classe vazio
     */
    public PushNotification() {
    }
    
    
    
}
