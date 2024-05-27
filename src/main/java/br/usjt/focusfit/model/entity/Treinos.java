package br.usjt.focusfit.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TB_TREINOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treinos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "SERIES", nullable = false)
    private Integer series;

    @Column(name = "REPETICOES", nullable = false)
    private Integer repeticoes;
}
