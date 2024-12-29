package view;

import model.FuncionarioAssalariado;
import model.FuncionarioComissionado;
import model.FuncionarioHorista;
import model.CadastroFuncionarios.CadastroFuncionarioAssalariado;
import model.CadastroFuncionarios.CadastroFuncionarioHorista;
import model.CadastroFuncionarios.CadastroFuncionarioComissionado;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // configurando o scanner para usar o locale BR
        Scanner scanner = new Scanner(System.in).useLocale(Locale.forLanguageTag("pt_br"));

        // criando instâncias dos tipos de cadastro de funcionários
        CadastroFuncionarioAssalariado cadastroAssalariado = new CadastroFuncionarioAssalariado();
        CadastroFuncionarioHorista cadastroHorista = new CadastroFuncionarioHorista();
        CadastroFuncionarioComissionado cadastroComissionado = new CadastroFuncionarioComissionado();

        System.out.println("--- RH JG ---\n");

        // Variáveis de controle
        int quantidadeFuncionarios = 0;
        int opcao = 0;

        // Menu principal e loop de controle
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("[1] - Definir quantidade de funcionários e Cadastrar");
            System.out.println("[2] - Exibir Funcionários por tipo");
            System.out.println("[3] - Exibir Todos os funcionários");
            System.out.println("[4] - Procurar funcionario por cpf");
            System.out.println("[0] - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a linha em branco

            switch (opcao) {
                case 1:
                    // Definindo quantidade de funcionários e cadastrando
                    System.out.println("Digite quantos funcionários sua empresa vai ter: ");
                    quantidadeFuncionarios = scanner.nextInt();
                    scanner.nextLine(); // Consumir a linha em branco após nextInt()

                    // Loop para cadastro de funcionários
                    for (int i = 0; i < quantidadeFuncionarios; i++) {
                        System.out.println("Escolha o tipo de funcionário:");
                        System.out.println("[1] - Assalariado");
                        System.out.println("[2] - Horista");
                        System.out.println("[3] - Comissionado");
                        System.out.println("[0] - Cancelar cadastro");

                        int tipoFuncionario = scanner.nextInt();
                        scanner.nextLine(); // Consumir a linha em branco após nextInt()

                        // Cadastro de funcionário com base no tipo
                        switch (tipoFuncionario) {
                            case 1:
                                cadastroAssalariado.cadastrarFuncionarioAssalariado(scanner);
                                break;
                            case 2:
                                cadastroHorista.cadastrarFuncionarioHorista(scanner);
                                break;
                            case 3:
                                cadastroComissionado.cadastrarFuncionarioComissionado(scanner);
                                break;
                            case 0:
                                System.out.println("Cadastro cancelado.");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                                i--; // Decrementa o contador para permitir nova tentativa de cadastro
                                break;
                        }
                    }
                    break;

                case 2:
                    // Exibir funcionários por tipo
                    System.out.println("[1] - Assalariado");
                    System.out.println("[2] - Horista");
                    System.out.println("[3] - Comissionado");

                    int tipoFuncionario = scanner.nextInt();
                    scanner.nextLine(); // Consumir a linha em branco após nextInt()

                    switch (tipoFuncionario) {
                        case 1:
                            System.out.println("\nExibindo funcionários Assalariados:");
                            cadastroAssalariado.exibir_Funcionarios();
                            break;
                        case 2:
                            System.out.println("\nExibindo funcionários Horistas:");
                            cadastroHorista.exibir_funcionario();
                            break;
                        case 3:
                            System.out.println("\nExibindo funcionários Comissionados:");
                            cadastroComissionado.exibir_funcionario();
                            break;
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                            break;
                    }
                    break;

                case 3:
                    // Exibir todos os funcionários
                    System.out.println("\nExibindo todos os funcionários:");
                    cadastroAssalariado.exibir_Funcionarios();
                    cadastroHorista.exibir_funcionario();
                    cadastroComissionado.exibir_funcionario();
                    break;
                case 4:
                    System.out.println("Digite o cpf do funcionario: ");
                    String buscaCpf = scanner.nextLine();

                    // buscar funcionario nas tres listas
                    FuncionarioHorista funcionarioHorista = cadastroHorista.procurarPorCpf(buscaCpf);
                    if (funcionarioHorista != null) {
                        System.out.println("Funcionario encontrado: " + funcionarioHorista);
                        System.out.println();
                        break;
                    }

                    FuncionarioComissionado funcionarioComissionado = cadastroComissionado.procurarPorCpf(buscaCpf);
                    if (funcionarioComissionado != null) {
                        System.out.println("Funcionario encontrado: " + funcionarioComissionado);
                        System.out.println();
                        break;
                    }

                    FuncionarioAssalariado funcionarioAssalariado = cadastroAssalariado.procurarPorCpf(buscaCpf);
                    if (funcionarioAssalariado != null) {
                        System.out.println("Funcionario encontrado: " + funcionarioAssalariado);
                        System.out.println();
                        break;
                    }

                    System.out.println("Funcionario com o cpf: " + buscaCpf + " não encontrado");
                    break;

                case 0:
                    // Sair do programa
                    System.out.println("Saindo do sistema...");
                    return; // Encerra o programa

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
