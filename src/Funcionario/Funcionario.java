public class Funcionario extends PessoaFisica {
    private double salario;
    private String funcao;
    private String dataNasci;
    private String admissao;
    private String rescisao;

    public Funcionario(String nome, String telefone, String endereco, String cpf, char sexo, double salario, String funcao, String dataNasci, String admissao) throws ApplicationError {
        super(nome, telefone, endereco, cpf, sexo);

        if(!dataNasci.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")) {
            throw new ApplicationError("Data de nascimento inválida");
        }

        if(!admissao.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")) {
            throw new ApplicationError("Data de admissão inválida");
        }
        
        this.salario = salario;
        this.funcao = funcao;
        this.dataNasci = dataNasci;
        this.admissao = admissao;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDataNasci() {
        return this.dataNasci;
    }
    // 

    public void setDataNasci(String dataNasci) {
        this.dataNasci = dataNasci;
    }

    public String getAdmissao() {
        return this.admissao;
    }

    public void setAdmissao(String admissao) {
        this.admissao = admissao;
    }

    public String getRescisao() {
        return this.rescisao;
    }

    public void setRescisao(String rescisao) {
        this.rescisao = rescisao;
    }
}