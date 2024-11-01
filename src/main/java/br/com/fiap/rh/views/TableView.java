package br.com.fiap.rh.views;

import br.com.fiap.rh.model.Funcionario;
import br.com.fiap.rh.model.Pedagogico;
import br.com.fiap.rh.service.FuncionarioService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class TableView extends VerticalLayout {

    private FuncionarioService funcionarioService;
    private Grid<Funcionario> grid = new Grid<>(Funcionario.class, true);

    public TableView(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
        grid.setEmptyStateText("Nenhum funcionário cadastrado");
        grid.setItems(funcionarioService.buscarTodos());
        grid.setColumns("matricula", "nome", "salarioBase");

        grid.addColumn(Funcionario::calcularSalario)
                .setHeader("Salário")
                .setFooter("Total: " + funcionarioService.calcularFolha())
        ;

        grid.addColumn( Funcionario::getTipo).setHeader("Tipo");

       grid.addComponentColumn(funcionario -> {
            if (funcionario instanceof Pedagogico) {
                return new Paragraph(calcularIndice((Pedagogico) funcionario));
            }
            return new Paragraph("N/A");
        }).setHeader("Indice");

        add(grid);
    }

    private String calcularIndice(Pedagogico funcionario) {
        return funcionarioService.calcularIndice(funcionario).toString();
    }
}
