package ru.netology.airporttickets;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void addTicket(Ticket newTicket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = newTicket;
        tickets = tmp;
    }

    public void deleteById(int removeId) {
        if (tickets.length != 0) {
            Ticket[] tmp = new Ticket[tickets.length + 1];
            int copyToIndex = 0;

            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i].getId() != removeId) {
                    if (copyToIndex + 1 == tickets.length) {
                        return;
                    }
                    tmp[copyToIndex] = tickets[i];
                    copyToIndex++;
                }
            }
            tickets = tmp;
        }
    }

    public Ticket[] findAll() {
        return tickets;
    }
}

