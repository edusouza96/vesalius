package br.com.vesalius.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import br.com.vesalius.dominio.Financeiro;
import br.com.vesalius.util.Util;
import java.util.Date;


public class HttpFinanceiroDAO{

   private final String USER_AGENT = "Mozila/5.0";
   
   public static void remover(Financeiro financeiro) throws Exception{
        HttpFinanceiroDAO http = new HttpFinanceiroDAO();
        Gson gson = new Gson();
        Type financeiroType = new TypeToken<Financeiro>(){}.getType();
        String json = gson.toJson(financeiro,financeiroType);
        String url = "http://localhost:8080/TCC_Vesalius/webresources/financeiro/excluir";
        http.sendPost(url, json, "PUT");
    }
   
    public static void salvar(Financeiro financeiro) throws Exception{
        HttpFinanceiroDAO http = new HttpFinanceiroDAO();
        Gson gson = new Gson();
        Type financeiroType = new TypeToken<Financeiro>(){}.getType();
        String json = gson.toJson(financeiro,financeiroType);
        json = (new String(json.getBytes("UTF-8"), "ISO-8859-1"));
        if(financeiro.getIdFinanceiro()>0){
            String url = "http://localhost:8080/TCC_Vesalius/webresources/financeiro/alterar";
            http.sendPost(url, json, "PUT");
        }else{
            String url = "http://localhost:8080/TCC_Vesalius/webresources/financeiro/inserir";
            http.sendPost(url, json, "POST");
        }
    }
    
    public static Financeiro[] listar() throws Exception{
        HttpFinanceiroDAO http = new HttpFinanceiroDAO();
        Gson gson = new Gson();
        Type financeiroType = new TypeToken<Financeiro>(){}.getType();
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/financeiro/listar";
        String json = http.sendGet(chamadaWS, "GET");
        Financeiro[] financeiro = gson.fromJson(json, Financeiro[].class);
        return financeiro;
    }
    
    public static Financeiro[] listaFiltrada() throws Exception{
        HttpFinanceiroDAO http = new HttpFinanceiroDAO();
        Gson gson = new Gson();
        Type financeiroType = new TypeToken<Financeiro>(){}.getType();
        
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/financeiro/listaFiltrada";
        String json = http.sendGet(chamadaWS, "GET");
        Financeiro[] financeiro = gson.fromJson(json, Financeiro[].class);
        for (Financeiro fin : financeiro) {
            Date data = fin.getVencimentoFinanceiro();
            fin.setVencimentoFinanceiroStr(new Util().showDate(data));
            
        }
        return financeiro;
    }
    
    public static Financeiro buscar(Financeiro financeiroParametro) throws Exception{
        HttpFinanceiroDAO http = new HttpFinanceiroDAO();
        Gson gson = new Gson();
        Type financeiroType = new TypeToken<Financeiro>(){}.getType();
               
        String chamadaWS = "http://localhost:8080/TCC_Vesalius/webresources/financeiro/busca/"+financeiroParametro.getIdFinanceiro();
        String json = http.sendGet(chamadaWS, "GET");
        Financeiro financeiro = gson.fromJson(json, Financeiro.class);
        Date data = financeiro.getVencimentoFinanceiro();
        financeiro.setVencimentoFinanceiroStr(new Util().showDate(data));
        return financeiro;
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
