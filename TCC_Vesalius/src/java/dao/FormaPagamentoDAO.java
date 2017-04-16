package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Forma_Pagamento;


/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class FormaPagamentoDAO implements Dao{
 
    /**
     * metodo construtor da classe tipoAcessosDAO
     */
    public FormaPagamentoDAO(){    
    }
      
  
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id do tipo int
     * @param id
     * @return um objeto 
     */
    @Override
    public Forma_Pagamento procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Forma_Pagamento fPagamento = em.find(Forma_Pagamento.class, id);
        em.close();
        factory.close();
        return (fPagamento);
    }

    @Override
    public void salvar(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Forma_Pagamento> listaFormaPagamento = em.createQuery("SELECT proc FROM Forma_Pagamento proc").getResultList();       
        em.close();
        factory.close();
        return (listaFormaPagamento);
    }

    @Override
    public void deletar(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

}
