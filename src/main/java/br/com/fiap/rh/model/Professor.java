package br.com.fiap.rh.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Professor extends Funcionario implements Pedagogico {
    @Override
    public Double calcularIndice() {
        if (qtdeAulas > 10) {
            return getSalarioBase() * 0.1;
        }
        if(qtdeAulas > 5) {
            return getSalarioBase() * 0.05;
        }
        return 0.0;
    }

    private Integer qtdeAulas;

    public Professor(UUID id, String matricula, String nome, Double salarioBase, Integer qtdeAulas) {
        super(id, matricula, nome, salarioBase);
        this.qtdeAulas = qtdeAulas;
    }

    @Override
    public Double calcularSalario() {
        return getSalarioBase() * qtdeAulas;
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}
