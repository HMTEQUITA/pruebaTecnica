package com.mauricioTequita.libreriaApp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reserva implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaReserva;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="reserva_id")
	private List<DetalleReserva> detalleReserva;

	public Reserva() {
		this.detalleReserva = new ArrayList<DetalleReserva>();
	}
	
	@PrePersist
	public void prePersist() {
		fechaReserva = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleReserva> getDetalleReserva() {
		return detalleReserva;
	}

	public void setDetalleReserva(List<DetalleReserva> detalleReserva) {
		this.detalleReserva = detalleReserva;
	}
	
	public Long calcularTotal() {
		return detalleReserva.stream().mapToLong(d -> d.getCantidadReservada() * d.getTarifaPagada()).sum();
	}
	
	private static final long serialVersionUID = 1L;

}
