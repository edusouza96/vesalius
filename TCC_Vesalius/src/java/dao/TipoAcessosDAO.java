package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tipo_Acessos;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class TipoAcessosDAO implements Dao{
 
    /**
     * metodo construtor da classe tipoAcessosDAO
     */
    public TipoAcessosDAO(){    
    }
      
  
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id do tipo int
     * @param id
     * @return um objeto 
     */
    @Override
    public Tipo_Acessos procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Tipo_Acessos tAcesso = em.find(Tipo_Acessos.class, id);
        em.close();
        factory.close();
        return (tAcesso);
    }

    @Override
    public void salvar(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

}
