package br.com.vesalius.dao;

import br.com.vesalius.dominio.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import br.com.vesalius.util.Util;


public class HttpLoginDAO {

   private final String USER_AGENT = "Mozila/5.0";
   
   public static void remover(Login login) throws Exception{
        HttpLoginDAO http = new HttpLoginDAO();
        Gson gson = new Gson();
        Type loginType = new TypeToken<Login>(){}.getType();
        String json = gson.toJson(login,loginType);
        String url = "http://localhost:8080/TCC_Vesalius/webresources/login/excluir";
        http.sendPost(url, json, "PUT");
        
    }
   
    public static void salvar(Login login) throws Exception{
        HttpLoginDAO http = new HttpLoginDAO();
        Gson gson = new Gson();
        Type loginType = new TypeToken<Login>(){}.getType();
        String json = gson.toJson(login,loginType);
        json = (new String(json.getBytes("UTF-8"), "ISO-8859-1"));
        if(login.getIdLogin()>0){
            String url = "http://localhost:8080/TCC_Vesalius/webresources/login/alterar";
            http.sendPost(url, json, "PUT");
        }else{
            String url = "http://localhost:8080/TCC_Vesalius/webresources/login/inserir";
            http.sendPost(url, json, "POST");
        }
        
    }
    
    public static Login[] listar() throws Exception{
        HttpLoginDAO http = new HttpLoginDAO();
        Gson gson = new Gson();
        Type loginType = new TypeToken<Login>(){}.getType();
        
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/login/listar";
        String json = http.sendGet(chamadaWS, "GET");
        Login[] login = gson.fromJson(json, Login[].class);
        return login;
    }
    
    public static Login buscar(Login loginParametro) throws Exception{
        HttpLoginDAO http = new HttpLoginDAO();
        Gson gson = new Gson();
        Type loginType = new TypeToken<Login>(){}.getType();
            
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/login/procurarPorLogin/"+loginParametro.getUserLogin()+"/"+loginParametro.getPasswordLogin();
        String json = http.sendGet(chamadaWS, "GET");
        Login login = gson.fromJson(json, Login.class);
        
        return login;
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
        con.setRequestProperty("Accept-Language", "pt-Br");
        
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
