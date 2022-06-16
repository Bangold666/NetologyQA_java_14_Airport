package ru.netology.airporttickets;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String airportFrom;
    private String airportTo;
    private int travelTime;

    @Override
    public int compareTo(Ticket otherTicket) {
        if (cost < otherTicket.cost) {
            return -1;
        }
        if (cost > otherTicket.cost) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && cost == ticket.cost && travelTime == ticket.travelTime && airportFrom.equals(ticket.airportFrom) && airportTo.equals(ticket.airportTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, airportFrom, airportTo, travelTime);
    }

    public int getId() {
        return id;
    }
}