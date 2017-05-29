package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Relatorio;

/**
 *
 * Classe responsavel em realizar as buscas para os relatorios
 * 
 */
public class RelatorioDAO{
 
    /**
     * metodo construtor da classe RelatorioDAO
     */
    public RelatorioDAO(){    
    }
      
    public List<Relatorio> consultasPorMes(String dataInicio, String dataFim){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(*) AS field1, substring(a.dataAgenda, 1, 7) AS field2 FROM Agenda a WHERE a.dataAgenda >= '"+dataInicio+"' AND a.dataAgenda <= '"+dataFim+"' GROUP BY substring(a.dataAgenda, 1, 7)");        
        List<Relatorio> relatorioLista = new ArrayList<>();
        List<Object[]> relatorioObj = query.getResultList();
        for(int i=0; i<relatorioObj.size(); i++){
            Relatorio relatorio = new Relatorio();
            Object[] aux = relatorioObj.get(i);
            relatorio.setField1(""+(Long)aux[0]);
            relatorio.setField2((String)aux[1]);
            relatorioLista.add(relatorio);
        }
        em.close();
        factory.close();
        return relatorioLista;
    }
    
    public List<Relatorio> pacientesNovosPorMes(String dataInicio, String dataFim){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(*) AS field1, substring(p.inicioTratamentoPaciente, 1, 7) AS field2 FROM Paciente p WHERE p.inicioTratamentoPaciente >= '"+dataInicio+"' AND p.inicioTratamentoPaciente <= '"+dataFim+"' GROUP BY substring(p.inicioTratamentoPaciente, 1, 7)");        
        List<Relatorio> relatorioLista = new ArrayList<>();
        List<Object[]> relatorioObj = query.getResultList();
        for(int i=0; i<relatorioObj.size(); i++){
            Relatorio relatorio = new Relatorio();
            Object[] aux = relatorioObj.get(i);
            relatorio.setField1(""+(Long)aux[0]);
            relatorio.setField2((String)aux[1]);
            relatorioLista.add(relatorio);
        }
        em.close();
        factory.close();
        return relatorioLista;
    }
    
    public List<Relatorio> procedimentosMes(int ano, int mes){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(*) AS field1, (SELECT p.nomeProcedimento FROM Procedimento p WHERE idProcedimento = a.servico ) AS field2, a.servico AS field3, substring(a.dataAgenda, 1, 7) AS field4 FROM Agenda a WHERE a.dataAgenda >= '"+ano+"-"+mes+"-01' AND a.dataAgenda <= '"+ano+"-"+mes+"-31 23:59:59' GROUP BY substring(a.dataAgenda, 1, 7), a.servico");        
        List<Relatorio> relatorioLista = new ArrayList<>();
        List<Object[]> relatorioObj = query.getResultList();
        for(int i=0; i<relatorioObj.size(); i++){
            Relatorio relatorio = new Relatorio();
            Object[] aux = relatorioObj.get(i);
            relatorio.setField1(""+(Long)aux[0]);
            relatorio.setField2((String)aux[1]);
            relatorio.setField3(""+(Integer)aux[2]);
            relatorio.setField4((String)aux[3]);
            relatorioLista.add(relatorio);
        }
        em.close();
        factory.close();
        return relatorioLista;
    }
    
    public List<Relatorio> financeiroAno(int ano){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT SUM(f.valorFinanceiro) AS field1, substring(vencimentoFinanceiro, 6,2) AS field2, (CASE WHEN f.tipoFinanceiro = 1 THEN 1 ELSE 0 END) AS field3 FROM Financeiro f WHERE f.vencimentoFinanceiro >= '"+ano+"-01-01' AND f.vencimentoFinanceiro <= '"+ano+"-12-31 23:59:59' GROUP BY substring(f.vencimentoFinanceiro, 6,2) , f.tipoFinanceiro");        
        List<Relatorio> relatorioLista = new ArrayList<>();
        List<Object[]> relatorioObj = query.getResultList();
        for(int i=0; i<relatorioObj.size(); i++){
            Relatorio relatorio = new Relatorio();
            Object[] aux = relatorioObj.get(i);
            relatorio.setField1(""+(Double)aux[0]);
            relatorio.setField2((String)aux[1]);
            relatorio.setField3(""+(Integer)aux[2]);
            relatorioLista.add(relatorio);
        }
        em.close();
        factory.close();
        return relatorioLista;
    }
}
