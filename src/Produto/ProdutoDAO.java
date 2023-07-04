import java.util.ArrayList;

public class ProdutoDAO implements DAO<Produto> {
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();

    /**
     * Insere um novo produto no banco de dados
     * @param produto a ser inserido no banco de dados
     */
    @Override
    public void inserir(Produto produto){
        int maiorCodigo = 0;
         for(int i = 0; i < ProdutoDAO.produtos.size(); i++){
            int codigoAtual = ProdutoDAO.produtos.get(i).getcod();
            if(codigoAtual > maiorCodigo){
                maiorCodigo = codigoAtual;
            }
        }
        produto.setCod(maiorCodigo + 1);
        ProdutoDAO.produtos.add(produto);
    }

    /**
     * Retorna todos os produtos do banco de dados
     * @return ArrayList<Produto>
     */
    public ArrayList<Produto> getAll(){
        return ProdutoDAO.produtos;
    }

    /**
     * Deleta um produto do banco de dados 
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

    /**
     * Procura um produto no banco de dados, caso não ache o produto, retorna null 
     * @param codigo do produto a ser buscado no banco de dados
     * @return Produto
     */
    @Override
    public Produto getByCod(int codigo){
        for(int i = 0; i < ProdutoDAO.produtos.size(); i++){
            Produto produtoAtual = ProdutoDAO.produtos.get(i);
            if(codigo == produtoAtual.getcod())
                return produtoAtual;
        }  

        return null;
    }

    /**
     * Procura vários produtos no banco de dados 
     * @param codigos dos produtos a serem buscados no banco de dados
     * @return ArrayList<Produto>
     */
    public ArrayList<Produto> getByCods(ArrayList<Integer> codigos){
        ArrayList<Produto> produtosEncontrados = new ArrayList<Produto>();

        for(int i = 0; i < ProdutoDAO.produtos.size(); i++) {
            if(codigos.contains(ProdutoDAO.produtos.get(i).getcod())) {
                produtosEncontrados.add(ProdutoDAO.produtos.get(i));
            }
        }

        return produtosEncontrados;
    }

    /**
     * Busca o produto pelo seu código, caso encontre, o mesmo é editado, caso contrário, nada acontece
     * @param produto a ser editado no banco de dados
     */
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


