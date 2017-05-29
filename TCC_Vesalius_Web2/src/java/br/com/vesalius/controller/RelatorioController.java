/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpRelatorioDAO;
import br.com.vesalius.dominio.Relatorio;
import br.com.vesalius.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Edu
 */

@Controller
public class RelatorioController{
    @RequestMapping("/relatorio/")
    public String relatorio(Model model){
        try {
            /**
             * Consultas
             */
            Relatorio relatorio = new Relatorio();
            relatorio.setField1("2000-01-01");
            relatorio.setField2(new Util().showDateUs(new Date(System.currentTimeMillis())));
            Collection<Relatorio> listaConsultas = new HttpRelatorioDAO().consultasPorMes(relatorio);
            StringBuilder listaConsultasJson = new StringBuilder("");
            
            for (Relatorio rel : listaConsultas) {
                List<String> listaCor = new Util().generationColor();
                listaConsultasJson.append("{");
                listaConsultasJson.append("value: ").append(rel.getField1()).append(" ");
                listaConsultasJson.append(",");
                listaConsultasJson.append("color: '").append(listaCor.get(0)).append("' ");
                listaConsultasJson.append(",");
                listaConsultasJson.append("highlight: '").append(listaCor.get(1)).append("' ");
                listaConsultasJson.append(",");
                listaConsultasJson.append("label: '").append(new Util().showMonthYear(rel.getField2())).append("' ");
                listaConsultasJson.append("},");                
            }
            model.addAttribute("listaConsultas",listaConsultasJson);
            
            
            /**
             * Pacientes
             */
            Relatorio relatorio1 = new Relatorio();
            relatorio1.setField1("2000-01-01");
            relatorio1.setField2(new Util().showDateUs(new Date(System.currentTimeMillis())));
            Collection<Relatorio> listaPacientes = new HttpRelatorioDAO().pacientesNovosPorMes(relatorio1);
            StringBuilder listaPacientesJson = new StringBuilder("");
            
            for (Relatorio rel : listaPacientes) {
                List<String> listaCor1 = new Util().generationColor();
                listaPacientesJson.append("{");
                listaPacientesJson.append("value: ").append(rel.getField1()).append(" ");
                listaPacientesJson.append(",");
                listaPacientesJson.append("color: '").append(listaCor1.get(0)).append("' ");
                listaPacientesJson.append(",");
                listaPacientesJson.append("highlight: '").append(listaCor1.get(1)).append("' ");
                listaPacientesJson.append(",");
                listaPacientesJson.append("label: '").append(new Util().showMonthYear(rel.getField2())).append("' ");
                listaPacientesJson.append("},");
            }
            model.addAttribute("listaPacientes",listaPacientesJson);
            
            
            /**
             * Procedimentos
             */
            Relatorio relatorio2 = new Relatorio();
            relatorio2.setField1("2017");
            relatorio2.setField2("04");
            Collection<Relatorio> listaProcedimento = new HttpRelatorioDAO().procedimentosMes(relatorio2);
            StringBuilder listaProcedimentosJson = new StringBuilder("");
            
            for (Relatorio rel : listaProcedimento) {
                List<String> listaCor2 = new Util().generationColor();
                listaProcedimentosJson.append("{");
                listaProcedimentosJson.append("value: ").append(rel.getField1()).append(" ");
                listaProcedimentosJson.append(",");
                listaProcedimentosJson.append("color: '").append(listaCor2.get(0)).append("' ");
                listaProcedimentosJson.append(",");
                listaProcedimentosJson.append("highlight: '").append(listaCor2.get(1)).append("' ");
                listaProcedimentosJson.append(",");
                listaProcedimentosJson.append("label: '").append(rel.getField2()).append("' ");
                listaProcedimentosJson.append("},");
            }
            model.addAttribute("listaProcedimentos",listaProcedimentosJson);
            
            /**
             * Financeiro
             */
            Relatorio relatorio3 = new Relatorio();
            relatorio3.setField1("2017");
            ArrayList valorMesesDespeza = new ArrayList();
            ArrayList valorMesesReceita = new ArrayList();
            for(int i=0; i<12; i++){
                valorMesesDespeza.add(0);
                valorMesesReceita.add(0);
            }
            Collection<Relatorio> listaFinanceiro = new HttpRelatorioDAO().financeiroAno(relatorio3);
            StringBuilder listaFinanceiroJson = new StringBuilder("");
            for (Relatorio rel : listaFinanceiro) {
                if(Integer.parseInt(rel.getField3()) == 0){
                    valorMesesDespeza.set(Integer.parseInt(rel.getField2())-1, rel.getField1());
                }else if(Integer.parseInt(rel.getField3()) == 1){
                    valorMesesReceita.set(Integer.parseInt(rel.getField2())-1, rel.getField1());
                }
            }
            
            listaFinanceiroJson.append("{");
            listaFinanceiroJson.append("label: '").append("Despezas").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("fillColor: '").append("#FF0000").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("strokeColor: '").append("#FF0000").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("highlightFill: '").append("#FF0000").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("highlightStroke: '").append("#FF0000").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("data: ").append(valorMesesDespeza.toString());
            listaFinanceiroJson.append("},");
            listaFinanceiroJson.append("{");
            listaFinanceiroJson.append("label: '").append("Receitas").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("fillColor: '").append("#0000FF").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("strokeColor: '").append("#0000FF").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("highlightFill: '").append("#0000FF").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("highlightStroke: '").append("#0000FF").append("' ");
            listaFinanceiroJson.append(",");
            listaFinanceiroJson.append("data: ").append(valorMesesReceita.toString());
            listaFinanceiroJson.append("}");
            model.addAttribute("listaFinanceiro",listaFinanceiroJson);
            //------------------------------------------------------------------------------------------
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "relatorio/index";
    }
    
    
}
