/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpProcedimentoDAO;
import br.com.vesalius.dominio.Procedimento;
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
public class ProcedimentoController {   
    @RequestMapping("/procedimento/cadastro")
      public String cadastrar (Model model, Procedimento procedimento){
        try {
            if(!procedimento.getNomeProcedimento().isEmpty()){
                new HttpProcedimentoDAO().salvar(procedimento);
                model.addAttribute("ok","Registro Salvo!");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "procedimento/cadastro";
    }

    @RequestMapping(value="/procedimento/editar-{id}", method = RequestMethod.GET)
    public String editar (@PathVariable("id") int id, Model model){
        try {
            Procedimento procedimento =  new Procedimento();
            procedimento.setIdProcedimento(id);
            procedimento = new HttpProcedimentoDAO().buscar(procedimento);
            model.addAttribute("procedimento", procedimento);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "procedimento/cadastro";
    }
 
    @RequestMapping("/procedimento/lista")
    public String listar(Model model){
        try {
            model.addAttribute("lista",new HttpProcedimentoDAO().listar());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "procedimento/lista";
    }
    
    @RequestMapping(value="/procedimento/deletar-{id}", method = RequestMethod.GET)
    public String deletar (@PathVariable("id") int id, Model model){
        try {
            Procedimento procedimento =  new Procedimento();
            procedimento.setIdProcedimento(id);
            new HttpProcedimentoDAO().remover(procedimento);
            model.addAttribute("redirect", "lista");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "redirect";
    }
}
