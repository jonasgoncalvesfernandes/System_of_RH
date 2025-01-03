package model.CadastroFuncionarios;

import model.FuncionarioComissionado;
import model.utils.VerificadorDuplicidadeCPF;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroFuncionarioComissionado {
    public ArrayList<FuncionarioComissionado> funcionarioComissionadoList = new ArrayList<>();

    // Passando as instâncias dos objetos de cadastro para verificar a duplicidade
    // de CPF
    public void cadastrarFuncionarioComissionado(Scanner scanner, CadastroFuncionarioComissionado cadastroComissionado,
            CadastroFuncionarioAssalariado cadastroAssalariado, CadastroFuncionarioHorista cadastroHorista) {
        // Coletando os dados do funcionário
        System.out.println("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o cpf do funcionário: ");
        String cpf = scanner.nextLine();

        // Verifica se o CPF ja existe
        if (VerificadorDuplicidadeCPF.verificarDuplicidadeCPF(cpf, cadastroHorista, cadastroAssalariado,
                cadastroComissionado)) {
            System.out.println("Erro: O CPF informado já está cadastrado em outro tipo de funcionário.");
            return; // Não continua se CPF for duplicado
        }

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

    // Verifica se a lista de funcionários comissionados está vazia antes de exibir
    // os dados.
    public void exibir_funcionario() {
        if (funcionarioComissionadoList == null || funcionarioComissionadoList.isEmpty()) {
            // Se a lista estiver vazia, exibe uma mensagem informando.
            System.out.println("Nenhum funcionário comissionado na lista.\n");
            return; // Se estiver vazia, o método termina aqui e não continua com o loop
        }

        // Caso contrário, itera sobre a lista e exibe os dados de cada funcionário
        for (FuncionarioComissionado funcComissionado : funcionarioComissionadoList) {
            System.out.println(funcComissionado); // Exibe os dados do funcionário (chama o método toString())
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
