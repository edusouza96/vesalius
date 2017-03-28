/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.controller;

import br.com.vesalius.dao.HttpAgendaDAO;
import br.com.vesalius.dao.HttpPacienteDAO;
import br.com.vesalius.dao.HttpProcedimentoDAO;
import br.com.vesalius.dominio.Agenda;
import br.com.vesalius.dominio.Paciente;
import br.com.vesalius.dominio.Procedimento;
import br.com.vesalius.util.Util;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class AgendaController {   
   
    @RequestMapping("/agenda/")
    public String listar(Model model, Agenda agenda){
        try {
            if(agenda.getNomePaciente() != null){
                Paciente[] listaPaciente = new HttpPacienteDAO().listar();
                String nomePacienteIso = agenda.getNomePaciente();
                byte ptext[] = nomePacienteIso.getBytes(ISO_8859_1); 
                String nomePacienteUTF = new String(ptext, UTF_8); 
                for (Paciente paciente : listaPaciente) {
                    if(paciente.getNomePaciente().equals(nomePacienteUTF)){
                        agenda.setPaciente(paciente);                
                    }
                }
                String dataHora = new Util().dateUs2Br(agenda.getDataConsultaAgenda(), agenda.getHoraAgenda());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date date = sdf.parse(dataHora);
                agenda.setDataAgenda(date);
                System.out.println(agenda.getHoraFimAgenda().equals(""));
                if(agenda.getHoraFimAgenda().equals("")){
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
                    Calendar t = (Calendar) calendar.clone();
                    t.set(Calendar.AM_PM, Calendar.PM);
                    t.setTime(date);
                    t.add(Calendar.MINUTE, 30); 
                    agenda.setHoraAgenda(new SimpleDateFormat("HH:mm").format(t.getTime()));
                }else{
                    agenda.setHoraAgenda(agenda.getHoraFimAgenda());
                }
                
                new HttpAgendaDAO().salvar(agenda);

                model.addAttribute("ok","Registro Salvo!");
            }
            Agenda[] lista = new HttpAgendaDAO().listar();
                StringBuilder listaJson = new StringBuilder("");
                for (Agenda ag : lista) {
                    listaJson.append("{");
                    listaJson.append("id: '").append(ag.getIdAgenda()).append("' ");
                    listaJson.append(",");
                    listaJson.append("title: '").append(ag.getPaciente().getNomePaciente()).append("' ");
                    listaJson.append(",");
                    listaJson.append("start: '").append(new Util().showDateHourUs(ag.getDataAgenda())).append("' ");
                    String dtUs = new Util().showDateUs(ag.getDataAgenda())+" "+ag.getHoraAgenda();
                    listaJson.append(",");
                    listaJson.append("end: '").append(dtUs).append("' ");
//                    listaJson.append(",");
//                    listaJson.append("url: '").append("alert();").append("' ");
                    listaJson.append("},");
                }

                model.addAttribute("lista",listaJson);
                model.addAttribute("dataAtual", new Util().showDateUs(new Date(System.currentTimeMillis())));
                Procedimento[] listaProcedimento = new HttpProcedimentoDAO().listar();
                model.addAttribute("listaProcedimento", listaProcedimento);
                Paciente[] listaPaciente = new HttpPacienteDAO().listar();
                StringBuilder nomePacientes = new StringBuilder("[");
                for (Paciente paciente : listaPaciente) {
                    nomePacientes.append("'");
                    nomePacientes.append(paciente.getNomePaciente());
                    nomePacientes.append("'");
                    nomePacientes.append(",");
                }
                nomePacientes.append("]");
                model.addAttribute("nomePacientes", nomePacientes);
                System.out.println(listaJson);

        }catch (NullPointerException ex){
            System.err.println(agenda.getNomePaciente()+ex);
        }catch (Exception ex) {
            System.err.println(ex);
        }
        return "agenda/index";
    }
    
    @RequestMapping(value="/agenda/deletar-{id}", method = RequestMethod.GET)
    public String deletar (@PathVariable("id") int id, Model model){
        try {
            Agenda agenda =  new Agenda();
            agenda.setIdAgenda(id);
            new HttpAgendaDAO().remover(agenda);
            model.addAttribute("redirect", "agenda");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return "redirect";
    }
   
}
