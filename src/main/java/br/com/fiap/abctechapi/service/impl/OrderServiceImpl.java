package br.com.fiap.abctechapi.service.impl;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AssistanceRepository assistanceRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, AssistanceRepository assistanceRepository) {
        this.orderRepository = orderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> assistsId) {
        ArrayList<Assistance> list = new ArrayList<>();
        assistsId.forEach(id -> {
            Optional<Assistance> assistance = assistanceRepository.findById(id);
            assistance.ifPresent(list::add);
        });

        if (list.isEmpty()) {
            throw new MinimumAssistRequiredException("Error nas assistências", "Não encontramos nenhuma assistência valida");
        } else if (list.size() > 15) {
            throw new MaximumAssistException("Error nas assistências", "Não devemos enviar mais de 15 assistências");
        }
        order.setAssists(list);

        this.orderRepository.save(order);
    }
}
