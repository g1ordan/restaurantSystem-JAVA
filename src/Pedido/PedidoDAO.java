import java.util.ArrayList;

public class PedidoDAO implements DAO<Pedido> {
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();


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

    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < PedidoDAO.pedidos.size(); i++){
            if(codigo == PedidoDAO.pedidos.get(i).getCod()){
                PedidoDAO.pedidos.remove(i);
            }
        }
    }

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

    @Override
    public ArrayList<Pedido> getAll() {
        return PedidoDAO.pedidos;
    }

    @Override
    public Pedido getByCod(int codigo) {
        for(int i = 0; i < PedidoDAO.pedidos.size(); i++){
            Pedido pedidoAtual = PedidoDAO.pedidos.get(i);
            if(codigo == pedidoAtual.getCod())
                return pedidoAtual;
        }  

        return null;
    }

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
