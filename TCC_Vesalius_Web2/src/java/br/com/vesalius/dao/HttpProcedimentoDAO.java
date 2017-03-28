package br.com.vesalius.dao;

import br.com.vesalius.dominio.Procedimento;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpProcedimentoDAO {

   private final String USER_AGENT = "Mozila/5.0";
   
   public static void remover(Procedimento procedimento) throws Exception{
        HttpProcedimentoDAO http = new HttpProcedimentoDAO();
        Gson gson = new Gson();
        Type procedimentoType = new TypeToken<Procedimento>(){}.getType();
        String json = gson.toJson(procedimento,procedimentoType);
        String url = "http://localhost:8080/TCC_Vesalius/webresources/procedimento/excluir";
        http.sendPost(url, json, "PUT");
        
    }
   
    public static void salvar(Procedimento procedimento) throws Exception{
        HttpProcedimentoDAO http = new HttpProcedimentoDAO();
        Gson gson = new Gson();
        Type procedimentoType = new TypeToken<Procedimento>(){}.getType();
        String json = gson.toJson(procedimento,procedimentoType);
        json = (new String(json.getBytes("UTF-8"), "ISO-8859-1"));
        if(procedimento.getIdProcedimento()>0){
            
            String url = "http://localhost:8080/TCC_Vesalius/webresources/procedimento/alterar";
            http.sendPost(url, json, "PUT");
        }else{
            String url = "http://localhost:8080/TCC_Vesalius/webresources/procedimento/inserir";
            http.sendPost(url, json, "POST");
        }
        
    }
    
    public static Procedimento[] listar() throws Exception{
        HttpProcedimentoDAO http = new HttpProcedimentoDAO();
        Gson gson = new Gson();
        Type procedimentoType = new TypeToken<Procedimento>(){}.getType();
        
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/procedimento/listar";
        String json = http.sendGet(chamadaWS, "GET");
        Procedimento[] procedimento = gson.fromJson(json, Procedimento[].class);
        return procedimento;
    }
    
    public static Procedimento buscar(Procedimento procedimentoParametro) throws Exception{
        HttpProcedimentoDAO http = new HttpProcedimentoDAO();
        Gson gson = new Gson();
        Type procedimentoType = new TypeToken<Procedimento>(){}.getType();
               
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/procedimento/busca/"+procedimentoParametro.getIdProcedimento();
        String json = http.sendGet(chamadaWS, "GET");
        Procedimento procedimento = gson.fromJson(json, Procedimento.class);
        return procedimento;
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
