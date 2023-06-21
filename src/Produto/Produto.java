import java.util.ArrayList;

public class Produto {
    private int cod;
    private String nome;
    private Categoria categoria;
    private double valor;
    private ArrayList<Integer> ingredientesId = new ArrayList<Integer>();


    public Produto(String nome, Categoria categoria, double valor, ArrayList<Integer> ingredientesId) {
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
        this.ingredientesId = ingredientesId;
    }

    public Produto() {}

    public int getcod() {
        return this.cod;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(nome != "#")
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Integer> getIngredientesId() {
        return this.ingredientesId;
    }

    public void setIngredientesId(ArrayList<Integer> ingrediente){
            this.ingredientesId = ingrediente;
    }
    
    public void setCod(int codigo){
        this.cod = codigo;
    }

    @Override
    public String toString() {
        return "Código: " + this.cod +
            "\nNome: " + this.nome +
            "\nCategoria: " + this.categoria.getValor() +
            "\nValor: R$" + this.valor
         ;
    } 

    // public void vender(int qtd){
    //     if(qtd < this.estoque) {
    //         estoque -= qtd;
    //     } else {
    //         // throw Error
    //     }
    // }
    
    // public void addEstoque(int qtd){
    //     estoque += qtd;
    // }
}
