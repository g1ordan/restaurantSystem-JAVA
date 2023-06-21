import java.util.ArrayList;

public class ClienteDAO {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * @param cliente a ser inserido no banco de dados
     */
    public void inserir(Cliente cliente){
        ClienteDAO.clientes.add(cliente);
    }

    /**
     * @param cliente a ser atualizado no banco de dados
     */
    public void atualizar(Cliente cliente){
        for(int i = 0; i < ClienteDAO.clientes.size(); i++) {
            Cliente clienteAtual = ClienteDAO.clientes.get(i);
            if(clienteAtual.getCpf() == cliente.getCpf()) {
                ClienteDAO.clientes.set(i, cliente);
                return;
            }
        }
    }

    public Cliente getByCpf(String cpf) {
        for(int i = 0; i < ClienteDAO.clientes.size(); i++) {
            Cliente clienteAtual = ClienteDAO.clientes.get(i);
            if(clienteAtual.getCpf() == cpf) {
                return clienteAtual;
            }
        }

        throw new Error("Cliente não encontrado");
    }

    public ArrayList<Cliente> getAll() {
        return ClienteDAO.clientes;
    }
}