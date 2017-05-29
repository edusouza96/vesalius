/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpEstoqueDAO;
import br.com.vesalius.dominio.Estoque;
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
public class EstoqueController {   
    @RequestMapping("/estoque/cadastro")
      public String cadastrar (Model model, Estoque estoque){
        try {
            if(!estoque.getItemEstoque().isEmpty()){
                new HttpEstoqueDAO().salvar(estoque);
                model.addAttribute("ok","Registro Salvo!");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "estoque/cadastro";
    }

    @RequestMapping(value="/estoque/editar-{id}", method = RequestMethod.GET)
    public String editar (@PathVariable("id") int id, Model model){
        try {
            Estoque estoque =  new Estoque();
            estoque.setIdEstoque(id);
            estoque = new HttpEstoqueDAO().buscar(estoque);
            model.addAttribute("estoque", estoque);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "estoque/cadastro";
    }
 
    @RequestMapping("/estoque/lista")
    public String listar(Model model){
        try {
            model.addAttribute("lista",new HttpEstoqueDAO().listar());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "estoque/lista";
    }
    
    @RequestMapping(value="/estoque/deletar-{id}", method = RequestMethod.GET)
    public String deletar (@PathVariable("id") int id, Model model){
        try {
            Estoque estoque =  new Estoque();
            estoque.setIdEstoque(id);
            new HttpEstoqueDAO().remover(estoque);
            model.addAttribute("redirect", "lista");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "redirect";
    }
}
