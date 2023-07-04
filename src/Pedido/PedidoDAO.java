import java.util.ArrayList;

public class PedidoDAO implements DAO<Pedido> {
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    /**
     * Insere um novo pedido no banco de dados
     * @param pedido a ser inserido no banco de dados
     */
    @Override
    public void inserir(Pedido pedido) {
        int maiorCodigo = 0;
        for(int i = 0; i < PedidoDAO.pedidos.size(); i++){
            int codigoAtual = PedidoDAO.pedidos.get(i).getCod();
            if(codigoAtual > maiorCodigo){
                maiorCodigo = codigoAtual;
            }
        }
        pedido.setCod(maiorCodigo + 1);
        PedidoDAO.pedidos.add(pedido);
    }

    /**
     * Deleta um pedido do banco de dados 
     * @param codigo do pedido que vai ser deletado do banco de dados
     */
    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < PedidoDAO.pedidos.size(); i++){
            if(codigo == PedidoDAO.pedidos.get(i).getCod()){
                PedidoDAO.pedidos.remove(i);
            }
        }
    }

    /**
     * Busca o pedido pelo seu código, caso encontre, o mesmo é editado, caso contrário, nada acontece
     * @param pedido a ser editado no banco de dados
     */
    @Override
    public void editar(Pedido pedido) {
        for(int i = 0; i < PedidoDAO.pedidos.size(); i++) {
            Pedido pedidoAtual = PedidoDAO.pedidos.get(i);
            if(pedidoAtual.getCod() == pedido.getCod()) {
                PedidoDAO.pedidos.set(i, pedido);
                return;
            }
        }
    }

    /**
     * Retorna todos os pedidos do banco de dados
     * @return ArrayList<Pedido>
     */
    @Override
    public ArrayList<Pedido> getAll() {
        return PedidoDAO.pedidos;
    }

    /**
     * Procura um pedido no banco de dados, caso não ache o pedido, retorna null 
     * @param codigo do pedido a ser buscado no do banco de dados
     * @return Pedido
     */
    @Override
    public Pedido getByCod(int codigo) {
        for(int i = 0; i < PedidoDAO.pedidos.size(); i++){
            Pedido pedidoAtual = PedidoDAO.pedidos.get(i);
            if(codigo == pedidoAtual.getCod())
                return pedidoAtual;
        }  

        return null;
    }

    /**
     * Procura um pedido no banco de dados pelo código do cliente, caso não ache nenhum pedido, retorna um ArrayList vazio 
     * @param codigo do cliente que fez o(s) pedido(s)
     * @return ArrayList<Pedido>
     */
    public ArrayList<Pedido> getByClienteCod(int codigo) {
        ArrayList<Pedido> pedidosEncontrados = new ArrayList<Pedido>();

        for(int i = 0; i < PedidoDAO.pedidos.size(); i++){
            Pedido pedidoAtual = PedidoDAO.pedidos.get(i);
            if(codigo == pedidoAtual.getClienteCod())
                pedidosEncontrados.add(pedidoAtual);
        }  

        return pedidosEncontrados;
    }
    
}
