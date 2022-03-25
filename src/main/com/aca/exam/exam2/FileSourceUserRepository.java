package com.aca.exam.exam2;

import com.aca.exam.exam2.annotations.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Repository
public class FileSourceUserRepository implements CrudRepository<User, String> {

    private static final FileSourceUserRepository userRepository = new FileSourceUserRepository();

    private FileSourceUserRepository() {
    }

    public static FileSourceUserRepository getInstance() {
        return userRepository;
    }

    @Override
    public User findById(String s) {
        Scanner scanner = newScannerWithFile();

        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] newUserFromFile = scanner.nextLine().split(",");

            String id = getIdFrom(newUserFromFile);
            if (id.equals(s)) {
                String firstName = getFirstNameFrom(newUserFromFile);
                String lastName = getLastNameFrom(newUserFromFile);

                return new User(id, firstName, lastName);
            }
        }

        scanner.close();
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new LinkedList<>();

        Scanner scanner = newScannerWithFile();

        scanner.nextLine();
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] newUserFromFile = scanner.nextLine().split(",");

            String id = getIdFrom(newUserFromFile);
            String firstName = getFirstNameFrom(newUserFromFile);
            String lastName = getLastNameFrom(newUserFromFile);

            users.add(new User(id, firstName, lastName));
        }

        scanner.close();
        return users;
    }

    private String getIdFrom(String[] user) {
        return user[0];
    }

    private String getFirstNameFrom(String[] user) {
        return user[1];
    }

    private String getLastNameFrom(String[] user) {
        return user[2];
    }

    private Scanner newScannerWithFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(
                    new File("/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/exam/exam2/files/users.txt")
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        }
        return scanner;
    }
}
