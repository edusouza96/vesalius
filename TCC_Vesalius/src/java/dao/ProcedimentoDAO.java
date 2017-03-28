package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Procedimento;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class ProcedimentoDAO implements Dao{
 
    /**
     * metodo construtor da classe procedimentoDAO
     */
    public ProcedimentoDAO(){    
    }
      
    /**
     * salva um registro na tabela procedimento
     * Recebe por parametro um objeto do procedimento
     * @param procedimentoParametro
     */
    @Override
    public void salvar(Object procedimentoParametro) {
        Procedimento procedimento;
        procedimento = (Procedimento) procedimentoParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(procedimento.getIdProcedimento() == 0){
            em.persist(procedimento);
        }else{
            em.merge(procedimento);
        }
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    /**
     * Exclui um registro da tabela procedimento 
     * Recebe por parametro um objeto do tipo procedimento
     * @param procedimentoParametro 
     */
    @Override
    public void deletar(Object procedimentoParametro) {
        Procedimento procedimento;
        procedimento = (Procedimento) procedimentoParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(procedimento));
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
    
    /**
     * Lista todos os registros da procedimento
     * @return uma list
     */
    @Override
    public List<Procedimento> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Procedimento> listaProcedimento = em.createQuery("SELECT proc FROM Procedimento proc").getResultList();       
        em.close();
        factory.close();
        return (listaProcedimento);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id da procedimento do tipo int
     * @param id
     * @return um objeto do tipo procedimento
     */
    @Override
    public Procedimento procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Procedimento procedimento = em.find(Procedimento.class, id);
        em.close();
        factory.close();
        return (procedimento);
    }
     

}
