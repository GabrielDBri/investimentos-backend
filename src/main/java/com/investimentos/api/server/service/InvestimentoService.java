package com.investimentos.api.server.service;

import com.investimentos.api.server.model.Investimento;
import com.investimentos.api.server.repository.InvestimentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    private final InvestimentoRepository investimentoRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository) {
        this.investimentoRepository = investimentoRepository;
    }

    // Listagem de todos os investimentos
    public List<Investimento> listarTodos() {
        return investimentoRepository.findAll();
    }

    // Cadastro de novo investimento
    @Transactional
    public Investimento salvar(Investimento investimento) {
        validarInvestimento(investimento);
        return investimentoRepository.save(investimento);
    }

    // Atualização de um investimento existente
    @Transactional
    public Investimento atualizar(Long id, Investimento investimentoAtualizado) {
        validarInvestimento(investimentoAtualizado);
        Optional<Investimento> investimentoExistente = investimentoRepository.findById(id);

        if (investimentoExistente.isPresent()) {
            Investimento investimento = investimentoExistente.get();
            investimento.setNome(investimentoAtualizado.getNome());
            investimento.setTipoInvestimento(investimentoAtualizado.getTipoInvestimento());
            investimento.setValorInvestido(investimentoAtualizado.getValorInvestido());
            investimento.setDataInvestimento(investimentoAtualizado.getDataInvestimento());
            return investimentoRepository.save(investimento);
        } else {
            throw new RuntimeException("Investimento não encontrado com o ID: " + id);
        }
    }

    // Exclusão de um investimento pelo ID
    @Transactional
    public void excluir(Long id) {
        if (investimentoRepository.existsById(id)) {
            investimentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Investimento não encontrado com o ID: " + id);
        }
    }

    // Validação de investimento
    private void validarInvestimento(Investimento investimento) {
        if (investimento.getValorInvestido() <= 0) {
            throw new RuntimeException("O valor investido deve ser maior que 0.");
        }
        if (investimento.getDataInvestimento().isAfter(LocalDate.now())) {
            throw new RuntimeException("A data do investimento não pode estar no futuro.");
        }
    }
}
