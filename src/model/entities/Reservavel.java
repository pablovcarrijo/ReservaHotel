package model.entities;

import java.time.LocalDate;

public interface Reservavel {

	boolean reservar(LocalDate inicio, LocalDate fim);
	boolean isDisponivel(LocalDate inicio, LocalDate fim);
	boolean cancelarReserva(LocalDate inicio, LocalDate fim);
	
}
