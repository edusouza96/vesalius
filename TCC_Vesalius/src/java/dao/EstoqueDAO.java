package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Estoque;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class EstoqueDAO implements Dao{
 
    /**
     * metodo construtor da classe estoqueDAO
     */
    public EstoqueDAO(){    
    }
      
    /**
     * salva um registro na tabela estoque
     * Recebe por parametro um objeto do estoque
     * @param estoqueParametro
     */
    @Override
    public void salvar(Object estoqueParametro) {
        Estoque estoque;
        estoque = (Estoque) estoqueParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(estoque.getIdEstoque() == 0){
            em.persist(estoque);
        }else{
            em.merge(estoque);
        }
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    /**
     * Exclui um registro da tabela estoque 
     * Recebe por parametro um objeto do tipo estoque
     * @param estoqueParametro 
     */
    @Override
    public void deletar(Object estoqueParametro) {
        Estoque estoque;
        estoque = (Estoque) estoqueParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(estoque));
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
    
    /**
     * Lista todos os registros da estoque
     * @return uma list
     */
    @Override
    public List<Estoque> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Estoque> listaEstoque = em.createQuery("SELECT est FROM Estoque est ORDER BY est.itemEstoque").getResultList();       
        em.close();
        factory.close();
        return (listaEstoque);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id da estoque do tipo int
     * @param id
     * @return um objeto do tipo estoque
     */
    @Override
    public Estoque procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Estoque estoque = em.find(Estoque.class, id);
        em.close();
        factory.close();
        return (estoque);
    }
     

}
