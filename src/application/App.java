package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Cliente;
import model.entities.Deluxe;
import model.entities.HotelApp;
import model.entities.Standard;
import model.entities.Suite;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		HotelApp hotel = new HotelApp();
		
		hotel.adicionarQuarto(new Standard("101", 210.0));
		hotel.adicionarQuarto(new Deluxe("201", 200.0));
		hotel.adicionarQuarto(new Suite("301", 300.0));
		
		Cliente cliente1 = new Cliente("Pablo", "123.456.789-10");
		Cliente cliente2 = new Cliente("Maria", "213.456.789-10");
		hotel.cadastrarCliente(cliente1);
		hotel.cadastrarCliente(cliente2);
		
		LocalDate inicio = LocalDate.parse("10/10/2024", fmt);
		LocalDate fim = LocalDate.parse("14/10/2024", fmt);
		
		if(hotel.realizarReserva(hotel.quartos.get(0), cliente2, inicio, fim)){
			System.out.println("Reserva realizada com sucesso");
		}
		else {
			System.out.println("Não foi possível realizar a reserva");
		}
		if(hotel.realizarReserva(hotel.quartos.get(0), cliente1, inicio, fim)) {
			System.out.println("Reserva realizada com sucesso");
		}
		else {
			System.out.println("Não foi possível realizar a reserva");
		}
		
		hotel.listarReservar();
		
	}

}
