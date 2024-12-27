package model.CadastroFuncionarios;

import model.FuncionarioComissionado;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroFuncionarioComissionado {
    private ArrayList<FuncionarioComissionado> funcionarioComissionadoList = new ArrayList<>();

    public void cadastrarFuncionarioComissionado(Scanner scanner) {
        // Coletando os dados do funcionário
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o cpf do funcionário: ");
        String cpf = scanner.nextLine();

        System.out.println("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        System.out.println("Digite o salario do funcionário: ");
        double salariobase = scanner.nextDouble();

        FuncionarioComissionado novFuncionarioComissionado = new FuncionarioComissionado(nome, cpf, cargo, salariobase);

        // adiciona novo funcionario a lista
        funcionarioComissionadoList.add(novFuncionarioComissionado);

        System.out.println("Funcionário Comissionado adicionado com sucesso.");

    }

    // exibir dados do funcionario
    public void exibir_funcionario() {
        for (FuncionarioComissionado funcComissionado : funcionarioComissionadoList) {
            System.out.println(funcComissionado);

        }
    }
}
