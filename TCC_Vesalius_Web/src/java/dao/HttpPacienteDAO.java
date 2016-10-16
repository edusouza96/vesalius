package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import model.Paciente;


public class HttpPacienteDAO {

   private final String USER_AGENT = "Mozila/5.0";
   
   public static void remover(Paciente paciente) throws Exception{
        HttpPacienteDAO http = new HttpPacienteDAO();
        Gson gson = new Gson();
        Type pacienteType = new TypeToken<Paciente>(){}.getType();
        String json = gson.toJson(paciente,pacienteType);
        String url = "http://localhost:8080/TCC_Vesalius/webresources/paciente/excluir";
        http.sendPost(url, json, "PUT");
        
    }
   
    public static void salvar(Paciente paciente) throws Exception{
        HttpPacienteDAO http = new HttpPacienteDAO();
        Gson gson = new Gson();
        Type pacienteType = new TypeToken<Paciente>(){}.getType();
        if(paciente.getIdPaciente()>0){
            String json = gson.toJson(paciente,pacienteType);
            String url = "http://localhost:8080/TCC_Vesalius/webresources/paciente/alterar";
            http.sendPost(url, json, "PUT");
        }else{
            String json = gson.toJson(paciente,pacienteType);
            String url = "http://localhost:8080/TCC_Vesalius/webresources/paciente/inserir";
            http.sendPost(url, json, "POST");
        }
        
    }
    
    public static Paciente[] listar() throws Exception{
        HttpPacienteDAO http = new HttpPacienteDAO();
        Gson gson = new Gson();
        Type pacienteType = new TypeToken<Paciente>(){}.getType();
        
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/paciente/listar";
        String json = http.sendGet(chamadaWS, "GET");
        Paciente[] paciente = gson.fromJson(json, Paciente[].class);
        return paciente;
    }
    
    public static Paciente buscar(Paciente pacienteParametro) throws Exception{
        HttpPacienteDAO http = new HttpPacienteDAO();
        Gson gson = new Gson();
        Type pacienteType = new TypeToken<Paciente>(){}.getType();
               
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/paciente/busca/"+pacienteParametro.getIdPaciente();
        String json = http.sendGet(chamadaWS, "GET");
        Paciente paciente = gson.fromJson(json, Paciente.class);
        return paciente;
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
