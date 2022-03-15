package com.aca.homework.week10.text.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextReader {

    public static List<String> readLines() throws FileNotFoundException {
        List<String> lines = new ArrayList<>(1000);

        Scanner scanner = new Scanner(
                new File("/home/sargise/Desktop/Java/aca_lvl_1_/src/main/com/aca/homework/week10/text/reader/doc-numbers.txt"
                ));
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }

    public static <E> void print (List<E> list) {
        for (E e : list) {
            System.out.println(list.indexOf(e) + ": " + e);
        }
    }
}
