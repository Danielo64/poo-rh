package br.com.fiap.rh.service;

import br.com.fiap.rh.model.Auxiliar;
import br.com.fiap.rh.model.Diretor;
import br.com.fiap.rh.model.Funcionario;
import br.com.fiap.rh.model.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioService(){
        funcionarios = List.of(
            new Professor(UUID.randomUUID(), "12345", "Joao Carlos", 75.0, 10),
            new Diretor(UUID.randomUUID(), "54312", "Daniel Souza", 4000.0, 2000.0),
            new Auxiliar(UUID.randomUUID(), "42342", "Fernanda Takai", 3000.0)
        );
    }

    public List<Funcionario> buscarTodos(){
        return funcionarios;
    }

    public Double calcularFolha(){
        return funcionarios.stream().mapToDouble(Funcionario::calcularSalario).sum();
    }

    public Double calcularIndice(Pedagogico funcionario){
        return funcionario.calcularIndice();
        //return null;
    }

}
