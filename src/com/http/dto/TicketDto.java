package com.http.dto;

import java.util.Objects;

public class TicketDto {
    private final Long id;
    private final String description;

    public TicketDto(Long id, String description){
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(id, ticketDto.id) && Objects.equals(description, ticketDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
