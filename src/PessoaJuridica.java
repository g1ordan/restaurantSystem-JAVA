public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String razaoSocial;


    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj, String razaoSocial) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }
    
    public String getCnpj() {
        return this.cnpj;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

}
