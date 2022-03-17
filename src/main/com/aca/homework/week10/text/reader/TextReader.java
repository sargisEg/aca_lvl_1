package com.aca.homework.week10.text.reader;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextReader {

    public static List<String> readLines() throws FileNotFoundException {
        List<String> lines = new LinkedList<>();

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
        Iterator<E> itr = list.iterator();
        int i = 0;
        while (itr.hasNext()) {
            System.out.println(i + ": " + itr.next());
            i++;
        }
    }

}
