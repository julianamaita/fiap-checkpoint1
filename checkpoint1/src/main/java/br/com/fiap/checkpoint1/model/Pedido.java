// src/main/java/br/com/fiap/checkpoint1/model/Pedido.java

package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String clienteNome;
    
    private LocalDate dataPedido = LocalDate.now();
    
    @Column(nullable = false)
    private double valorTotal;
}