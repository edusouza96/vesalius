/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpLoginDAO;
import br.com.vesalius.dominio.Login;
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

//    @RequestMapping("/login/dentista")
//    public String dentista(Model model, HttpSession session){
//        try {
//            Paciente paciente = new Paciente();
//            paciente.setIdPaciente(25);
//            paciente = new HttpPacienteDAO().buscar(paciente);
//            Login login = new Login(paciente);
//            session.setAttribute("user", login);
//            session.setAttribute("permissao", login.getPaciente().getTipoAcessos());
//            model.addAttribute("redirect","../agenda/");
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return "redirect";
//    }

    @RequestMapping("/login/auth")
    public String auth(Model model, Login login, HttpSession session){
        try {
            Login login1;
            login1 = new HttpLoginDAO().buscar(login);
            if(login1.getIdLogin() > 0){
                session.setAttribute("user", login1);
                session.setAttribute("permissao", login1.getPaciente().getTipoAcessos());
                model.addAttribute("redirect","http://localhost:5000/index.html?paciente="+login1.getPaciente().getIdPaciente());
//                model.addAttribute("redirect","../agenda/");
            }else{
                System.out.println("nao passou");
                model.addAttribute("redirect","../login/");
            }
            
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
