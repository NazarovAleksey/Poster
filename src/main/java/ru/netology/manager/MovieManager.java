package ru.netology.manager;


import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int outputSize = 10;
    private int customOutputSize;

    public MovieManager(int customOutputSize) {
        this.customOutputSize = customOutputSize;
        }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;

        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() {
        Movie[] resultMovie = new Movie[0];
        if (customOutputSize == 0 & movies.length <= outputSize) {
            resultMovie = new Movie[movies.length];
        }
        if (customOutputSize == 0 & movies.length > outputSize) {
            resultMovie = new Movie[outputSize];
        }
        if (customOutputSize != 0) {
            resultMovie = new Movie[customOutputSize];
        }
        for (int i = 0; i < resultMovie.length; i++) {
            int index = movies.length - i - 1;
            resultMovie[i] = movies[index];
        }
        return resultMovie;
    }
}