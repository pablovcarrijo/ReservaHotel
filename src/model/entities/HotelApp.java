package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelApp {

	public List<Quarto> quartos;
	public List<Cliente> clientes;
	public List<Reserva> reservas;
	
	public HotelApp() {
		this.quartos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}
	
	public void adicionarQuarto(Quarto quarto) {
		quartos.add(quarto);
	}
	
	public void cadastrarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public boolean realizarReserva(Quarto quarto, Cliente cliente, LocalDate inicio, LocalDate fim) {
		if(quarto.isDisponivel(inicio, fim)) {
			Reserva reserva = new Reserva(cliente, quarto, inicio, fim);
			reservas.add(reserva);
			quarto.reservar(inicio, fim);
			return true;
		}
		return false;
	}
	
	public void listarReservar() {
		for(Reserva rs : reservas) {
			System.out.println(rs);
		}
	}
	
}
