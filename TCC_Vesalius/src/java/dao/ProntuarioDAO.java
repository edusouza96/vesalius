package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Prontuario;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class ProntuarioDAO implements Dao{
 
    /**
     * metodo construtor da classe prontuarioDAO
     */
    public ProntuarioDAO(){    
    }
      
    /**
     * salva um registro na tabela prontuario
     * Recebe por parametro um objeto do prontuario
     * @param prontuarioParametro
     */
    @Override
    public void salvar(Object prontuarioParametro) {
        Prontuario prontuario;
        prontuario = (Prontuario) prontuarioParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(prontuario.getIdProntuario() == 0){
            em.persist(prontuario);
        }else{
            em.merge(prontuario);
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Exclui um registro da tabela prontuario 
     * Recebe por parametro um objeto do tipo prontuario
     * @param prontuarioParametro 
     */
    @Override
    public void deletar(Object prontuarioParametro) {
        Prontuario prontuario;
        prontuario = (Prontuario) prontuarioParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(prontuario));
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Lista todos os registros da prontuario
     * @return uma list
     */
    @Override
    public List<Prontuario> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Prontuario> listaProntuario = em.createQuery("SELECT pron FROM Prontuario pron").getResultList();       
        em.close();
        return (listaProntuario);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id da prontuario do tipo int
     * @param id
     * @return um objeto do tipo prontuario
     */
    @Override
    public Object procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Prontuario prontuario = em.find(Prontuario.class, id);
        em.close();
        return (prontuario);
    }
     

}
