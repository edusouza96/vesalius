package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe tipo acessos, responsável por modelar o objeto referente aos tipos de acessos que cada user tem
 * @author Edu
 */
@Entity
@XmlRootElement
public class Tipo_Acessos implements Serializable {
    @Id 
    @GeneratedValue
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
    
    
}
