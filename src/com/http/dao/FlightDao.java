package com.http.dao;

import com.http.entity.Flight;
import com.http.entity.FlightStatus;
import com.http.util.ConnectionManager;
import com.http.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight>{

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL = """
            SELECT 
                id, 
                flight_no, 
                departure_date, 
                departure_airport_code, 
                arrival_date, 
                arrival_airport_code, 
                aircraft_id, 
                status 
            FROM flight
            """;

    private FlightDao(){}

    public static FlightDao getInstance(){
        return INSTANCE;
    }

    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionPool.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }

            return  flights;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    @Override
    public void update(Flight entity) {

    }

    private Flight buildFlight(ResultSet resultSet) throws SQLException {

        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))

        );
    }
}
