package ru.netology.manager;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;
    private int outputSize = 10;
    private int customOutputSize;

    public AfishaManager(AfishaRepository repository, int customOutputSize) {
        this.customOutputSize = customOutputSize;
    }

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        int length = movies.length;
        if (outputSize < length) {
            length = outputSize;
        }
        Movie[] resultMovie = new Movie[length];
        for (int i = 0; i < resultMovie.length; i++) {
            int index = movies.length - i - 1;
            resultMovie[i] = movies[index];
        }
        return resultMovie;
    }
}