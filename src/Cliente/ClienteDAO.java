import java.util.ArrayList;

public class ClienteDAO implements DAO<Cliente> {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    /**
     * Insere um novo cliente no banco de dados
     * @param cliente a ser inserido no banco de dados
     */
    @Override
    public void inserir(Cliente cliente){
        int maiorCodigo = 0;
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
     * Busca o cliente pelo seu código, caso encontre, o mesmo é editado, caso contrário, nada acontece
     * @param cliente a ser editado no banco de dados
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

    /**
     * Procura um cliente no banco de dados, caso não ache o cliente, retorna null 
     * @param codigo do cliente a ser buscado no banco de dados
     * @return Cliente
     */
    @Override
    public Cliente getByCod(int codigo) {
        for(int i = 0; i < ClienteDAO.clientes.size(); i++) {
            Cliente clienteAtual = ClienteDAO.clientes.get(i);
            if(clienteAtual.getCod() == codigo) {
                return clienteAtual;
            }
        }

        return null;
    }

    /**
     * Retorna todos os clientes do banco de dados
     * @return ArrayList<Cliente>
     */
    public ArrayList<Cliente> getAll() {
        return ClienteDAO.clientes;
    }

    /**
     * Deleta um cliente do banco de dados 
     * @param codigo do cliente que vai ser deletado do banco de dados
     */
    @Override
    public void deletar(int codigo) {
        for (int i = 0; i < ClienteDAO.clientes.size(); i++){
            if(codigo == ClienteDAO.clientes.get(i).getCod()){
                ClienteDAO.clientes.remove(i);
            }
        }
    }
}