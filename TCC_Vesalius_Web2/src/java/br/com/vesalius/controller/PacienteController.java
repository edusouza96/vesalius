/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpPacienteDAO;
import br.com.vesalius.util.*;
import br.com.vesalius.dominio.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Edu
 */

@Controller
public class PacienteController {
    @RequestMapping("/paciente/cadastro")
    public String cadastrar (Model model, Paciente paciente){    
        try {
            String teste = paciente.getNomePaciente(); 
            if(!teste.isEmpty()){
                String nascimento = paciente.getNascimentoPaciente();
                paciente.setNascimentoPaciente(new Util().dateUs2Br(nascimento));

                String tratamento = paciente.getInicioTratamentoPaciente();
                paciente.setInicioTratamentoPaciente(new Util().dateUs2Br(tratamento));
               
                new HttpPacienteDAO().salvar(paciente);
                
                nascimento = paciente.getNascimentoPaciente();
                paciente.setNascimentoPaciente(new Util().removeHour(nascimento));

                tratamento = paciente.getInicioTratamentoPaciente();
                paciente.setInicioTratamentoPaciente(new Util().removeHour(tratamento));
                
                model.addAttribute("ok","Registro Salvo!");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "paciente/cadastro";
    }

    @RequestMapping(value="/paciente/editar-{id}", method = RequestMethod.GET)
    public String editar (@PathVariable("id") int id, Model model){
        try {
            boolean valor;
            Paciente paciente =  new Paciente();
            paciente.setIdPaciente(id);
            paciente = new HttpPacienteDAO().buscar(paciente);
            model.addAttribute("paciente", paciente);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "paciente/cadastro";
    }
 
    @RequestMapping("/paciente/lista")
    public String listar(Model model){
        try {
            model.addAttribute("lista",new HttpPacienteDAO().listar());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "paciente/lista";
    }
    
    @RequestMapping(value="/paciente/deletar-{id}", method = RequestMethod.GET)
    public String deletar (@PathVariable("id") int id, Model model){
        try {
            Paciente paciente =  new Paciente();
            paciente.setIdPaciente(id);
            new HttpPacienteDAO().remover(paciente);
            model.addAttribute("redirect", "lista");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "redirect";
    }
}
