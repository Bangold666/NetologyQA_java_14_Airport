import org.junit.jupiter.api.Test;
import ru.netology.airporttickets.Ticket;
import ru.netology.airporttickets.TicketManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    @Test
    public void shouldShowEmptyOffers() {
        TicketManager manager = new TicketManager();
        Ticket[] expected = {};
        assertArrayEquals(expected, manager.showOffers());
    }

    @Test
    void mustSearchIfNotExists() {
        TicketManager manager = new TicketManager();
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("AAA", "AAJ"));
    }

    @Test
    public void shouldAddSortAndShowNoEmpty() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 2000, "AAA", "AAB", 120);
        Ticket ticket2 = new Ticket(2, 2100, "AAA", "AAB", 150);
        Ticket ticket3 = new Ticket(3, 5000, "AAA", "AAB", 140);
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        assertArrayEquals(expected, manager.showOffers());

    }

    @Test
    public void shouldFindAndSort() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 1000, "AAA", "AAB", 120);
        Ticket ticket2 = new Ticket(2, 1200, "AAA", "AAB", 150);
        Ticket ticket3 = new Ticket(3, 500, "AAA", "AAB", 140);
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);

        Ticket[] actual = manager.findAll("AAA", "AAB");
        Ticket[] expected = {ticket3, ticket1, ticket2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldShowSortedOffers() {
        TicketManager manager = new TicketManager();
        Ticket ticket1 = new Ticket(1, 1000, "AAA", "AAB", 120);
        Ticket ticket2 = new Ticket(2, 12000, "AAA", "AAB", 150);
        Ticket ticket3 = new Ticket(3, 5000, "AAA", "AAB", 140);
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);

        Ticket[] expected = {ticket1, ticket3, ticket2};
        assertArrayEquals(expected, manager.showOffers());

    }


}
