public enum Categoria {
    Lanches("Lanches"), Porções("Porções"), BatataEmTorre("Batata em Torre"), Pasteis("Pasteis");

    private final String valor;
    Categoria(String valor) {
        this.valor = valor;
    }

    public String getValor(){
		return valor;
	}
}