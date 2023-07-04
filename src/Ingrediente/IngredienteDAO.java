import java.util.ArrayList;
import java.util.Arrays;

public class IngredienteDAO implements DAO<Ingrediente> {
    private static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    /**
     * Insere um novo ingrediente no banco de dados
     * @param ingrediente a ser inserido no banco dados
     */
    @Override
    public void inserir(Ingrediente ingrediente){
        int maiorCodigo = 0;
        for(int i = 0; i < IngredienteDAO.ingredientes.size(); i++){
           int codigoAtual = IngredienteDAO.ingredientes.get(i).getCod();
           if(codigoAtual > maiorCodigo){
               maiorCodigo = codigoAtual;
           }
        }
        ingrediente.setCod(maiorCodigo + 1);
        IngredienteDAO.ingredientes.add(ingrediente);
    }
    
    /**
     * Busca os ingredientes de acordo com os seus nomes 
     * @param nomes Array de nomes a serem buscados no banco de dados
     * @return ArrayList<Integer> códigos encontrados a partir dos nomes 
     */
    public ArrayList<Integer> getCodByNomes(String[] nomes) {
        ArrayList<Integer> ingredientesCod = new ArrayList<Integer>();

        for(int i = 0; i < IngredienteDAO.ingredientes.size(); i++) {
            if(Arrays.asList(nomes).contains(IngredienteDAO.ingredientes.get(i).getNome())) {
                ingredientesCod.add(IngredienteDAO.ingredientes.get(i).getCod());
            }
        }

        return ingredientesCod;
    }

    /**
     * @param cods Arraylist de códigos a serem buscados no banco de dados
     * @return ArrayList<Ingrediente>
     */
    public ArrayList<Ingrediente> getByCods(ArrayList<Integer> cods) {
        ArrayList<Ingrediente> ingredientesEncontrados = new ArrayList<Ingrediente>();

        for(int i = 0; i < IngredienteDAO.ingredientes.size(); i++) {
            if(cods.contains(IngredienteDAO.ingredientes.get(i).getCod())) {
                ingredientesEncontrados.add(IngredienteDAO.ingredientes.get(i));
            }
        }

        return ingredientesEncontrados;
    }

    /**
     * Retorna todos os ingredientes do banco de dados
     * @return ArrayList<Ingrediente> 
     */
    @Override
    public ArrayList<Ingrediente> getAll() {
        return IngredienteDAO.ingredientes;
    }

    /**
     * Deleta um ingrediente do banco de dados 
     * @param codigo do ingrediente que vai ser deletado do banco de dados
     */
    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < IngredienteDAO.ingredientes.size(); i++){
            if(codigo == IngredienteDAO.ingredientes.get(i).getCod()){
                IngredienteDAO.ingredientes.remove(i);
            }
        }
    }

    /**
     * Busca o ingrediente pelo seu código, caso encontre, o mesmo é editado, caso contrário, nada acontece
     * @param ingrediente a ser editado no banco de dados
     */
    @Override
    public void editar(Ingrediente ingrediente) {
        for(int i = 0; i < IngredienteDAO.ingredientes.size(); i++) {
            Ingrediente ingredienteAtual = IngredienteDAO.ingredientes.get(i);
            if(ingredienteAtual.getCod() == ingrediente.getCod()) {
                IngredienteDAO.ingredientes.set(i, ingrediente);
                return;
            }
        }
    }

    /**
     * Procura um ingrediente no banco de dados, caso não ache o ingrediente, retorna null 
     * @param codigo do ingrediente a ser buscado no banco de dados
     * @return Ingrediente
     */
    @Override
    public Ingrediente getByCod(int codigo) {
        for(int i = 0; i < IngredienteDAO.ingredientes.size(); i++){
            Ingrediente ingredienteAtual = IngredienteDAO.ingredientes.get(i);
            if(codigo == ingredienteAtual.getCod())
                return ingredienteAtual;
        }  

        return null;
    }

}