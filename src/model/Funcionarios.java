package model;

//iniciando a classe com os metodos
public class Funcionarios {
    private String nome;
    private String cpf;
    private String cargo;
    private double salario;

    // metodo construtor da classe
    // Construtor com 4 parâmetros (usado para funcionários assalariados)
    public Funcionarios(String nome, String cpf, String cargo, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
    }

    //Nesse caso só foi possivel com Sobrescrita do construtor Funcionarios
    // Construtor com 3 parâmetros (usado para funcionários sem salário fixo, como FuncionarioHorista)
    // Sobrescrevendo construtor para classe FuncionarioHorista, já que o salario do mesmo vai ser calculado de forma independente
    public Funcionarios(String nome, String cpf, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    // get Retorna;
    // set modifica;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // metodo alteração e retorno Salario
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // metodo alteração e retorno CPF
    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    // metodo alteração e retorno Cargo
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //metodo pra calcular salario
    public double calcularSalario() {
        return salario;
    }
    

    //Sobrescrito (ToString)
    @Override
    public String toString() {
        return "Nome: " + nome + "\nCargo: " + cargo + "\nCPF: " + cpf;
    }
}