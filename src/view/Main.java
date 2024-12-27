package view;

import model.CadastroFuncionarios.CadastroFuncionarioAssalariado;
import model.CadastroFuncionarios.CadastroFuncionarioHorista;
import model.CadastroFuncionarios.CadastroFuncionarioComissionado;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // configurando o scanner para usar o locale BR
        // objetivo aceitar a formatação do salario do usuario
        Scanner scanner = new Scanner(System.in).useLocale(Locale.forLanguageTag("pt_br"));

        // criando uma instancia de CadastroFuncionarioAssalariado
        CadastroFuncionarioAssalariado cadastroAssalariado = new CadastroFuncionarioAssalariado();
        // Criando uma instância de CadastroFuncionarioHorista
        CadastroFuncionarioHorista cadastroHorista = new CadastroFuncionarioHorista();
        // Criando uma instância de FuncionarioComissionado
        CadastroFuncionarioComissionado cadastroComissionado = new CadastroFuncionarioComissionado();

        // leitura quantidade de funcionarios
        System.out.println("Digite quantos funcionarios sua empresa vai ter: ");
        int quantidadeFuncionarios = scanner.nextInt();

        // Consome o restante da linha em branco após nextInt()
        scanner.nextLine();
        for (int i = 0; i < quantidadeFuncionarios; i++) {
            System.out.println("Escolha o tipo de funcionário\n[1] - Assalariado\n[2] - Horista\n[3] - Comissionado");
            int tipoFuncionario = scanner.nextInt();
            scanner.nextLine(); // Consome a linha em branco

            // Opção 1 funcionarioAssalariado
            if (tipoFuncionario == 1) {
                cadastroAssalariado.cadastrarFuncionarioAssalariado(scanner);
            }
            // Opção 2 funcionarioHorista
            if (tipoFuncionario == 2) {
                cadastroComissionado.cadastrarFuncionarioComissionado(scanner);
            }
            if (tipoFuncionario == 3) {
                cadastroHorista.cadastrarFuncionarioHorista(scanner);
            }

            break;
        }

        // System.out.println("Escolha uma opção\n[1] - Exibir todos funcionarios\n[2] -
        // Exibir funcionarios por tipo de funcionario");
        // int opcaoExibir = scanner.nextInt();

        // Imprimindo lista de funcionario Assalariado
        // cadastroAssalariado é uma instancia de CadastroFuncionarioAssalariado
        cadastroAssalariado.exibirFuncionarios(); // Chama o método da instância

        System.out.println();

        // imprimindo funcionarios Horistas
        cadastroComissionado.exibir_funcionario();

        System.out.println();

        cadastroHorista.exibir_funcionario();

    }

}
