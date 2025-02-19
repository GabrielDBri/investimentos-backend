package com.investimentos.api.server.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public record InvestimentoDTO(
        Long id,


        String nome,

        String tipoInvestimento, // Agora representado como String

        @Positive(message = "O valor investido deve ser positivo")
        @NotNull(message = "O valor investido é obrigatório")
        Double valorInvestido,

        @NotNull(message = "Data do investimento é obrigatória")
        LocalDate dataInvestimento
) {}
