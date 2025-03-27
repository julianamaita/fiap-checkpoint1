// src/main/java/br/com/fiap/checkpoint1/controller/PedidoController.java

package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService service;
    
    @GetMapping
    public List<Pedido> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return service.save(pedido);
    }
    
    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido) {
        return service.update(id, pedido);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}