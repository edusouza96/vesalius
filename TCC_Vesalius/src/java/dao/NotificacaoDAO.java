package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Notificacao;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir,listar, procurarPorId, atualizar, deletar
 * 
 */
public class NotificacaoDAO implements Dao{
 
    /**
     * metodo construtor da classe notificacaoDAO
     */
    public NotificacaoDAO(){    
    }
      
    /**
     * salva um registro na tabela notificacao
     * Recebe por parametro um objeto do tipo notificacao
     * @param notificacaoParametro
     */
    @Override
    public void salvar(Object notificacaoParametro) {
        Notificacao notificacao;
        notificacao = (Notificacao) notificacaoParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(notificacao.getIdNotificacao() == 0){
            em.persist(notificacao);
        }else{
            em.merge(notificacao);
        }
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    /**
     * Exclui um registro da tabela notificacao 
     * Recebe por parametro um objeto do tipo notificacao
     * @param notificacaoParametro 
     */
    @Override
    public void deletar(Object notificacaoParametro) {
        Notificacao notificacao;
        notificacao = (Notificacao) notificacaoParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(notificacao));
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
    
    /**
     * Lista todos os registros da notificacao
     * @return uma list
     */
    @Override
    public List<Notificacao> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Notificacao> listaNotificacao = em.createQuery("SELECT notif FROM Notificacao notif").getResultList();       
        em.close();
        factory.close();
        return (listaNotificacao);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id da notificacao do tipo int
     * @param id
     * @return um objeto do tipo notificacao
     */
    @Override
    public Notificacao procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Notificacao notificacao = em.find(Notificacao.class, id);
        em.close();
        factory.close();
        return (notificacao);
    }
    /**
     * Lista todos os registros da notificacao
     * @param id
     * @return uma list
     */
    public List<Notificacao> listarToken(int id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT notif FROM Notificacao notif WHERE notif.paciente.idPaciente = :idPaciente ");
        query.setParameter("idPaciente", id );
        List<Notificacao> listaNotificacao = query.getResultList();
        em.close();
        factory.close();
        return (listaNotificacao);
    }
     

}
