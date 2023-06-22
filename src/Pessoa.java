public class Pessoa {
    protected int cod;
    protected String nome;
    protected String telefone;
    protected String endereco;

    public Pessoa(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

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
        if(nome != "#")
            this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone != "#")
            this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco != "#")
            this.endereco = endereco;
    }
    
}

