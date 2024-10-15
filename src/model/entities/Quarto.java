package model.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Quarto implements Reservavel{

	private String number;
	private Double pricePerDay;
	private Map<LocalDate, LocalDate> reservas;
	
	public Quarto(String number, Double pricePerDay) {
		this.number = number;
		this.pricePerDay = pricePerDay;
		this.reservas = new HashMap<>();
	}

	public String getNumber() {
		return number;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public Map<LocalDate, LocalDate> getReservas() {
		return reservas;
	}
	
	@Override 
	public boolean reservar(LocalDate inicio, LocalDate fim) {
		if(isDisponivel(inicio, fim)) {
			if(inicio.isBefore(fim) && fim.isAfter(inicio)) {				
				reservas.put(inicio, fim);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean cancelarReserva(LocalDate inicio, LocalDate fim) {
		return reservas.remove(inicio, fim);
	}
	
	@Override
	public boolean isDisponivel(LocalDate inicio, LocalDate fim) {
		for(LocalDate map : reservas.keySet()) {
			if(map.isBefore(inicio) && reservas.get(map).isAfter(fim)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Quarto: " + getNumber() + " - US$" + String.format("%.2f", getPricePerDay());
	}
	
}
