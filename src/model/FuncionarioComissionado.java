package model;

public class FuncionarioComissionado extends Funcionarios {
    private double comissao;
    private double salarioBase;
    private double vendas; // Total de vendas realizadas pelo funcionário

    // Construtor da classe
    public FuncionarioComissionado(String nome, String cpf, String cargo, double salarioBase) {
        super(nome, cpf, cargo);
        this.salarioBase = salarioBase;
    }

    // Getter e Setter para comissão
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    // Getter e Setter para vendas
    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getVendas() {
        return vendas;
    }

    // Método para calcular o salário com comissão
    public double calcularSalarioComissao() {
        // Caso de comissão simples (comissão sobre o valor das vendas)
        double valorComissao = vendas * comissao / 100; // comissão em percentual sobre as vendas
        return salarioBase + valorComissao;
    }

    // Método para comissão escalonada (exemplo)
    public double calcularSalarioComissaoEscalonada() {
        double valorComissao = 0.0;
    
        if (vendas <= 5000) {
            valorComissao = this.vendas * 0.05; // 5% para vendas até 5000
            return calcularNovaComissao(salarioBase, valorComissao);
        }
    
        if (vendas <= 10000) {
            valorComissao = (5000 * 0.05) + ((this.vendas - 5000) * 0.07); // 7% para vendas acima de 5000
            return calcularNovaComissao(salarioBase, valorComissao);
        }
    
        valorComissao = (5000 * 0.05) + (5000 * 0.07) + ((this.vendas - 10000) * 0.10); // 10% para vendas acima de 10000
        return calcularNovaComissao(salarioBase, valorComissao);
    }
    
    private double calcularNovaComissao(double salarioBase, double valorComissao) {
        return salarioBase + valorComissao;
    }
    

    // Método para exibir salário completo
    public void exibirSalario() {
        double salarioComComissao = calcularSalarioComissao(); // Ou calcularSalarioComissaoEscalonada() se for o caso
        System.out.println("Salário do funcionário " + getNome() + ": R$ " + salarioComComissao);
    }
    @Override
    public String toString(){
        return super.toString() + "\nSalario base: R$" + salarioBase + "\nSalario com comissão: R$ " + calcularSalarioComissaoEscalonada();

    }

}
