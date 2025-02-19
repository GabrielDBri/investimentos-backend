package com.investimentos.api.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TB_INVESTIMENTO")
@Getter
@Setter
@RequiredArgsConstructor
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome do investimento é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Tipo de investimento é obrigatório")
    @Column(nullable = false, length = 50)
    private TipoInvestimento tipoInvestimento;

    @Positive(message = "O valor investido deve ser positivo")
    @NotNull(message = "O valor investido é obrigatório")
    @Column(nullable = false)
    private Double valorInvestido;

    @NotNull(message = "Data do investimento é obrigatória")
    @Column(nullable = false)
    private LocalDate dataInvestimento;



}
