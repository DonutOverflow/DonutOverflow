package PAO.example.project;

import PAO.example.project.Client.Client;
import PAO.example.project.Client.ClientRepository;
import PAO.example.project.Client.ClientService;
import PAO.example.project.Event.Concert.Concert;
import PAO.example.project.Event.Concert.ConcertRepository;
import PAO.example.project.Event.Concert.ConcertService;
import PAO.example.project.Ticket.Ticket;
import PAO.example.project.Ticket.TicketRepository;
import PAO.example.project.Ticket.TicketService;
import PAO.example.project.Venue.Venue;
import PAO.example.project.Venue.VenueRepository;
import PAO.example.project.Venue.VenueService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class ProjectApplication {

	private static ClientRepository clientRepository;
	private static TicketRepository ticketRepository;
	private static ConcertRepository concertRepository;
	private static VenueRepository venueRepository;

	public ProjectApplication(ClientRepository clientRepository1, TicketRepository ticketRepository1, ConcertRepository concertRepository1, VenueRepository venueRepository1) {
		clientRepository = clientRepository1;
		ticketRepository = ticketRepository1;
		concertRepository = concertRepository1;
		venueRepository = venueRepository1;
	}

	public static void printMenu(String[] options){
		for (String option : options){
			System.out.println(option);
		}
		System.out.print("Choose your option : ");
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProjectApplication.class, args);




		String[] options = {"1- POST MENU",
				"2- PRINT MENU",
				"3- DELETE MENU",
				"4- UPDATE MENU",
				"else- Exit",
		};
		String[] options1 = {"1- POST CLIENT",
				"2- PRINT TICKET",
				"3- DELETE CONCERT",
				"4- PRINT VENUE",
				"else- Exit",
		};
		String[] options2 = {"1- PRINT CLIENT",
				"2- PRINT TICKET",
				"3- PRINT CONCERT",
				"4- PRINT VENUE",
				"else- Exit"
		};
		String[] options3 = {"1- DELETE CLIENT",
				"2- DELETE TICKET",
				"3- DELETE CONCERT",
				"4- DELETE VENUE",
				"else- Exit"
		};
		String[] options4 = {"1- UPDATE CLIENT",
				"2- UPDATE TICKET",
				"3- UPDATE CONCERT",
				"4- UPDATE VENUE",
				"else- Exit"
		};

		Scanner scanner = new Scanner(System.in);
		int option = 1;
		while (option!=4){
			printMenu(options);
			try {
				option = scanner.nextInt();
			}
			catch (InputMismatchException ex){
				System.out.println("Please enter an integer value between 1 and " + options.length);
				scanner.next();
			}
			catch (Exception ex){
				System.out.println("An unexpected error happened. Please try again");
				scanner.next();
			}
			switch (option){

				case 1:
					printMenu(options1);
					option = scanner.nextInt();
					switch (option){

						case 1:
							Client client = new Client();

							System.out.println("Nume");
							client.setNume(scanner.nextLine());
							client.setNume(scanner.nextLine());
							System.out.println("Prenume");
							client.setPrenume(scanner.nextLine());
							System.out.println("email");
							client.setEmail(scanner.nextLine());
							System.out.println("date: day");
							var day = scanner.nextInt();
							System.out.println("date: month");
							var month = scanner.nextInt();
							System.out.println("date: year");
							var year = scanner.nextInt();
							LocalDate dob = LocalDate.of(year, month, day);
							client.setDob(dob);
							ClientService clientService = new ClientService(clientRepository);
							clientService.addNewClient(client);
							break;
						case 2:
							Ticket ticket = new Ticket();
							System.out.println("Price");
							ticket.setPrice(scanner.nextInt());
							ticket.setPrice(scanner.nextInt());
							System.out.println("Category");
							ticket.setCategorie(scanner.nextLine());
							System.out.println("Details");
							ticket.setDetalii(scanner.nextLine());

							TicketService ticketService = new TicketService(ticketRepository);
							ticketService.addNewTicket(ticket);
							break;
						case 3:
							Concert concert = new Concert();
							System.out.println("Name");
							concert.setNume(scanner.nextLine());
							concert.setNume(scanner.nextLine());
							System.out.println("Concert type");
							concert.setTip_concert(scanner.nextLine());
							System.out.println("Bands");
							concert.setTrupe(scanner.nextLine());
							System.out.println("Lead Band members");
							concert.setMembriiTrupaPrincipala(scanner.nextLine());
							System.out.println("How long is the concert(hours)");
							concert.setDurata_in_ore(scanner.nextInt());
							System.out.println("Description");
							concert.setDescription(scanner.nextLine());
							System.out.println("date: day");
							day = scanner.nextInt();
							System.out.println("date: month");
							month = scanner.nextInt();
							System.out.println("date: year");
							year = scanner.nextInt();
							LocalDate date = LocalDate.of(year, month, day);
							concert.setData(date);
							System.out.println("Sponsors");
							concert.setSponsor(scanner.nextLine());

							ConcertService concertService = new ConcertService(concertRepository);
							concertService.addNewConcert(concert);
							break;

						case 4:

							Venue venue = new Venue();
							System.out.println("Country");
							venue.setTara(scanner.nextLine());
							venue.setTara(scanner.nextLine());
							System.out.println("City");
							venue.setOras(scanner.nextLine());
							System.out.println("Address");
							venue.setAdresa(scanner.nextLine());
							System.out.println("Available places");
							venue.setNrLocuri(scanner.nextInt());
							System.out.println("Phone number");
							venue.setNrTelefon(scanner.nextLine());

							VenueService venueService = new VenueService(venueRepository);
							venueService.addNewVenue(venue);
							break;

						default:

					}

				case 2:
					printMenu(options2);
					option = scanner.nextInt();
					switch(option){
						case 1:
							scanner.nextLine();
							ClientService clientService = new ClientService(clientRepository);

							List<Client> client;
							client = clientService.getClients();

							for(Client value : client){
								System.out.println(value.toString());
							}
							break;

						case 2:
							scanner.nextLine();
							TicketService ticketService = new TicketService(ticketRepository);

							List<Ticket> ticket;
							ticket = ticketService.getTickets();

							for(Ticket value : ticket){
								System.out.println(value.toString());
							}
							break;
						case 3:
							scanner.nextLine();
							ConcertService concertService = new ConcertService(concertRepository);

							List<Concert> concert;
							concert = concertService.getConcerts();

							for(Concert value : concert){
								System.out.println(value.toString());
							}
							break;
						case 4:
							scanner.nextLine();
							VenueService venueService = new VenueService(venueRepository);

							List<Venue> venue;
							venue = venueService.getVenues();

							for(Venue value : venue){
								System.out.println(value.toString());
							}
							break;
						default:


					}

				case 3:
					printMenu(options3);
					option = scanner.nextInt();
					switch(option){
						case 1:
							scanner.nextLine();
							ClientService clientService = new ClientService(clientRepository);
							
							System.out.println("Select id of Client to delete");
							clientService.deleteClient(scanner.nextLong());


							break;
						case 2:
							scanner.nextLine();
							TicketService ticketService = new TicketService(ticketRepository);

							System.out.println("Select id of Ticket to delete");
							ticketService.deleteTicket(scanner.nextLong());
							
							break;
						case 3:
							scanner.nextLine();
							ConcertService concertService = new ConcertService(concertRepository);

							System.out.println("Select id of Concert to delete");
							concertService.deleteConcert(scanner.nextLong());

							break;
						case 4:
							scanner.nextLine();
							VenueService venueService = new VenueService(venueRepository);

							System.out.println("Select id of Venue to delete");
							venueService.deleteVenue(scanner.nextLong());

							break;
						default:
					}
				case 4:
					printMenu(options4);
					option = scanner.nextInt();
					switch(option){
						case 1:
							scanner.nextLine();
							ClientService clientService = new ClientService(clientRepository);
							System.out.println("Update Client by Id");
							var id = scanner.nextLong();
							System.out.println("Update Nume");
							scanner.nextLine();
							var nume = scanner.nextLine();
							System.out.println("Update Prenume");
							scanner.nextLine();
							var prenume = scanner.nextLine();
							
							clientService.updateClient(id, nume, prenume);
							break;
						case 2:
							scanner.nextLine();
							TicketService ticketService = new TicketService(ticketRepository);
							System.out.println("Update Ticket by Id");
							id = scanner.nextLong();
							System.out.println("Update Price");
							scanner.nextLine();
							var price = scanner.nextInt();
							ticketService.updateTicket(id, price);
							break;
						case 3:
							scanner.nextLine();
							ConcertService concertService = new ConcertService(concertRepository);
							System.out.println("Update Concert by Id");
							id = scanner.nextLong();
							System.out.println("Update Duration(hours)");
							scanner.nextLine();
							var durata_in_ore = scanner.nextInt();
							concertService.updateConcert(id, durata_in_ore);
							break;
						case 4:
							scanner.nextLine();
							VenueService venueService = new VenueService(venueRepository);
							System.out.println("Update Venue by Id");
							id = scanner.nextLong();
							System.out.println("Update Available places");
							scanner.nextLine();
							var nrLocuri = scanner.nextInt();
							venueService.updateVenue(id, nrLocuri);
							break;
						default:
					}
					

				default:
			}

		}
		context.close();



	}



}
