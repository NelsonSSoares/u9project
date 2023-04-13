package com.ibmshop.userapi.domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany
	@Column(name ="usuario_id")
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioId;
	
	@Column(name = "data_criacao")
	private Date dataCriacao;
	
	@Column(name = "status_pedido")
	private Integer statusPedido;
	
	@Column(name = "numero_pedido")
	private Integer numeroPedido;
}
