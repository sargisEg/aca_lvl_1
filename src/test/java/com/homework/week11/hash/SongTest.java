package com.homework.week11.hash;

import com.aca.homework.week11.hash.Singer;
import com.aca.homework.week11.hash.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SongTest {

    @Test
    public void testHashCodeIfEquals() {
        Singer testSinger = new Singer("first", "last");
        Song testSong1 = new Song(testSinger, "Name", 165, 4.5f);
        Song testSong2 = new Song(testSinger, "Name", 165, 4.5f);

        Assertions.assertEquals(testSong1, testSong2);
        Assertions.assertEquals(testSong1.hashCode(), testSong2.hashCode());
    }
}