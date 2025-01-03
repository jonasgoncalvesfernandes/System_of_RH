package model.CadastroFuncionarios;

import model.FuncionarioHorista;
import model.utils.VerificadorDuplicidadeCPF;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroFuncionarioHorista {
    public ArrayList<FuncionarioHorista> funcionarioHoristaList = new ArrayList<>();

    // Método para cadastrar um funcionário horista
    // Chamando o metodo scanner de Main.java
    public void cadastrarFuncionarioHorista(Scanner scanner, CadastroFuncionarioComissionado cadastroComissionado,
            CadastroFuncionarioAssalariado cadastroAssalariado, CadastroFuncionarioHorista cadastroHorista) {
        // Coletando os dados do funcionário Extends.Funcionario
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();

        // Verifica se o CPF ja existe
        if (VerificadorDuplicidadeCPF.verificarDuplicidadeCPF(cpf, cadastroHorista, cadastroAssalariado,
                cadastroComissionado)) {
            System.out.println("Erro: O CPF informado já está cadastrado em outro tipo de funcionário.");
            return; // Não continua se CPF for duplicado
        }

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
        // isEmpty verifica se a lista está vazia, retornando true se não houver
        // elementos, e false caso contrário.
        if (funcionarioHoristaList == null || funcionarioHoristaList.isEmpty()) {
            System.out.println("Nenhum funcionário Horista na lista.\n");
            return; // Se a lista estiver vazia, o método retorna aqui
        }

        // Se a lista não estiver vazia, exibe todos os funcionários
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
