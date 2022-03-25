package com.aca.exam.exam2;

import com.aca.exam.exam2.annotations.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Repository
public class FileSourceOrderRepository implements CrudRepository<Order, Integer> {

    private final FileSourceUserRepository fileSourceUserRepository;

    public FileSourceOrderRepository(FileSourceUserRepository fileSourceUserRepository) {
        this.fileSourceUserRepository = fileSourceUserRepository;
    }

    @Override
    public Order findById(Integer integer) {
        Scanner scanner = newScannerWithFile();

        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] newOrderFromFile = scanner.nextLine().split(",");

            int id = getIdFrom(newOrderFromFile);
            if (id == integer) {
                String name = getNameFrom(newOrderFromFile);
                int price = getPriceFrom(newOrderFromFile);
                String ordersUserId = getUserIdFrom(newOrderFromFile);

                User ordersUser = fileSourceUserRepository.findById(ordersUserId);

                return new Order(id, name, price, ordersUser);
            }
        }

        scanner.close();
        return null;

    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new LinkedList<>();
        Scanner scanner = newScannerWithFile();

        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] newOrderFromFile = scanner.nextLine().split(",");

            int id = getIdFrom(newOrderFromFile);
            String name = getNameFrom(newOrderFromFile);
            int price = getPriceFrom(newOrderFromFile);
            String ordersUserId = getUserIdFrom(newOrderFromFile);

            User ordersUser = fileSourceUserRepository.findById(ordersUserId);

            orders.add(new Order(id, name, price, ordersUser));
        }

        scanner.close();
        return orders;
    }

    public List<Order> findAllByUserId(String userId) {
        List<Order> orders = new LinkedList<>();
        Scanner scanner = newScannerWithFile();

        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] newOrderFromFile = scanner.nextLine().split(",");

            String ordersUserId = getUserIdFrom(newOrderFromFile);

            if (userId.equals(ordersUserId)) {
                int id = getIdFrom(newOrderFromFile);
                String name = getNameFrom(newOrderFromFile);
                int price = getPriceFrom(newOrderFromFile);

                User ordersUser = fileSourceUserRepository.findById(ordersUserId);

                orders.add(new Order(id, name, price, ordersUser));
            }
        }

        scanner.close();
        return orders;
    }

    private int getIdFrom(String[] user) {
        return Integer.parseInt(user[0]);
    }

    private String getNameFrom(String[] user) {
        return user[1];
    }

    private int getPriceFrom(String[] user) {
        return Integer.parseInt(user[2]);
    }

    private String getUserIdFrom(String[] user) {
        return user[3];
    }

    private Scanner newScannerWithFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(
                    new File("/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/exam/exam2/files/orders.txt")
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        }
        return scanner;
    }
}
