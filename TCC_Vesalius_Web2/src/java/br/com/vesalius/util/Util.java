/*
 * Classe com metodos uteis
 */
package br.com.vesalius.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edu
 */
public class Util {
    /**
     * Método para formatar a data para enviar a json
     * @param data
     * @return 
     */
    public String dateUs2Br(String data){
        String dataFormatada;
        if(!data.equals("")){
            dataFormatada = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4);
        }else{
            dataFormatada = "00/00/0000";
        }
        return dataFormatada+" 00:00:00";
    }
    
    /**
     * Método para formatar a data para enviar a json
     * @param data
     * @param hora
     * @return 
     */
    public String dateUs2Br(String data, String hora){
        String dataFormatada;
        if(!data.equals("")){
            dataFormatada = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4);
        }else{
            dataFormatada = "00/00/0000";
        }
        if(hora.isEmpty()){
            return dataFormatada+" 00:00:00";            
        }else{
            return dataFormatada+" "+hora;
        }
    }
    
    /**
     * Método para formatar a data para enviar a json
     * @param data
     * @return 
     */
    public String dateBr2Us(String data){
        String dataFormatada;
        String mes = "00";
        if(data == null){
            data = "";
        }else{
            switch(data.substring(0, 3)){
                case "Jan":
                    mes = "01";
                    break;
                case "Feb":
                    mes = "02";
                    break;
                case "Mar":
                    mes = "03";
                    break;
                case "Apr":
                    mes = "04";
                    break;
                case "May":
                    mes = "05";
                    break;
                case "Jun":
                    mes = "06";
                    break;
                case "Jul":
                    mes = "07";
                    break;
                case "Aug":
                    mes = "08";
                    break;
                case "Sep":
                    mes = "09";
                    break;
                case "Oct":
                    mes = "10";
                    break;
                case "Nov":
                    mes = "11";
                    break;
                case "Dec":
                    mes = "12";
                    break;
                default:
                    mes = "01";
                    break;
            }
        }
        
        if(!data.equals("")){
            if(data.substring(5, 6).equals(",")){
                dataFormatada = data.substring(7, 11)+"-"+mes+"-0"+data.substring(4, 5);
            }else{
                dataFormatada = data.substring(8, 12)+"-"+mes+"-"+data.substring(4, 6);
            }
            
        }else{
            dataFormatada = "0000-00-00";
        }
        return dataFormatada;
         
    }
    
    /**
     * Método para retirar as horas
     * @param data
     * @return 
     */
    public String removeHour(String data){
        String dataFormatada;
        if(!data.equals("")){
            dataFormatada = data.substring(6, 10)+"-"+data.substring(3, 5)+"-"+data.substring(0, 2);
        }else{
            dataFormatada = "0000-00-00";
        }
        return dataFormatada;
    }
    
    /**
     * Método para formatar a data de extenso para dd/mm/yyyy
     * @param data
     * @return 
     */
    public String showDate(Date data){
        if(data == null){
            return "";
        }else{
            return new SimpleDateFormat("dd/MM/yyyy").format(data);
        }
    }
    
    /**
     * Método para formatar a data de dd/MM/yyyy para yyyy-mm-dd
     * @param data
     * @return 
     */
    public String showDateUs(Date data){
        if(data == null){
            return "";
        }else{
            return new SimpleDateFormat("yyyy-MM-dd").format(data);
        }
    }
    
    /**
     * Método para formatar a data de dd/MM/yyyy HH:mm para yyyy-mm-dd HH:mm
     * @param data
     * @return 
     */
    public String showDateHourUs(Date data){
        if(data == null){
            return "";
        }else{
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(data);
        }
    }
//        Gravar em arquivo
//        FileWriter arq = new FileWriter("C:\\Users\\Eduardo\\Desktop\\tst\\teste.txt");
//        PrintWriter gravarArq = new PrintWriter(arq);
//
//        gravarArq.printf(paciente.getNomePaciente());
//
//        arq.close();
}
