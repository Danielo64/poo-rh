package br.com.fiap.rh.model;

import java.util.UUID;

public class Diretor extends Funcionario implements Pedagogico {

    @Override
    public Double calcularIndice() {
        return calcularSalario() * 0.1;
    }

    private Double gratificacao;

    public Diretor(UUID id, String matricula, String nome, Double salarioBase, Double gratificacao) {
        super(id, matricula, nome, salarioBase);
        this.gratificacao = gratificacao;
    }

    @Override
    public Double calcularSalario() {
        return this.getSalarioBase() + gratificacao;
    }

    @Override
    public String getTipo() {
        return "Diretor";
    }
}
