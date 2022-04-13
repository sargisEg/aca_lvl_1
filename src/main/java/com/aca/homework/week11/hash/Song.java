package com.aca.homework.week11.hash;

import java.util.Objects;

public class Song {

    private final Singer singer;
    private final String name;
    private final long duration;
    private final float rating;

    public Song(Singer singer, String name, long duration, float rating) {
        this.singer = singer;
        this.name = name;
        this.duration = duration;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof Song) {
            return Objects.equals(singer, ((Song) o).singer) &&
                    Objects.equals(name, ((Song) o).name) &&
                    duration == ((Song) o).duration;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = singer != null ? singer.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Long.hashCode(duration);
        return result;
    }
}
