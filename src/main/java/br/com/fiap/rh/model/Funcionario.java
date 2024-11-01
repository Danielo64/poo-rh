package br.com.fiap.rh.model;


import com.vaadin.flow.component.icon.VaadinIcon;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public abstract class Funcionario {

    private UUID id;
    private String matricula;
    private String nome;
    private Double salarioBase;

    public abstract Double calcularSalario();

    public abstract String getTipo();

}
