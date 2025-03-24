package br.com.rherik.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "escolas-de-samba")
public class Escola implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 80)
    private String name;
    @Column(nullable = false, length = 80)
    private String fundacao;
    @Column(nullable = false)
    private int titulos;
    // classe responsável por formatar um padrão diferente do formato ISO
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Escola() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFundacao() {
        //return formatter.format(fundacao);
        return fundacao;
    }

    public void setFundacao(String fundacao) {
        //this.fundacao = LocalDate.parse(fundacao);
        this.fundacao = fundacao;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Escola escola)) return false;
        return getFundacao() == escola.getFundacao() && getTitulos() == escola.getTitulos() && Objects.equals(getId(), escola.getId()) && Objects.equals(getName(), escola.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFundacao(), getTitulos());
    }
}
