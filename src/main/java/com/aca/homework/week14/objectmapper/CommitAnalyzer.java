package com.aca.homework.week14.objectmapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CommitAnalyzer {

    private final static String PATH = "./src/main/java/com/aca/homework/week14/objectmapper/";
    private final String fileName;

    public CommitAnalyzer(String fileName) {
        this.fileName = fileName;
    }

    public int count() {
        final int[] count = {0};
        List<CommitsPerWeek> commitsPerWeekList = getListFromFile();
        commitsPerWeekList.forEach(commitsPerWeek -> {
            count[0] += commitsPerWeek.getTotal();
        });

        return count[0];
    }

    private List<CommitsPerWeek> getListFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CommitsPerWeek> commits = null;
        try {
            commits = objectMapper.readValue(
                    new File(PATH + fileName),
                    new TypeReference<List<CommitsPerWeek>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return commits == null ? Collections.emptyList() : commits;
    }
}
