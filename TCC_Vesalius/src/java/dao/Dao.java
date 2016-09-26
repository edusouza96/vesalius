package dao;

import java.util.List;

/**
 *
 * @author Edu
 * Classe que contem as 'Assinaturas' dos metodos a ser implementados
 * salvar(T model)
 * adiciona ou atualiza um registro de dados
 * listar()
 * lista um conjunto de dados
 * procurarPorId(int id)
 * procura um registro de dados através de um id valido inserido
 * deletar(T model)
 * deleta um registro de dados
 * @param <T> Parametro do generic, oou seja, uma forma genérica de representar todos os tipos de objetos
 */
public interface Dao<T> {
    public void salvar(T model);
    public List<T> listar();
    public T procurarPorId(int id);
    public void deletar(T model);
}
