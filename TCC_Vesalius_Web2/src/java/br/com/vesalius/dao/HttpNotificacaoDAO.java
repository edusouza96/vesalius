package br.com.vesalius.dao;

import br.com.vesalius.dominio.Notificacao;
import br.com.vesalius.dominio.Paciente;
import br.com.vesalius.dominio.PushNotification;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpNotificacaoDAO {

    private final String USER_AGENT = "Mozila/5.0";
   
    public void pushNotification(PushNotification pushNotification) throws Exception{
        String url = "https://fcm.googleapis.com/fcm/send";
        String method = "POST";
        Gson gson = new Gson();
        Type pnType = new TypeToken<PushNotification>(){}.getType();
        String urlParameters = gson.toJson(pushNotification,pnType);
        
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Authorization", "key=AAAAZ2JOJtI:APA91bFKamchUR_BMdL_iRx3qALXoJBQyLOq8U-A_SdZR1grWZzTdqFoYGSS3IuttPwgZHZdtAZ0yPahzEBKYAsRklCSJEX18pOrJGwdUvJF5z6mDZDaZ5Qyl8bfkQC1NO38uyPMMPje");
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
    
    public static Notificacao[] buscar(Paciente pacienteParametro) throws Exception{
        HttpNotificacaoDAO http = new HttpNotificacaoDAO();
        Gson gson = new Gson();
        Type notificationType = new TypeToken<Notificacao>(){}.getType();
            
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/notificacao/buscaToken/"+pacienteParametro.getIdPaciente();
        String json = http.sendGet(chamadaWS, "GET");
        Notificacao[] notification = gson.fromJson(json, Notificacao[].class);
        return notification;
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
