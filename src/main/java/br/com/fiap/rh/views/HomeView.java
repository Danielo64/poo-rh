package br.com.fiap.rh.views;

import br.com.fiap.rh.service.FuncionarioService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

@Route("")
@Component
public class HomeView extends VerticalLayout {

    private final FuncionarioService funcionarioService;

    public HomeView(FuncionarioService funcionarioService) {

        add(new H1("Recursos Humanos"));
        add(new TableView(funcionarioService));
        this.funcionarioService = funcionarioService;
    }
}
