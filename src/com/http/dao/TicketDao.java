package com.http.dao;

import com.http.entity.Ticket;
import com.http.util.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket>{

    private static final TicketDao INSTANCE = new TicketDao();

    private static final String FIND_BY_ID = """
            select 
            id,
            passenger_no,
            passenger_name,
            flight_id,
            seat_no,
            cost
            from ticket
            WHERE flight_id = ?
            """;

    private TicketDao(){}

    public static TicketDao getInstance() {
        return INSTANCE;
    }
    public List<Ticket> findAll(Long flightId) {
        try (Connection connection = ConnectionPool.get();
             var prepareStatement = connection.prepareStatement(FIND_BY_ID)) {

            prepareStatement.setObject(1, flightId);
            List<Ticket> tickets = new ArrayList<>();
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()){
                tickets.add(buildTicket(resultSet));
            }

            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    private Ticket buildTicket(ResultSet resultSet) {
        try {
            return new Ticket(
                    resultSet.getObject("id", Long.class),
                    resultSet.getObject("passenger_no", String.class),
                    resultSet.getObject("passenger_name", String.class),
                    resultSet.getObject("flight_id", Long.class),
                    resultSet.getObject("seat_no", String.class),
                    resultSet.getObject("cost", BigDecimal.class)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }
}
