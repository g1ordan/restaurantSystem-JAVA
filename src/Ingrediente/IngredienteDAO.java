import java.util.ArrayList;
import java.util.Arrays;

public class IngredienteDAO {
    private static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    /**
     * @param novosIngredientes ArrayList de ingredientes a serem inseridos no banco dados
     * @return ArrayList<Integer>
     */
    public void inserir(Ingrediente ingrediente){
        int maiorCodigo = 1;
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
    public ArrayList<Ingrediente> getAll() {
        return IngredienteDAO.ingredientes;
    }

}