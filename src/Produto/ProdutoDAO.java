import java.util.ArrayList;

public class ProdutoDAO implements DAO<Produto> {
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();

    /**
     * @param produto a ser inserido no banco de dados

     */
    @Override
    public void inserir(Produto produto){
        int maiorCodigo = 1;
         for(int i = 0; i < ProdutoDAO.produtos.size(); i++){
            int codigoAtual = ProdutoDAO.produtos.get(i).getcod();
            if(codigoAtual > maiorCodigo){
                maiorCodigo = codigoAtual;
            }
        }
        produto.setCod(maiorCodigo + 1);
        ProdutoDAO.produtos.add(produto);
    }

    /*

     * @return ArrayListProdutoe
     * Retorna todos os produtos do banco de dados>
     */
    public ArrayList<Produto> getAll(){
        return ProdutoDAO.produtos;
    }

    /**
     * @param codigo do produto que vai ser deletado do banco de dados
     */
    @Override
    public void deletar(int codigo){
        for (int i = 0; i < ProdutoDAO.produtos.size(); i++){
            if(codigo == ProdutoDAO.produtos.get(i).getcod()){
                ProdutoDAO.produtos.remove(i);
            }
        }
    }  

    @Override
    public Produto getByCod(int codigo){
        for(int i = 0; i < ProdutoDAO.produtos.size(); i++){
            Produto produtoAtual = ProdutoDAO.produtos.get(i);
            if(codigo == produtoAtual.getcod())
                return produtoAtual;
        }  

        throw new Error("Produto não encontrado");
    }

    @Override
    public void editar(Produto produto) {
        for(int i = 0; i < ProdutoDAO.produtos.size(); i++) {
            Produto produtoAtual = ProdutoDAO.produtos.get(i);
            if(produtoAtual.getcod() == produto.getcod()) {
                ProdutoDAO.produtos.set(i, produto);
                return;
            }
        }
    }
    
}


