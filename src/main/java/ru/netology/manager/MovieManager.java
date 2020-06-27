package ru.netology.manager;


import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int outputSize = 10;

    public void addMovie(Movie movie) {
        int length = movies.length + 1;

        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        if (movies.length < outputSize) {
                outputSize = movies.length;
            }
        Movie[] resultMovie = new Movie[outputSize];
        for (int i = 0; i < resultMovie.length; i++) {
            int result = movies.length - i - 1;
            resultMovie[i] = movies[result];
        }
        return resultMovie;
    }
}