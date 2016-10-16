package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Classe paciente, responsável por modelar o objeto referente a paciente
 * @author Edu
 */
@Entity
@XmlRootElement
public class Paciente {
    @Id 
    @GeneratedValue
    private int idPaciente;
    private String nomePaciente;
    private Date nascimentoPaciente;
    private String cpfPaciente;
    private String fotoPaciente;
    private int tipoAcessos;
    private String profissaoPaciente;
    private String emailPaciente;
    private String indicacaoPaciente;
    private int telefonePaciente;
    private int telefoneOpcionalPaciente;
    private int whatsappPaciente;
    private String facebookPaciente;
    private String cidadePaciente;
    private String bairroPaciente;
    private String logradouroPaciente;
    private String numeroPaciente;
    private Date inicioTratamentoPaciente;
    private Date terminoTratamentoPaciente;
    private boolean diabetePaciente;
    private String diabeteDescricaoPaciente;
    private boolean aidsPaciente;
    private String aidsDescricaoPaciente;
    private boolean hepatitePaciente;
    private String hepatiteDescricaoPaciente;
    private boolean fumantePaciente;
    private String fumanteDescricaoPaciente;
    private boolean gravidezPaciente;
    private String gravidezDescricaoPaciente;
    private boolean alergicoPaciente;
    private String alergicoDescricaoPaciente;
    private String outrasDoencasPaciente;

    /**
     * 
     * @return 
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * 
     * @param idPaciente 
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * 
     * @param nomePaciente 
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    /**
     * 
     * @return 
     */
    public Date getNascimentoPaciente() {
        return nascimentoPaciente;
    }

    /**
     * 
     * @param nascimentoPaciente 
     */
    public void setNascimentoPaciente(Date nascimentoPaciente) {
        this.nascimentoPaciente = nascimentoPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getCpfPaciente() {
        return cpfPaciente;
    }

    /**
     * 
     * @param cpfPaciente 
     */
    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }
    
    /**
     * 
     * @return 
     */
    public String getFotoPaciente() {
        return fotoPaciente;
    }

    /**
     * 
     * @param fotoPaciente 
     */
    public void setFotoPaciente(String fotoPaciente) {
        this.fotoPaciente = fotoPaciente;
    }

    /**
     * 
     * @return 
     */
    public int getTipoAcessos() {
        return tipoAcessos;
    }

    /**
     * 
     * @param tipoAcessos 
     */
    public void setTipoAcessos(int tipoAcessos) {
        this.tipoAcessos = tipoAcessos;
    }

    /**
     * 
     * @return 
     */
    public String getProfissaoPaciente() {
        return profissaoPaciente;
    }

    /**
     * 
     * @param profissaoPaciente 
     */
    public void setProfissaoPaciente(String profissaoPaciente) {
        this.profissaoPaciente = profissaoPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getEmailPaciente() {
        return emailPaciente;
    }

    /**
     * 
     * @param emailPaciente 
     */
    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getIndicacaoPaciente() {
        return indicacaoPaciente;
    }

    /**
     * 
     * @param indicacaoPaciente 
     */
    public void setIndicacaoPaciente(String indicacaoPaciente) {
        this.indicacaoPaciente = indicacaoPaciente;
    }

    /**
     * 
     * @return 
     */
    public int getTelefonePaciente() {
        return telefonePaciente;
    }

    /**
     * 
     * @param telefonePaciente 
     */
    public void setTelefonePaciente(int telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    /**
     * 
     * @return 
     */
    public int getTelefoneOpcionalPaciente() {
        return telefoneOpcionalPaciente;
    }

    /**
     * 
     * @param telefoneOpcionalPaciente 
     */
    public void setTelefoneOpcionalPaciente(int telefoneOpcionalPaciente) {
        this.telefoneOpcionalPaciente = telefoneOpcionalPaciente;
    }

    /**
     * 
     * @return 
     */
    public int getWhatsappPaciente() {
        return whatsappPaciente;
    }

    /**
     * 
     * @param whatsappPaciente 
     */
    public void setWhatsappPaciente(int whatsappPaciente) {
        this.whatsappPaciente = whatsappPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getFacebookPaciente() {
        return facebookPaciente;
    }

    /**
     * 
     * @param facebookPaciente 
     */
    public void setFacebookPaciente(String facebookPaciente) {
        this.facebookPaciente = facebookPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getCidadePaciente() {
        return cidadePaciente;
    }

    /**
     * 
     * @param cidadePaciente 
     */
    public void setCidadePaciente(String cidadePaciente) {
        this.cidadePaciente = cidadePaciente;
    }

    /**
     * 
     * @return 
     */
    public String getBairroPaciente() {
        return bairroPaciente;
    }

    /**
     * 
     * @param bairroPaciente 
     */
    public void setBairroPaciente(String bairroPaciente) {
        this.bairroPaciente = bairroPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getLogradouroPaciente() {
        return logradouroPaciente;
    }

    /**
     * 
     * @param logradouroPaciente 
     */
    public void setLogradouroPaciente(String logradouroPaciente) {
        this.logradouroPaciente = logradouroPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getNumeroPaciente() {
        return numeroPaciente;
    }

    /**
     * 
     * @param numeroPaciente 
     */
    public void setNumeroPaciente(String numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
    }

    /**
     * 
     * @return 
     */
    public Date getInicioTratamentoPaciente() {
        return inicioTratamentoPaciente;
    }

    /**
     * 
     * @param inicioTratamentoPaciente 
     */
    public void setInicioTratamentoPaciente(Date inicioTratamentoPaciente) {
        this.inicioTratamentoPaciente = inicioTratamentoPaciente;
    }

    /**
     * 
     * @return 
     */
    public Date getTerminoTratamentoPaciente() {
        return terminoTratamentoPaciente;
    }

    /**
     * 
     * @param terminoTratamentoPaciente 
     */
    public void setTerminoTratamentoPaciente(Date terminoTratamentoPaciente) {
        this.terminoTratamentoPaciente = terminoTratamentoPaciente;
    }

    /**
     * 
     * @return 
     */
    public boolean isDiabetePaciente() {
        return diabetePaciente;
    }

    /**
     * 
     * @param diabetePaciente 
     */
    public void setDiabetePaciente(boolean diabetePaciente) {
        this.diabetePaciente = diabetePaciente;
    }

    /**
     * 
     * @return 
     */
    public String getDiabeteDescricaoPaciente() {
        return diabeteDescricaoPaciente;
    }

    /**
     * 
     * @param diabeteDescricaoPaciente 
     */
    public void setDiabeteDescricaoPaciente(String diabeteDescricaoPaciente) {
        this.diabeteDescricaoPaciente = diabeteDescricaoPaciente;
    }

    /**
     * 
     * @return 
     */
    public boolean isAidsPaciente() {
        return aidsPaciente;
    }

    /**
     * 
     * @param aidsPaciente 
     */
    public void setAidsPaciente(boolean aidsPaciente) {
        this.aidsPaciente = aidsPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getAidsDescricaoPaciente() {
        return aidsDescricaoPaciente;
    }

    /**
     * 
     * @param aidsDescricaoPaciente 
     */
    public void setAidsDescricaoPaciente(String aidsDescricaoPaciente) {
        this.aidsDescricaoPaciente = aidsDescricaoPaciente;
    }

    /***
     * 
     * @return 
     */
    public boolean isHepatitePaciente() {
        return hepatitePaciente;
    }

    /**
     * 
     * @param hepatitePaciente 
     */
    public void setHepatitePaciente(boolean hepatitePaciente) {
        this.hepatitePaciente = hepatitePaciente;
    }

    /**
     * 
     * @return 
     */
    public String getHepatiteDescricaoPaciente() {
        return hepatiteDescricaoPaciente;
    }

    /**
     * 
     * @param hepatiteDescricaoPaciente 
     */
    public void setHepatiteDescricaoPaciente(String hepatiteDescricaoPaciente) {
        this.hepatiteDescricaoPaciente = hepatiteDescricaoPaciente;
    }

    /**
     * 
     * @return 
     */
    public boolean isFumantePaciente() {
        return fumantePaciente;
    }

    /**
     * 
     * @param fumantePaciente 
     */
    public void setFumantePaciente(boolean fumantePaciente) {
        this.fumantePaciente = fumantePaciente;
    }

    /**
     * 
     * @return 
     */
    public String getFumanteDescricaoPaciente() {
        return fumanteDescricaoPaciente;
    }

    /**
     * 
     * @param fumanteDescricaoPaciente 
     */
    public void setFumanteDescricaoPaciente(String fumanteDescricaoPaciente) {
        this.fumanteDescricaoPaciente = fumanteDescricaoPaciente;
    }

    /**
     * 
     * @return 
     */
    public boolean isGravidezPaciente() {
        return gravidezPaciente;
    }

    /**
     * 
     * @param gravidezPaciente 
     */
    public void setGravidezPaciente(boolean gravidezPaciente) {
        this.gravidezPaciente = gravidezPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getGravidezDescricaoPaciente() {
        return gravidezDescricaoPaciente;
    }

    /**
     * 
     * @param gravidezDescricaoPaciente 
     */
    public void setGravidezDescricaoPaciente(String gravidezDescricaoPaciente) {
        this.gravidezDescricaoPaciente = gravidezDescricaoPaciente;
    }

    /**
     * 
     * @return 
     */
    public boolean isAlergicoPaciente() {
        return alergicoPaciente;
    }

    /**
     * 
     * @param alergicoPaciente 
     */
    public void setAlergicoPaciente(boolean alergicoPaciente) {
        this.alergicoPaciente = alergicoPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getAlergicoDescricaoPaciente() {
        return alergicoDescricaoPaciente;
    }

    /**
     * 
     * @param alergicoDescricaoPaciente 
     */
    public void setAlergicoDescricaoPaciente(String alergicoDescricaoPaciente) {
        this.alergicoDescricaoPaciente = alergicoDescricaoPaciente;
    }

    /**
     * 
     * @return 
     */
    public String getOutrasDoencasPaciente() {
        return outrasDoencasPaciente;
    }

    /**
     * 
     * @param outrasDoencasPaciente 
     */
    public void setOutrasDoencasPaciente(String outrasDoencasPaciente) {
        this.outrasDoencasPaciente = outrasDoencasPaciente;
    }
     
    
}
