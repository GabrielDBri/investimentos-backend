package com.investimentos.api.server.controller;

import com.investimentos.api.server.model.Investimento;
import com.investimentos.api.server.model.InvestimentoDTO;
import com.investimentos.api.server.model.TipoInvestimento;
import com.investimentos.api.server.service.InvestimentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Investimento>> listarTodos() {
        List<Investimento> investimentos = investimentoService.listarTodos();
        return ResponseEntity.ok(investimentos);
    }

    @PostMapping
    public ResponseEntity<Investimento> criarInvestimento(@Valid @RequestBody InvestimentoDTO investimentoDTO) {
        // Criando uma nova instância da entidade Investimento
        Investimento investimento = new Investimento();

        // Setando os valores da entidade com os valores do DTO
        investimento.setNome(investimentoDTO.nome());
        investimento.setTipoInvestimento(TipoInvestimento.fromString(investimentoDTO.tipoInvestimento())); // Convertendo a String para Enum
        investimento.setValorInvestido(investimentoDTO.valorInvestido());
        investimento.setDataInvestimento(investimentoDTO.dataInvestimento());

        // Salvando o investimento no banco de dados
        Investimento novoInvestimento = investimentoService.salvar(investimento);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoInvestimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investimento> atualizarInvestimento(@PathVariable Long id, @Valid @RequestBody Investimento investimento) {
        Investimento investimentoAtualizado = investimentoService.atualizar(id, investimento);
        return ResponseEntity.ok(investimentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirInvestimento(@PathVariable Long id) {
        investimentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
