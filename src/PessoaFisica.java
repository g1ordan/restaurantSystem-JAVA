public class PessoaFisica extends Pessoa {
    protected String cpf;
    protected char sexo;
    
    public PessoaFisica(String nome, String telefone, String endereco,String cpf, char sexo) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}