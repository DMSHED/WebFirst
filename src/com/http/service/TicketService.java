package com.http.service;

import com.http.dao.TicketDao;
import com.http.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();
    private static final TicketDao ticketDao = TicketDao.getInstance();
    private TicketService() {}

    public List<TicketDto> findAll(Long flightId){
        return ticketDao.findAll(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        """
                                %s : %s : %s : %f
                                """.formatted(
                                        ticket.getPassengerNo(),
                                        ticket.getPassengerName(),
                                        ticket.getSeatNo(),
                                        ticket.getCost())
                        )
                )
                .collect(Collectors.toList());
    }

    public static TicketService getInstance(){
        return INSTANCE;
    }
}
