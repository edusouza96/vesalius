/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vesalius.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Edu
 */
public class AutorizadorInterceptor  extends HandlerInterceptorAdapter{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object controller) throws Exception {
      String caminho = "../login/";
      String uri = request.getRequestURI();
      if(uri.endsWith("/login/") || uri.endsWith("/login/dentista") || uri.endsWith("/login/secretaria") || uri.endsWith("/login/paciente") || uri.contains("resources")){
        return true;
      }
      
      if(request.getSession().getAttribute("user") != null) {
        int permissaoNivel = (Integer) request.getSession().getAttribute("permissao");
        if(permissaoNivel != 3) {
            return true;
        }else{
            if(uri.endsWith("/paciente/visualizar") ||uri.contains("agenda") || uri.contains("logout")){
                if(uri.endsWith("/agenda/")){
                    response.sendRedirect("../agenda/consultas");
                }
                return true;
            }else{
                caminho = "../agenda/";
            }
        }
      }

      response.sendRedirect(caminho);
      return false;
  }
}
