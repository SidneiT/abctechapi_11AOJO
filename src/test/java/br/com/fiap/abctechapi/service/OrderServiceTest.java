package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.entity.OrderLocation;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {

    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private AssistanceRepository assistanceRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository, assistanceRepository);
        Mockito.when(assistanceRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(new Assistance(1L, "Test", "Test Description")));
    }

    @Test
    public void create_order_error_min_assist() {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MinimumAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    @Test
    public void create_order_error_max_assist() {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(
                MaximumAssistException.class, () ->
                orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 1L, 2L))
        );
        Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    //TODO: para entrega, criando ordem
    @Test
    public void create_order_assist() {
        Order newOrder = new Order();
        Date date = new Date();
        Timestamp dateTime =  new Timestamp(date.getTime());

        newOrder.setOperatorId(1234L);
        newOrder.setStartOrderLocation(new OrderLocation(
                null,
                -23.659070138471588,
                -46.598905203031855,
                dateTime
        ));

        try {
            orderService.saveOrder(newOrder, List.of(1L, 2L));
        } catch (Exception e) {
            throw new AssertionError(e.getMessage(), e);
        }

        Mockito.verify(orderRepository, Mockito.times(1)).save(newOrder);
    }
}
