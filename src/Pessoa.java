public class Pessoa {
    protected int cod;
    protected String nome;
    protected String telefone;
    protected String endereco;
    private final String telefoneRegex =  "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";

    public Pessoa(String nome, String telefone, String endereco) throws ApplicationError {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Pessoa() {}

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) throws ApplicationError {
        if(!telefone.matches(this.telefoneRegex)) {
            throw new ApplicationError("Número de telefone inválido");
        }
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}

