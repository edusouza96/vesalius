package br.com.vesalius.dao;

import br.com.vesalius.dominio.Relatorio;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import br.com.vesalius.util.Util;
import java.util.Collection;


public class HttpRelatorioDAO {

   private final String USER_AGENT = "Mozila/5.0";
       
    public static Collection<Relatorio> consultasPorMes(Relatorio relatorioParametro) throws Exception{
        HttpRelatorioDAO http = new HttpRelatorioDAO();
        Gson gson = new Gson();
        Type relatorioType = new TypeToken<Relatorio>(){}.getType();
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/relatorio/consultasPorMes/"+relatorioParametro.getField1()+"/"+relatorioParametro.getField2()+"/";
        String json = http.sendGet(chamadaWS, "GET");
        //Relatorio[] relatorio = gson.fromJson(json, Relatorio[].class);
        Type collectionType = new TypeToken<Collection<Relatorio>>(){}.getType();
        Collection<Relatorio> relatorio = gson.fromJson(json, collectionType);
        return relatorio;
    }
    
    public static Collection<Relatorio> pacientesNovosPorMes(Relatorio relatorioParametro) throws Exception{
        HttpRelatorioDAO http = new HttpRelatorioDAO();
        Gson gson = new Gson();
        Type relatorioType = new TypeToken<Relatorio>(){}.getType();
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/relatorio/pacientesNovosPorMes/"+relatorioParametro.getField1()+"/"+relatorioParametro.getField2()+"/";
        String json = http.sendGet(chamadaWS, "GET");
        Type collectionType = new TypeToken<Collection<Relatorio>>(){}.getType();
        Collection<Relatorio> relatorio = gson.fromJson(json, collectionType);
        return relatorio;
    }
        
    public static Collection<Relatorio> procedimentosMes(Relatorio relatorioParametro) throws Exception{
        HttpRelatorioDAO http = new HttpRelatorioDAO();
        Gson gson = new Gson();
        Type relatorioType = new TypeToken<Relatorio>(){}.getType();
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/relatorio/procedimentosMes/"+relatorioParametro.getField1()+"/"+relatorioParametro.getField2()+"/";
        String json = http.sendGet(chamadaWS, "GET");
        Type collectionType = new TypeToken<Collection<Relatorio>>(){}.getType();
        Collection<Relatorio> relatorio = gson.fromJson(json, collectionType);
        return relatorio;
    }
    
    public static Collection<Relatorio> financeiroAno(Relatorio relatorioParametro) throws Exception{
        HttpRelatorioDAO http = new HttpRelatorioDAO();
        Gson gson = new Gson();
        Type relatorioType = new TypeToken<Relatorio>(){}.getType();
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/relatorio/financeiroAno/"+relatorioParametro.getField1()+"/";
        String json = http.sendGet(chamadaWS, "GET");
        Type collectionType = new TypeToken<Collection<Relatorio>>(){}.getType();
        Collection<Relatorio> relatorio = gson.fromJson(json, collectionType);
        return relatorio;
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
