package model.CadastroFuncionarios;

import model.FuncionarioAssalariado;
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

        System.out.println("Digite a quantidade de vendas esse mês: ");
        double vendas = scanner.nextDouble();

        FuncionarioComissionado novFuncionarioComissionado = new FuncionarioComissionado(nome, cpf, cargo, salariobase,
                vendas);

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

    // Metodo para procurar por cpf funcionarioComissionado
    public FuncionarioComissionado procurarPorCpf(String cpf) {
        for (FuncionarioComissionado funComissionado : funcionarioComissionadoList) {
            if (funComissionado.getCPF().equals(cpf)) {
                return funComissionado;
            }
        }
        return null; // retorna null se não encontrar nenhum funcionario com cpf

    }

        // Método para remover um funcionário
    public boolean remover(FuncionarioComissionado funcionario) {
        return funcionarioComissionadoList.remove(funcionario); // Retorna true se o funcionário foi removido
    }
}
