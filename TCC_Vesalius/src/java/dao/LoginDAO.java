package dao;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Login;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class LoginDAO implements Dao{
 
    /**
     * metodo construtor da classe LoginDAO
     */
    public LoginDAO(){    
    }
      
    /**
     * salva um registro na tabela login
     * Recebe por parametro um objeto do login
     * @param loginParametro
     */
    @Override
    public void salvar(Object loginParametro) {
        Login login;
        login = (Login) loginParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(login.getIdLogin() == 0){
            em.persist(login);
        }else{
            em.merge(login);
        }
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    /**
     * Exclui um registro da tabela login 
     * Recebe por parametro um objeto do tipo login
     * @param loginParametro 
     */
    @Override
    public void deletar(Object loginParametro) {
        Login login;
        login = (Login) loginParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(login));
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
    
    /**
     * Lista todos os registros da login
     * @return uma list
     */
    @Override
    public List<Login> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Login> listaLogin = em.createQuery("SELECT log FROM Login log").getResultList();       
        em.close();
        factory.close();
        return (listaLogin);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id da login do tipo int
     * @param id
     * @return um objeto do tipo login
     */
    @Override
    public Login procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Login login = em.find(Login.class, id);
        em.close();
        factory.close();
        return (login);
    }
    
    /**
     * Busca pelo dados do login
     * @param userLogin
     * @param passwordLogin
     * @return um login
     */
    public Login procurarPorLogin(String userLogin, String passwordLogin){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT log FROM Login log WHERE log.userLogin = :userLogin AND log.passwordLogin = :passwordLogin");
        query.setParameter("userLogin",userLogin);
        query.setParameter("passwordLogin",passwordLogin);
        List<Login> login = query.getResultList();
        em.close();
        factory.close();
        if(login.isEmpty()){
            return new Login();
        }else{
            return (login.get(0));
        }
    }
}
