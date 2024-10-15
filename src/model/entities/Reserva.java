package model.entities;

import java.time.LocalDate;

public class Reserva {

	private Cliente cliente;
	private Quarto quarto;
	private LocalDate inicio;
	private LocalDate fim;
	
	public Reserva(Cliente cliente, Quarto quarto, LocalDate inicio, LocalDate fim) {
		this.cliente = cliente;
		this.quarto = quarto;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public LocalDate getFim() {
		return fim;
	}
	
	@Override
	public String toString() {
		return "Reserva: " + cliente.getName() + " - CPF: " + cliente.getCpf() + "; Quarto: " + quarto.getNumber() +
				"- Price per day: US$" + quarto.getPricePerDay() + " de " + getInicio() + " até " + getFim();
	}
	
}
