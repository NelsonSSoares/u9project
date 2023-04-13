package com.ibmshop.userapi.domain.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalhes_pedido")
public class DetalhesPedido {
	
	@ManyToOne
	@JoinColumn(name ="pedido_id")
	private Integer pedidoId;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Integer produtoId; //poderia ser uma lista 
	
	
	private Integer quantidade;
	
	@Column(name = "preco_total", precision = 20, scale = 2)
	private BigDecimal precoTotal;
	
	
}
