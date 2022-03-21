package com.aca.exam.exam2;


public class OrderPrinterRunnable implements Runnable {

    private final CrudRepository<Order, Integer> orderRepository;
    private final int orderId;

    public OrderPrinterRunnable(FileSourceOrderRepository orderRepository, int orderId) {
        this.orderRepository = orderRepository;
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println(orderRepository.findById(orderId));
    }

}
