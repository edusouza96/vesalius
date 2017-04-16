package dao;

import util.Util;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Financeiro;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class FinanceiroDAO implements Dao{
 
    /**
     * metodo construtor da classe FinanceiroDAO
     */
    public FinanceiroDAO(){    
    }
      
    /**
     * salva um registro na tabela financeiro
     * Recebe por parametro um objeto do financeiro
     * @param financeiroParametro
     */
    @Override
    public void salvar(Object financeiroParametro) {
        Financeiro financeiro;
        financeiro = (Financeiro) financeiroParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(financeiro.getIdFinanceiro() == 0){
            em.persist(financeiro);
        }else{
            em.merge(financeiro);
        }
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    /**
     * Exclui um registro da tabela financeiro 
     * Recebe por parametro um objeto do tipo financeiro
     * @param financeiroParametro 
     */
    @Override
    public void deletar(Object financeiroParametro) {
        Financeiro financeiro;
        financeiro = (Financeiro) financeiroParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(financeiro));
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
    
    /**
     * Lista todos os registros da financeiro
     * @return uma list
     */
    @Override
    public List<Financeiro> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Financeiro> listaFinanceiro = em.createQuery("SELECT fin FROM Financeiro fin").getResultList();       
        em.close();
        factory.close();
        return (listaFinanceiro);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id da financeiro do tipo int
     * @param id
     * @return um objeto do tipo financeiro
     */
    @Override
    public Financeiro procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Financeiro financeiro = em.find(Financeiro.class, id);
        em.close();
        factory.close();
        return (financeiro);
    }
    
    /**
     * Lista todos os registros de acordo com a clause where
     * @return uma list
     */
    public List<Financeiro> listaFiltrada(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT fin FROM Financeiro fin WHERE (fin.statusFinanceiro = 0 AND fin.vencimentoFinanceiro < :mesLimite) OR (fin.statusFinanceiro = 1 AND fin.vencimentoFinanceiro >= :mesAtual AND fin.vencimentoFinanceiro < :mesLimite) ORDER BY fin.vencimentoFinanceiro ASC, fin.statusFinanceiro ASC");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        query.setParameter("mesAtual",calendar.getTime());
        calendar.add(Calendar.MONTH, 3);
        query.setParameter("mesLimite",calendar.getTime());
        List<Financeiro> listaFinanceiro = query.getResultList();
        em.close();
        factory.close();
        return (listaFinanceiro);
    }
}
