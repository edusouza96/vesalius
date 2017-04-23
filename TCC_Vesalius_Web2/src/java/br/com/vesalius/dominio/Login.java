package br.com.vesalius.dominio;

import java.io.Serializable;


/**
 * Classe Login
 * @author Edu
 */

public class Login implements Serializable{
    private Paciente paciente;

    public Login() {
    }

    public Login(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
     
}
