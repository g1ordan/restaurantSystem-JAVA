import java.util.ArrayList;

public class ClienteDAO implements DAO<Cliente> {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * @param cliente a ser inserido no banco de dados
     */
    @Override
    public void inserir(Cliente cliente){
        int maiorCodigo = 1;
        for(int i = 0; i < ClienteDAO.clientes.size(); i++){
            int codigoAtual = ClienteDAO.clientes.get(i).getCod();
            if(codigoAtual > maiorCodigo){
                maiorCodigo = codigoAtual;
            }
        }
        cliente.setCod(maiorCodigo + 1);
        ClienteDAO.clientes.add(cliente);
    }

    /**
     * @param cliente a ser atualizado no banco de dados
     */
    @Override
    public void editar(Cliente cliente){
        for(int i = 0; i < ClienteDAO.clientes.size(); i++) {
            Cliente clienteAtual = ClienteDAO.clientes.get(i);
            if(clienteAtual.getCod() == cliente.getCod()) {
                ClienteDAO.clientes.set(i, cliente);
                return;
            }
        }
    }

    @Override
    public Cliente getByCod(int codigo) {
        for(int i = 0; i < ClienteDAO.clientes.size(); i++) {
            Cliente clienteAtual = ClienteDAO.clientes.get(i);
            if(clienteAtual.getCod() == codigo) {
                return clienteAtual;
            }
        }

        throw new Error("Cliente não encontrado");
    }

    public ArrayList<Cliente> getAll() {
        return ClienteDAO.clientes;
    }

    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < ClienteDAO.clientes.size(); i++){
            if(codigo == ClienteDAO.clientes.get(i).getCod()){
                ClienteDAO.clientes.remove(i);
            }
        }
    }
}