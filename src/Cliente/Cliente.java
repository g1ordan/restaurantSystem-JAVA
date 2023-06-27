public class Cliente extends PessoaFisica {

    public Cliente(String nome, String telefone, String endereco,String cpf, char sexo) throws ApplicationError {
        super(nome, telefone, endereco, cpf, sexo);
    }

    public Cliente() {
        super();
    }

    @Override
    public String toString() {
        PedidoDAO pedidoDAO = new PedidoDAO();

        return  "Código: " + this.cod +
            "\nCpf: " + this.cpf +
            "\nNome: " + this.nome +
            "\nTelefone: " + this.telefone +
            "\nEndereço: " + this.endereco +
            "\nSexo: " + this.sexo +
            "\nPedidos: " + pedidoDAO.getByClienteCod(this.cod).size()
         ;
    } 
}
