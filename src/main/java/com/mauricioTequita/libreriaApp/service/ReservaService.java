package com.mauricioTequita.libreriaApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricioTequita.libreriaApp.domain.Reserva;
import com.mauricioTequita.libreriaApp.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	public void guardarReserva(Reserva reserva) {
		reservaRepository.save(reserva);
	}

	public List<Reserva> listarReservas(int usuarioId) {
		return reservaRepository.findByUsuarioId(usuarioId);
	}

	public Reserva buscarReserva(int idReserva) {
		return reservaRepository.findByid(idReserva);
	}
}
