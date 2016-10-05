package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import model.Agenda;


public class HttpExemplo {

   private final String USER_AGENT = "Mozila/5.0";
   /*
    public static void main(String[] args)  throws Exception{
        
        
        //getUsuario
       /* String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/agenda/listar";
        String json = http.sendGet(chamadaWS, "GET");
        agendaL = gson.fromJson(json, agendaType);
        System.out.println(agendaL.toString());
        
        
        
        //excluirUsuario
        String chamadaWS = "http://localhost:29583/TesteWebService/webresources/teste/teste/excluirUsuario/user";
        String retorno = http.sendGet(chamadaWS, "DELETE");
        System.out.println(retorno);
        */
       
        /*
        //alterarUsuario
        usuario.setNome("nome5");
        usuario.setUsuario("Souza");
        usuario.setSenha("1234");
        String json = gson.toJson(usuario,usuarioType);
        String url = "http://localhost:29583/TesteWebService/webresources/teste/teste/alterarUsuario";
        http.sendPost(url, json, "PUT");   
     }
    */
    public static void salvar(Agenda agenda) throws Exception{
        HttpExemplo http = new HttpExemplo();
        Gson gson = new Gson();
        Type agendaType = new TypeToken<Agenda>(){}.getType();
        if(agenda.getIdAgenda()>0){
            String json = gson.toJson(agenda,agendaType);
            String url = "http://localhost:8080/TCC_Vesalius/webresources/agenda/alterar";
            http.sendPost(url, json, "PUT");
        }else{
            String json = gson.toJson(agenda,agendaType);
            String url = "http://localhost:8080/TCC_Vesalius/webresources/agenda/inserir";
            http.sendPost(url, json, "POST");
        }
        
    }
    
    public static Agenda[] listar() throws Exception{
        HttpExemplo http = new HttpExemplo();
        Gson gson = new Gson();
        Type agendaType = new TypeToken<Agenda>(){}.getType();
        
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/agenda/listar";
        String json = http.sendGet(chamadaWS, "GET");
        Agenda[] agenda = gson.fromJson(json, Agenda[].class);
        return agenda;
    }
    
    private String sendGet(String url, String method) throws Exception{
       
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        
        con.setRequestProperty("User-sAgent",USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : "+url);
        System.out.println("Response Code : "+ responseCode);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
            
        }
        in.close();
        return (response.toString());
        
        
    }
    
    private void sendPost(String url, String urlParameters, String method) throws Exception{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("POST parameters : "+urlParameters);
        System.out.println("Response Code : "+responseCode);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
            
        }
        in.close();
        System.out.println(response.toString());
        
    }
}
