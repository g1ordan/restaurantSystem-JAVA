public class Ingrediente {
    private int cod;
    private String nome;
    private int estoque;

    public Ingrediente(String nome, int estoque) {
        this.nome = nome;
        this.estoque = estoque;
    }

    public Ingrediente() {}

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

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Código: " + this.cod +
            "\nNome: " + this.nome +
            "\nEstoque: " + this.estoque
         ;
    } 
}
