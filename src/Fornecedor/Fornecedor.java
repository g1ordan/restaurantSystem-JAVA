public class Fornecedor extends PessoaJuridica{
    // Pode ser um ENUM
    private String nicho;

    public Fornecedor(String nome, String telefone, String endereco, String cnpj, String razaoSocial, String nicho) {
        super(nome, telefone, endereco, cnpj, razaoSocial);
        this.nicho = nicho;
    }

    public String getNicho() {
        return this.nicho;
    }

    public void setNicho(String nicho) {
        this.nicho = nicho;
    }
}
