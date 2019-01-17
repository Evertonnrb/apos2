package br.com.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Pessoa {
    @Column(length = 100,nullable = false)
    private String nome;

    @Column(length = 15,nullable = false,unique = true)
    private String cpf;

    @Column(length = 15,unique = true)
    private String rg;

    @Column(length = 200)
    private String endereco;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    public Pessoa(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
