package br.com.model.enuns;

import javax.persistence.Enumerated;

public enum Status {
    OK("ok"),
    ATRASADO("atrasado"),
    INADIMPLENTE("inadimplente"),
    BLOQUEADO("bloqueado");

    private final String status = null;

    Status(String situacao){
        situacao = status;
    }

    public String getStatus() {
        return status;
    }
}
