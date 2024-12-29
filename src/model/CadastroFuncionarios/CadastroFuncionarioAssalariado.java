package model.CadastroFuncionarios;

import model.FuncionarioAssalariado;
import java.util.Scanner;
import java.util.ArrayList;

public class CadastroFuncionarioAssalariado {

    // Lista de funcionários assalariados
    private ArrayList<FuncionarioAssalariado> funcionariosAssalariadosList = new ArrayList<>();

    // Método para cadastrar um funcionário assalariado
    public void cadastrarFuncionarioAssalariado(Scanner scanner) {
        // Coletando os dados do funcionário
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        System.out.println("Digite o salário base do funcionário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Consumindo a linha em branco

        // Criando um novo funcionário assalariado
        FuncionarioAssalariado novoFuncionarioAssalariado = new FuncionarioAssalariado(nome, cpf, cargo, salario);

        // Adicionando o novo funcionário à lista
        funcionariosAssalariadosList.add(novoFuncionarioAssalariado);

        System.out.println("Funcionário Assalariado adicionado com sucesso.");
    }

    // imprimindo funcionarios Horistas
    // funcionarioHoristaAdd Variavel temporaria só para pegar o funcionario e
    // armazenar em funcionarioHoristaList
    // Método para exibir os funcionários cadastrados
    public void exibir_Funcionarios() {
        for (FuncionarioAssalariado funcionario : funcionariosAssalariadosList) {
            System.out.println(funcionario);
        }
    }

    public FuncionarioAssalariado procurarPorCpf(String cpf) {
        for(FuncionarioAssalariado funcionario : funcionariosAssalariadosList){
            if(funcionario.getCPF().equals(cpf)){
                return funcionario;
            }
        }

        return null;//null se não encontrar funcionario com esse cpf
    }
}
