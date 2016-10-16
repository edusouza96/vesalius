package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Paciente;

/**
 *
 * Classe responsavel em manipular os dados para inserir ou buscar do banco de dados. 
 * com os  metodos de inserir, listar, procurarPorId, atualiar, deletar
 * 
 */
public class PacienteDAO implements Dao{
 
    /**
     * metodo construtor da classe pacienteDAO
     */
    public PacienteDAO(){    
    }
      
    /**
     * salva um registro na tabela paciente
     * Recebe por parametro um objeto do tipo Paciente
     * @param pacienteParametro
     */
    @Override
    public void salvar(Object pacienteParametro) {
        Paciente paciente;
        paciente = (Paciente) pacienteParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        if(paciente.getIdPaciente() == 0){
            em.persist(paciente);
        }else{
            em.merge(paciente);
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Exclui um registro da tabela paciente 
     * Recebe por parametro um objeto do tipo paciente
     * @param pacienteParametro 
     */
    @Override
    public void deletar(Object pacienteParametro) {
        Paciente paciente;
        paciente = (Paciente) pacienteParametro;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(paciente));
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Lista todos os registros da paciente
     * @return uma list
     */
    @Override
    public List<Paciente> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        List<Paciente> listaPaciente = em.createQuery("SELECT pac FROM Paciente pac").getResultList();       
        em.close();
        return (listaPaciente);
    }
    /**
     * Procura um registro a partir de um ID escolhido
     * Recebe por parametro um id do paciente do tipo int
     * @param id
     * @return um objeto do tipo paciente
     */
    @Override
    public Paciente procurarPorId(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("vesaliusPU"); 
        EntityManager em = factory.createEntityManager();
        Paciente paciente = em.find(Paciente.class, id);
        em.close();
        return (paciente);
    }
     

}
