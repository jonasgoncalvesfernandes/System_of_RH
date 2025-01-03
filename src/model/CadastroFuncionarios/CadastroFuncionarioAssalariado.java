package model.CadastroFuncionarios;

import model.FuncionarioAssalariado;
import model.utils.VerificadorDuplicidadeCPF;

import java.util.Scanner;
import java.util.ArrayList;

public class CadastroFuncionarioAssalariado {

    // Lista de funcionários assalariados
    private ArrayList<FuncionarioAssalariado> funcionariosAssalariadosList = new ArrayList<>();

    // Método para cadastrar um funcionário assalariado
    public void cadastrarFuncionarioAssalariado(Scanner scanner, CadastroFuncionarioComissionado cadastroComissionado,
            CadastroFuncionarioAssalariado cadastroAssalariado, CadastroFuncionarioHorista cadastroHorista) {
        // Coletando os dados do funcionário
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do funcionário: ");
        String cpf = scanner.nextLine();

        //Verifica se o CPF ja existe
        if (VerificadorDuplicidadeCPF.verificarDuplicidadeCPF(cpf, cadastroHorista, cadastroAssalariado,
                cadastroComissionado)) {
            System.out.println("Erro: O CPF informado já está cadastrado em outro tipo de funcionário.");
            return; // Não continua se CPF for duplicado
        }

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
        if (funcionariosAssalariadosList == null || funcionariosAssalariadosList.isEmpty()) {
            // Se a lista estiver vazia, exibe uma mensagem informando.
            System.out.println("Nenhum funcionário assalariado na lista.\n");
            return; // Se estiver vazia, o método termina aqui e não continua com o loop
        }

        // Caso contrário, itera sobre a lista e exibe os dados de cada funcionário
        for (FuncionarioAssalariado funcionario : funcionariosAssalariadosList) {
            System.out.println(funcionario); // Exibe os dados do funcionário (chama o método toString())
            System.err.println();
        }
    }

    public FuncionarioAssalariado procurarPorCpf(String cpf) {
        for (FuncionarioAssalariado funcionario : funcionariosAssalariadosList) {
            if (funcionario.getCPF().equals(cpf)) {
                return funcionario;
            }
        }

        return null;// null se não encontrar funcionario com esse cpf
    }

    // Método para remover um funcionário
    public boolean remover(FuncionarioAssalariado funcionario) {
        return funcionariosAssalariadosList.remove(funcionario); // Retorna true se o funcionário foi removido
    }
}
