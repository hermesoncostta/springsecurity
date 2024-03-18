package com.seet.api.model;

public enum UsuarioRole {
    ADMIN("admin"),
    FINANCEIRO("financeiro"),
    CAIXA("caixa");
    private final String role;
    UsuarioRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}

