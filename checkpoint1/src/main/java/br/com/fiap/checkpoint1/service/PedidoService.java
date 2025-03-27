// src/main/java/br/com/fiap/checkpoint1/service/PedidoService.java

package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repository;
    
    public List<Pedido> findAll() {
        return repository.findAll();
    }
    
    public Pedido findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
    
    public Pedido save(Pedido pedido) {
        if (pedido.getClienteNome() == null || pedido.getClienteNome().trim().isEmpty()) {
            throw new RuntimeException("Nome do cliente é obrigatório");
        }
        if (pedido.getValorTotal() < 0) {
            throw new RuntimeException("Valor total não pode ser negativo");
        }
        return repository.save(pedido);
    }
    
    public Pedido update(Long id, Pedido pedido) {
        Pedido existingPedido = findById(id);
        pedido.setId(id);
        return save(pedido);
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}