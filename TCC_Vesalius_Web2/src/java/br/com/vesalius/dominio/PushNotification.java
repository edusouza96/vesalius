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
        this.body = "Voce tem consulta no dentista hoje";
        this.title = "Lembrete";
        this.icon = "/images/profile_placeholder.png";
        this.click_action = "http://localhost:5000";
    }

}

public class PushNotification {
    private Notification notification;
    private String to;

    /**
     * Contrutor da classe com todos parametros
     * @param to token do usuario a receber a notificação
     */
    public PushNotification(String to) {
        this.notification = new Notification();
        this.to = to;
    }

    /**
     * contrutor da classe vazio
     */
    public PushNotification() {
    }
    
    
    
}
