package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Agenda;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class AgendaDAO implements Dao{
 
    /**
     * metodo construtor da classe agendaDAO
     */
    public AgendaDAO(){    
    }
      
    /**
     * salva um registro na tabela agenda
     * Recebe por parametro um objeto do tipo Agenda 
     * @param agendaParametro
     */
    @Override
    public void salvar(Object agendaParametro) {
        Agenda agenda;
        agenda = (Agenda) agendaParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(agenda.getIdAgenda() == 0){
            em.persist(agenda);
        }else{
            em.merge(agenda);
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Exclui um registro da tabela agenda 
     * Recebe por parametro um objeto do tipo agenda
     * @param agendaParametro 
     */
    @Override
    public void deletar(Object agendaParametro) {
        Agenda agenda;
        agenda = (Agenda) agendaParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(agenda));
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Lista todos os registros da agenda
     * @return uma list
     */
    @Override
    public List<Agenda> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Agenda> listaAgenda = em.createQuery("SELECT age FROM Agenda age").getResultList();       
        em.close();
        return (listaAgenda);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id da agenda do tipo int
     * @param id
     * @return um objeto do tipo agenda
     */
    @Override
    public Object procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Agenda agenda = em.find(Agenda.class, id);
        em.close();
        return (agenda);
    }
     

}
