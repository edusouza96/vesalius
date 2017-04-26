/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpFinanceiroDAO;
import br.com.vesalius.dao.HttpFormaPagamentoDAO;
import br.com.vesalius.dominio.Financeiro;
import br.com.vesalius.dominio.Forma_Pagamento;
import br.com.vesalius.dominio.Paciente;
import br.com.vesalius.util.Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class FinanceiroController {
    @RequestMapping("/financeiro/cadastro")
    public String cadastrar (Model model, Financeiro financeiro){
        try {
            if(!financeiro.getTituloFinanceiro().isEmpty()){
                if(financeiro.isStatusFinanceiro()){
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    financeiro.setVencimentoFinanceiro(formato.parse(financeiro.getVencimentoFinanceiroStr()));
                    Paciente paciente = new Paciente();
                    paciente.setIdPaciente(financeiro.getIdPaciente());
                    financeiro.setPaciente(paciente);
                    Forma_Pagamento fPagamento = new Forma_Pagamento();
                    fPagamento.setIdFormaPagamento(financeiro.getIdFormaPagamento());
                    financeiro.setFormaPagamento(fPagamento);
                    new HttpFinanceiroDAO().salvar(financeiro);
                    model.addAttribute("redirect","lista");
                    model.addAttribute("ok","Registro Salvo!");
                    return "redirect";
                }else{
                    Paciente paciente = new Paciente();
                    paciente.setIdPaciente(31);
                    financeiro.setPaciente(paciente);
                    financeiro.setDescricaoFinanceiro(financeiro.getTituloFinanceiro()+".........................................R$ "+financeiro.getValorFinanceiro());
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String dataStr = financeiro.getVencimentoFinanceiroStr();
                    dataStr = new Util().dateUs2Br(dataStr);
                    financeiro.setVencimentoFinanceiro(formato.parse(dataStr));
                    model.addAttribute("ok","Registro Salvo!");
                    new HttpFinanceiroDAO().salvar(financeiro);
                }                
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "financeiro/cadastro";
    }

    @RequestMapping(value="/financeiro/detalhes-{id}", method = RequestMethod.GET)
    public String detalhes (@PathVariable("id") int id, Model model){
        try {
            Financeiro financeiro =  new Financeiro();
            financeiro.setIdFinanceiro(id);
            financeiro = new HttpFinanceiroDAO().buscar(financeiro);
            model.addAttribute("financeiro", financeiro);
            model.addAttribute("tituloOperacao", "Detalhes");
            Forma_Pagamento[] listaFormaPagamento = new HttpFormaPagamentoDAO().listar();
            model.addAttribute("listaFormaPagamento", listaFormaPagamento);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "financeiro/detalhes";
    }
    
    @RequestMapping(value="/financeiro/pagar-{id}", method = RequestMethod.GET)
    public String pagar (@PathVariable("id") int id, Model model){
        try {
            Financeiro financeiro =  new Financeiro();
            financeiro.setIdFinanceiro(id);
            financeiro = new HttpFinanceiroDAO().buscar(financeiro);
            model.addAttribute("financeiro", financeiro);
            model.addAttribute("tituloOperacao", "Pagar");
            Forma_Pagamento[] listaFormaPagamento = new HttpFormaPagamentoDAO().listar();
            model.addAttribute("listaFormaPagamento", listaFormaPagamento);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "financeiro/detalhes";
    }
    
    @RequestMapping(value="/financeiro/receber-{id}", method = RequestMethod.GET)
    public String pareceber (@PathVariable("id") int id, Model model){
        try {
            Financeiro financeiro =  new Financeiro();
            financeiro.setIdFinanceiro(id);
            financeiro = new HttpFinanceiroDAO().buscar(financeiro);
            model.addAttribute("financeiro", financeiro);
            model.addAttribute("tituloOperacao", "Receber");
            Forma_Pagamento[] listaFormaPagamento = new HttpFormaPagamentoDAO().listar();
            model.addAttribute("listaFormaPagamento", listaFormaPagamento);
            model.addAttribute("paciente", "<b>Paciente</b>: "+financeiro.getPaciente().getNomePaciente());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "financeiro/detalhes";
    }
    
    @RequestMapping(value="/financeiro/detalhe-{id}", method = RequestMethod.GET)
    public String detalhesPaciente (@PathVariable("id") int id, Model model){
        try {
            Financeiro financeiro =  new Financeiro();
            financeiro.setIdFinanceiro(id);
            financeiro = new HttpFinanceiroDAO().buscar(financeiro);
            model.addAttribute("financeiro", financeiro);
            model.addAttribute("tituloOperacao", "Detalhes");
            Forma_Pagamento[] listaFormaPagamento = new HttpFormaPagamentoDAO().listar();
            model.addAttribute("listaFormaPagamento", listaFormaPagamento);
            model.addAttribute("paciente", "<b>Paciente</b>: "+financeiro.getPaciente().getNomePaciente());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "financeiro/detalhes";
    }
 
    @RequestMapping("/financeiro/lista")
    public String listar(Model model, HttpServletRequest request){
        try {
            Financeiro[] listaFin = new HttpFinanceiroDAO().listaFiltrada();
            List<Financeiro> lista = new ArrayList<>();
            int permissao = (Integer) request.getSession().getAttribute("permissao");
            if(permissao == 2){
                for(Financeiro fin: listaFin){
                    if(fin.isTipoFinanceiro()){
                        lista.add(fin);
                    }
                }
                model.addAttribute("lista",lista);
            }else{
                model.addAttribute("lista",listaFin);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "financeiro/lista";
    }
    
    @RequestMapping(value="/financeiro/deletar-{id}", method = RequestMethod.GET)
    public String deletar (@PathVariable("id") int id, Model model){
        try {
            Financeiro financeiro =  new Financeiro();
            financeiro.setIdFinanceiro(id);
            new HttpFinanceiroDAO().remover(financeiro);
            model.addAttribute("redirect", "lista");
            model.addAttribute("ok","Registro Excluido!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "redirect";
    }
}
