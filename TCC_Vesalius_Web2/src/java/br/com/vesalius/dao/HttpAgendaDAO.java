package br.com.vesalius.dao;

import br.com.vesalius.dominio.Agenda;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpAgendaDAO {

   private final String USER_AGENT = "Mozila/5.0";
    public static void salvar(Agenda agenda) throws Exception{
        HttpAgendaDAO http = new HttpAgendaDAO();
        Gson gson = new Gson();
        Type agendaType = new TypeToken<Agenda>(){}.getType();
        String json = gson.toJson(agenda,agendaType);
        json = (new String(json.getBytes("UTF-8"), "ISO-8859-1"));
        if(agenda.getIdAgenda()>0){
            String url = "http://localhost:8080/TCC_Vesalius/webresources/agenda/alterar";
            http.sendPost(url, json, "PUT");
        }else{
            String url = "http://localhost:8080/TCC_Vesalius/webresources/agenda/inserir";
            http.sendPost(url, json, "POST");
        }
    }
    
    public static Agenda[] listar() throws Exception{
        HttpAgendaDAO http = new HttpAgendaDAO();
        Gson gson = new Gson();
        Type agendaType = new TypeToken<Agenda>(){}.getType();
        
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/agenda/listar";
        String json = http.sendGet(chamadaWS, "GET");
        Agenda[] agenda = gson.fromJson(json, Agenda[].class);
        return agenda;
    }
    
    public static void remover(Agenda agenda) throws Exception{
        HttpAgendaDAO http = new HttpAgendaDAO();
        Gson gson = new Gson();
        Type agendaType = new TypeToken<Agenda>(){}.getType();
        String json = gson.toJson(agenda,agendaType);
        String url = "http://localhost:8080/TCC_Vesalius/webresources/agenda/excluir";
        http.sendPost(url, json, "PUT");
        
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
        return (new String(response.toString().getBytes("ISO-8859-1"), "UTF-8"));
        
        
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
