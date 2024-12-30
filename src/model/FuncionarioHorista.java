package model;

//utilizando herança e puxando os metodos da classe Funcionario Model/Funcionarios.java
public class FuncionarioHorista extends Funcionarios {
    private int horasTrabalhadas;
    private double salarioHora;
    private int diasTrabalhados;

    public FuncionarioHorista(String nome, String cpf, String cargo, int horasTrabalhadas, int diasTrabalhados,
            double salarioHora) {
        // poderia usar um valor "Placeholder" == 0, pra ignorar o salario tambem
        //super(nome, cpf, cargo, 0);
        // puxando o construtor sobrescrito com apenas (nome, cpf e cargo)
        super(nome, cpf, cargo);
        this.diasTrabalhados = diasTrabalhados;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
    }
    // get retorna
    // set modifca

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    // Sobrescrever o toString de funcionarios para mostrar horas trabalhadas;
    @Override
    public String toString() {
        // Exibe apenas as informações básicas, sem o salário fixo
        return super.toString() + "\nHoras trabalhadas: " + horasTrabalhadas + "\nSalário por hora: R$ " + salarioHora +  "\nDias trabalhados: " + diasTrabalhados + "\nSalario Total: R$" + calcularSalario();
    }

    // Método para calcular o salário total (sem o parâmetro salário fixo)
    @Override
    public double calcularSalario() {
        // Calcula o salário com base nas horas, dias e salário por hora
        return horasTrabalhadas * salarioHora * diasTrabalhados;
    }

    
}
