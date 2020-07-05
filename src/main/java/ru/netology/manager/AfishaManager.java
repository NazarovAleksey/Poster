package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

@Data
@NoArgsConstructor
public class AfishaManager {
    private AfishaRepository repository;
    private int outputSize = 10;
    private int customOutputSize;

    public AfishaManager(AfishaRepository repository, int customOutputSize) {
        this.repository = repository;
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
        Movie[] result = new Movie[movies.length];

        if (customOutputSize == 0 & movies.length <= outputSize) {
            result = new Movie[movies.length];
        }
        if (customOutputSize == 0 & movies.length > outputSize) {
            result = new Movie[10];
        }
        if (customOutputSize != 0) {
            result = new Movie[customOutputSize];
        }
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}