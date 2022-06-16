package ru.netology.airporttickets;

import java.util.Arrays;

public class TicketManager {

    private final TicketRepository repository = new TicketRepository();

    public Ticket[] findAll(String from, String to) {

        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.findAll()) {
            if (ticket.getAirportFrom().equalsIgnoreCase(from) && ticket.getAirportTo().equalsIgnoreCase(to)) {

                Ticket[] tmp = new Ticket[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public void addTicket(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public Ticket[] showOffers() {
        Ticket[] result = repository.findAll();
        Arrays.sort(result);
        return result;
    }


}
