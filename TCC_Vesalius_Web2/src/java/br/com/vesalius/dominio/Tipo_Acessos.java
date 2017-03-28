package br.com.vesalius.dominio;

/**
 * Classe tipo acessos, responsável por modelar o objeto referente aos tipos de acessos que cada user tem
 * @author Edu
 */

public class Tipo_Acessos {
   
    private int idTipoAcessos;
    private String descricaoTipoAcessos;
    private int relatorioTipoAcessos;
    private int financeiroTipoAcessos;
    private int estoqueTipoAcessos;
    private int agendaTipoAcessos;
    private int pacienteTipoAcessos;
    private int procedimentoTipoAcessos;

    public Tipo_Acessos() {
    }

    public int getIdTipoAcessos() {
        return idTipoAcessos;
    }

    public void setIdTipoAcessos(int idTipoAcessos) {
        this.idTipoAcessos = idTipoAcessos;
    }

    public String getDescricaoTipoAcessos() {
        return descricaoTipoAcessos;
    }

    public int getRelatorioTipoAcessos() {
        return relatorioTipoAcessos;
    }

    public int getFinanceiroTipoAcessos() {
        return financeiroTipoAcessos;
    }

    public int getEstoqueTipoAcessos() {
        return estoqueTipoAcessos;
    }

    public int getAgendaTipoAcessos() {
        return agendaTipoAcessos;
    }

    public int getPacienteTipoAcessos() {
        return pacienteTipoAcessos;
    }

    public int getProcedimentoTipoAcessos() {
        return procedimentoTipoAcessos;
    }
    
    
    
}
