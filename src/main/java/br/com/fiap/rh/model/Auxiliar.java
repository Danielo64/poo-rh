package br.com.fiap.rh.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class Auxiliar extends Funcionario{

    public Auxiliar(UUID id, String matricula, String nome, Double salarioBase) {
        super(id, matricula, nome, salarioBase);
    }

    @Override
    public Double calcularSalario() {
        return getSalarioBase();
    }

    @Override
    public String getTipo() {
        return "Auxiliar";
    }
}
