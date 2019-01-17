package br.com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "contato")
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30,nullable = false)
    private String telefone1;
    @Column(length = 30,nullable = false)
    private String telefone2;
    @Column(length = 30,nullable = false)
    private String email;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Cliente clienteContato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getClienteContato() {
        return clienteContato;
    }

    public void setClienteContato(Cliente clienteContato) {
        this.clienteContato = clienteContato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id) &&
                Objects.equals(clienteContato, contato.clienteContato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clienteContato);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", telefone1='" + telefone1 + '\'' +
                ", telefone2='" + telefone2 + '\'' +
                ", email='" + email + '\'' +
                ", clienteContato=" + clienteContato +
                '}';
    }
}
