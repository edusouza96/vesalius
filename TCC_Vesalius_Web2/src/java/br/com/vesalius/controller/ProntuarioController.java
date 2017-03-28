/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpPacienteDAO;
import br.com.vesalius.dao.HttpProcedimentoDAO;
import br.com.vesalius.dao.HttpProntuarioDAO;
import br.com.vesalius.dominio.Paciente;
import br.com.vesalius.dominio.Procedimento;
import br.com.vesalius.dominio.Prontuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class ProntuarioController {   
    @RequestMapping("/prontuario/cadastro")
      public String cadastrar (Model model, Prontuario prontuario){
        try {
            if(prontuario.getIdProcedimento() > 0){
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(prontuario.getIdPaciente());
                prontuario.setPaciente(paciente);
                
                Procedimento procedimento = new Procedimento();
                procedimento.setIdProcedimento(prontuario.getIdProcedimento());
                prontuario.setProcedimento(procedimento);
                
                prontuario.setDataProntuario(new Date(System.currentTimeMillis()));
                new HttpProntuarioDAO().salvar(prontuario);
                model.addAttribute("ok","Registro Salvo!");
            }
            Procedimento[] listaProcedimento = new HttpProcedimentoDAO().listar();
            model.addAttribute("listaProcedimento", listaProcedimento);
           

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "prontuario/cadastro";
    }

    @RequestMapping(value="/prontuario/editar-{id}", method = RequestMethod.GET)
    public String editar (@PathVariable("id") int id, Model model){
        try {
            Prontuario prontuario =  new Prontuario();
            prontuario.setIdProntuario(id);
            prontuario = new HttpProntuarioDAO().buscar(prontuario);
            model.addAttribute("prontuario", prontuario);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "prontuario/cadastro";
    }
 
    @RequestMapping(value="/prontuario/paciente-{id}", method = RequestMethod.GET)
    public String listar (@PathVariable("id") int id, Model model){
        try {
            List prontuarios = new ArrayList();
            Prontuario[] lista = new HttpProntuarioDAO().listar();
            for(Prontuario pront: lista){
                if(pront.getPaciente().getIdPaciente() == id){
                    prontuarios.add(pront);
                }
            }
            model.addAttribute("lista",prontuarios);
            model.addAttribute("id",id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "prontuario/lista";
    }
    
    @RequestMapping(value="/prontuario/deletar-{id}", method = RequestMethod.GET)
    public String deletar (@PathVariable("id") int id, Model model){
        try {
            Prontuario prontuario =  new Prontuario();
            prontuario.setIdProntuario(id);
            new HttpProntuarioDAO().remover(prontuario);
            model.addAttribute("redirect", "lista");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "redirect";
    }
}
