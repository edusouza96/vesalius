/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpPacienteDAO;
import br.com.vesalius.dominio.Login;
import br.com.vesalius.dominio.Paciente;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Edu
 */

@Controller
public class LoginController{
    @RequestMapping("/login/")
    public String login(Model model){
        return "login/login";
    }
    
    @RequestMapping("/login/dentista")
    public String dentista(Model model, HttpSession session){
        try {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(25);
            paciente = new HttpPacienteDAO().buscar(paciente);
            Login login = new Login(paciente);
            session.setAttribute("user", login);
            session.setAttribute("permissao", login.getPaciente().getTipoAcessos());
            model.addAttribute("redirect","../agenda/");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "redirect";
    }
    
    @RequestMapping("/login/secretaria")
    public String secretaria(Model model, HttpSession session){
        try {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(2);
            paciente = new HttpPacienteDAO().buscar(paciente);
            Login login = new Login(paciente);
            session.setAttribute("user", login);
            session.setAttribute("permissao", login.getPaciente().getTipoAcessos());
            model.addAttribute("redirect","../agenda/");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "redirect";
    }
    
    @RequestMapping("/login/paciente")
    public String paciente(Model model, HttpSession session){
        try {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(31);
            paciente = new HttpPacienteDAO().buscar(paciente);
            Login login = new Login(paciente);
            session.setAttribute("user", login);
            session.setAttribute("permissao", login.getPaciente().getTipoAcessos());
            model.addAttribute("redirect","../agenda/");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "redirect";
    }
    
    @RequestMapping("/logout/")
    public String logout(Model model, HttpSession session) {
      session.invalidate();
      model.addAttribute("redirect", "../login/");
      return "redirect";
    }
}
