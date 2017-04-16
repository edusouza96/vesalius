package br.com.vesalius.dao;

import br.com.vesalius.dominio.Forma_Pagamento;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpFormaPagamentoDAO {

   private final String USER_AGENT = "Mozila/5.0";
   
  
    public static Forma_Pagamento buscar(int id) throws Exception{
        HttpFormaPagamentoDAO http = new HttpFormaPagamentoDAO();
        Gson gson = new Gson();
        Type tAcessosType = new TypeToken<Forma_Pagamento>(){}.getType();
               
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/formaPagamento/busca/"+id;
        String json = http.sendGet(chamadaWS, "GET");
        Forma_Pagamento tAcessos = gson.fromJson(json, Forma_Pagamento.class);
        return tAcessos;
    }
    
    public static Forma_Pagamento[] listar() throws Exception{
        HttpFormaPagamentoDAO http = new HttpFormaPagamentoDAO();
        Gson gson = new Gson();
        Type fPagamentoType = new TypeToken<Forma_Pagamento>(){}.getType();
        
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/formaPagamento/listar";
        String json = http.sendGet(chamadaWS, "GET");
        Forma_Pagamento[] fPagamento = gson.fromJson(json, Forma_Pagamento[].class);
        return fPagamento;
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
