package br.com.vesalius.dominio;

import br.com.vesalius.util.Util;
import java.io.Serializable;


/**
 * Classe Login
 * @author Edu
 */

public class Login implements Serializable{
    private int idLogin;
    private Paciente paciente;
    private String userLogin;
    private String passwordLogin;

    public Login() {
    }

    public Login(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = new Util().sha256(userLogin);
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = new Util().sha256(passwordLogin);
    }
    
    
}
