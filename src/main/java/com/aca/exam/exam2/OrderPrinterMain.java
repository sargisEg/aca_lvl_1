package com.aca.exam.exam2;

import java.util.List;

public class OrderPrinterMain {

    public static void main(String[] args) {
        List<OrderPrinterRunnable> runnable = List.of(
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 1),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 2),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 3),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 4),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 5),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 6),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 7),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 8),
                new OrderPrinterRunnable(new FileSourceOrderRepository(FileSourceUserRepository.getInstance()), 9)
        );

        for (Runnable orderPrinterRunnable : runnable) {
            orderPrinterRunnable.run();
        }

    }
}
