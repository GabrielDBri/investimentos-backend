package com.investimentos.api.server.model;

public enum TipoInvestimento {
    ACAO,
    FUNDO,
    TITULO,
    CDB,
    LCI,
    LCA;

    public static TipoInvestimento fromString(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Tipo de investimento não pode ser nulo ou vazio.");
        }

        try {
            return TipoInvestimento.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de investimento inválido: " + tipo);
        }
    }
}
