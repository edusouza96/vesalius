/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Edu
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.AgendaWS.class);
        resources.add(ws.EstoqueWS.class);
        resources.add(ws.FinanceiroWS.class);
        resources.add(ws.FormaPagamentoWS.class);
        resources.add(ws.LoginWS.class);
        resources.add(ws.NotificacaoWS.class);
        resources.add(ws.PacienteWS.class);
        resources.add(ws.ProcedimentoWS.class);
        resources.add(ws.ProntuarioWS.class);
        resources.add(ws.RelatorioWS.class);
        resources.add(ws.TipoAcessosWS.class);
    }
    
}
