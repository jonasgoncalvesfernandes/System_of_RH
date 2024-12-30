package model.CadastroFuncionarios;

import model.FuncionarioHorista;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroFuncionarioHorista {
    ArrayList<FuncionarioHorista> funcionarioHoristaList = new ArrayList<>();

    // Método para cadastrar um funcionário horista //chamando o metodo scanner de
    // main.java
    public void cadastrarFuncionarioHorista(Scanner scanner) {
        // Coletando os dados do funcionário Extends.Funcionario
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        // Coletando os dados específicos de FuncionarioHorista
        System.out.println("Digite as horas trabalhadas: ");
        int horasTrabalhadas = scanner.nextInt();

        System.out.println("Digite os dias trabalhados: ");
        int diasTrabalhados = scanner.nextInt();

        System.out.println("Digite o salário por hora: ");
        double salarioHora = scanner.nextDouble();

        // Criando e retornando um novo funcionário assalariado
        FuncionarioHorista novFuncionarioHorista = new FuncionarioHorista(nome, cpf, cargo, horasTrabalhadas,
                diasTrabalhados, salarioHora);

        // adicionando funcionario a lista
        funcionarioHoristaList.add(novFuncionarioHorista);

        System.out.println("Funcionário Horista adicionado com sucesso.");

    }

    // função para exibir todos os funcionarios
    public void exibir_funcionario() {
        for (FuncionarioHorista funcHorista : funcionarioHoristaList) {
            System.out.println(funcHorista);
        }
    }

    // criando um metodo pra procurar por cpf do tipo FuncionarioHorista
    public FuncionarioHorista procurarPorCpf(String cpf) {
        // percorrendo a lista para comparar os cpf se é igual o digitado
        for (FuncionarioHorista funcHorista : funcionarioHoristaList) {
            if (funcHorista.getCPF().equals(cpf)) {
                return funcHorista;
            }
        }

        return null; // retorna null se não encontrar nenhum funcionario com cpf
    }

    // Método para remover um funcionário
    public boolean remover(FuncionarioHorista funcionario) {
        return funcionarioHoristaList.remove(funcionario); // Retorna true se o funcionário foi removido
    }

}
