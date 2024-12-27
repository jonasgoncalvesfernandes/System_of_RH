package model;

public class FuncionarioAssalariado extends Funcionarios {

    // Construtor da classe FuncionarioAssalariado
    public FuncionarioAssalariado(String nome, String cpf, String cargo, double salario) {
        super(nome, cpf, cargo, salario);  // Chama o construtor da classe base (Funcionario)
    }

    // Sobrescrito (toString) para mostrar informações adicionais
    @Override
    //reutilização de codigo, sem precisar criar outro metodo e evitando duplicação de codigo
    public String toString() {
        return super.toString() + "\nSalário: R$ " + getSalario();
    }
}
