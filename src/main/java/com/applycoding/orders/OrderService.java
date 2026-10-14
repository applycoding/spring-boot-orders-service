package com.applycoding.orders;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final Map<Long, Order> store = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    public Order create(Order in) {
        Order o = new Order(ids.incrementAndGet(), in.item(), in.quantity());
        store.put(o.id(), o);
        return o;
    }

    public Optional<Order> find(long id) { return Optional.ofNullable(store.get(id)); }

    public List<Order> all() { return new ArrayList<>(store.values()); }

    public boolean delete(long id) { return store.remove(id) != null; }
}
