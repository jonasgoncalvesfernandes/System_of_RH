package model.utils;

import model.CadastroFuncionarios.CadastroFuncionarioHorista;
import model.CadastroFuncionarios.CadastroFuncionarioAssalariado;
import model.CadastroFuncionarios.CadastroFuncionarioComissionado;

public class VerificadorDuplicidadeCPF {
    // Boolean retorna true ou false
    // Método que verifica se o CPF está duplicado em qualquer lista
    public static boolean verificarDuplicidadeCPF(String cpf, CadastroFuncionarioHorista cadastroHorista,
            CadastroFuncionarioAssalariado cadastroAssalariado,
            CadastroFuncionarioComissionado cadastroComissionado) {
        // Verificando se o CPF digitado já existe em alguma das listas de funcionários
        // (Horista, Assalariado, Comissionado)
        // O método 'procurarPorCpf' utiliza o 'equals' para comparar o CPF digitado com
        // os registrados nas listas
        if (cadastroHorista.procurarPorCpf(cpf) != null ||
                cadastroAssalariado.procurarPorCpf(cpf) != null ||
                cadastroComissionado.procurarPorCpf(cpf) != null) {
            return true; // CPF já existe em alguma das listas
        }
        return false; // CPF não encontrado em nenhuma lista
    }


}
