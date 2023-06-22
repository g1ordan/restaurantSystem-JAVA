import java.util.ArrayList;

public interface DAO<T> {
    public void inserir (T obj);
    public void deletar (int codigo);
    public void editar (T obj);
    public ArrayList<T> getAll ();
    public T getByCod (int codigo);
}
