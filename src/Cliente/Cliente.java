public class Cliente extends PessoaFisica {
    public Cliente(String nome, String telefone, String endereco,String cpf, char sexo) {
        super(nome, telefone, endereco, cpf, sexo);
    }

    @Override
    public String toString() {
        return "Cpf: " + this.cpf +
            "\nNome: " + this.nome +
            "\nTelefone: " + this.telefone +
            "\nEndereço: R$" + this.endereco +
            "\nSexo: R$" + this.sexo
         ;
    } 
}
