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
    // Static para indicar que as constantes são associadas à classe e podem ser
    // acessadas sem instanciar a classe
    // Acessibilidade sem instânciar a classe
    // Final = valor não pode ser alterado após ser atribuido
    public static final int OPCAO_CADASTRAR_FUNCIONARIO = 1;
    public static final int OPCAO_EXIBIR_FUNCIONARIOS_POR_TIPO = 2;
    public static final int OPCAO_EXIBIR_TODOS_OS_FUNCIONARIOS = 3;
    public static final int OPCAO_PROCURAR_FUNCIONARIO_POR_CPF = 4;
    public static final int OPCAO_REMOVER_FUNCIONARIO = 5;
    public static final int OPCAO_SAIR = 0;

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
            System.out.println("[5] - Remover funcionario");
            System.out.println("[0] - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a linha em branco

            switch (opcao) {
                // Cadastrar funcionarios
                case OPCAO_CADASTRAR_FUNCIONARIO:
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
                                cadastroAssalariado.cadastrarFuncionarioAssalariado(scanner, cadastroComissionado, cadastroAssalariado, cadastroHorista);
                                break;
                            case 2:
                                cadastroHorista.cadastrarFuncionarioHorista(scanner, cadastroComissionado, cadastroAssalariado, cadastroHorista);
                                break;
                            case 3:
                                cadastroComissionado.cadastrarFuncionarioComissionado(scanner, cadastroComissionado, cadastroAssalariado, cadastroHorista);
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

                // Exibir funcionarios por tipo
                case OPCAO_EXIBIR_FUNCIONARIOS_POR_TIPO:
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

                // Exibir todos os funcionarios
                case OPCAO_EXIBIR_TODOS_OS_FUNCIONARIOS:
                        System.out.println("\nExibindo todos os funcionários:");
                        cadastroAssalariado.exibir_Funcionarios();
                        cadastroHorista.exibir_funcionario();
                        cadastroComissionado.exibir_funcionario();
                        break;
                    
                    // Procurar funcionario por cpf
                case OPCAO_PROCURAR_FUNCIONARIO_POR_CPF:
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

                // Remoevr funcionario
                case OPCAO_REMOVER_FUNCIONARIO:
                    System.out.println("Digite o CPF do funcionário que deseja remover: ");
                    String cpfBusca = scanner.nextLine();

                    // Procurar o funcionário nas listas
                    FuncionarioHorista funcionarioHoristaa = cadastroHorista.procurarPorCpf(cpfBusca);
                    FuncionarioComissionado funcionarioComissionadoo = cadastroComissionado.procurarPorCpf(cpfBusca);
                    FuncionarioAssalariado funcionarioAssalariadoo = cadastroAssalariado.procurarPorCpf(cpfBusca);

                    // Verificar se algum funcionário foi encontrado
                    if (funcionarioHoristaa != null || funcionarioComissionadoo != null
                            || funcionarioAssalariadoo != null) {
                        // Exibe os dados do funcionário encontrado
                        if (funcionarioHoristaa != null) {
                            System.out.println("Funcionário encontrado\n" + funcionarioHoristaa);
                        } else if (funcionarioComissionadoo != null) {
                            System.out.println("Funcionário encontrado\n" + funcionarioComissionadoo);
                        } else if (funcionarioAssalariadoo != null) {
                            System.out.println("Funcionário encontrado\n " + funcionarioAssalariadoo);
                        }

                        // Solicitar confirmação para remoção
                        System.out.println("Deseja remover este funcionário? (sim/nao)");
                        String resposta = scanner.nextLine().toLowerCase();

                        if (resposta.equals("sim")) {
                            // Realizar a remoção do funcionário
                            if (funcionarioHoristaa != null) {
                                cadastroHorista.remover(funcionarioHoristaa);
                                System.out.println("Funcionário horista removido com sucesso.");
                            } else if (funcionarioComissionadoo != null) {
                                cadastroComissionado.remover(funcionarioComissionadoo);
                                System.out.println("Funcionário comissionado removido com sucesso.");
                            } else if (funcionarioAssalariadoo != null) {
                                cadastroAssalariado.remover(funcionarioAssalariadoo);
                                System.out.println("Funcionário assalariado removido com sucesso.");
                            }
                        } else {
                            System.out.println("Remoção cancelada.");
                        }
                    } else {
                        System.out.println("Funcionário não encontrado.");

                    }
                    break;

                // Sair
                case OPCAO_SAIR:
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
