package com.att3.Atividade3.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome; 
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produto;

}
