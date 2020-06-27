package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerTest {
    MovieManager movieManager = new MovieManager();
    private Movie first = new Movie(1, "Бладшот", "Боевик", "ссылка на картинку");
    private Movie second = new Movie(2, "Вперёд", "Мультфильм", "ссылка на картинку");
    private Movie third = new Movie(3, "Отель Белград", "Комедия", "ссылка на картинку");
    private Movie fourth = new Movie(4, "Джентельмены", "Боевик", "ссылка на картинку");
    private Movie fifth = new Movie(5, "Человек-невидимка", "Ужасы", "ссылка на картинку");
    private Movie sixth = new Movie(6, "Тролли. Мировой тур", "Мультфильм", "ссылка на картинку");
    private Movie seventh = new Movie(7, "Номер один", "Комедия", "ссылка на картинку");
    private Movie eighth = new Movie(8, "Невидимый гость", "Триллер", "ссылка на картинку");
    private Movie ninth = new Movie(9, "Сердце из стали", "Фантастика", "ссылка на картинку");
    private Movie tenth = new Movie(10, "Балканский рубеж", "Боевик", "ссылка на картинку");
    private Movie eleventh  = new Movie(11, "Поезд в Пусан", "Боевик", "ссылка на картинку");

    @Test
    void addMovie() {
        Movie twelve = new Movie(12, "Боги Египта", "Фэнтези", "ссылка на картинку");
        movieManager.addMovie(twelve);

        Movie[] expected = new Movie[]{twelve};

        assertArrayEquals(expected, movieManager.getAll());
    }

    @Test
    public void tenMovies() {
        movieManager.addMovie(first);
        movieManager.addMovie(second);
        movieManager.addMovie(third);
        movieManager.addMovie(fourth);
        movieManager.addMovie(fifth);
        movieManager.addMovie(sixth);
        movieManager.addMovie(seventh);
        movieManager.addMovie(eighth);
        movieManager.addMovie(ninth);
        movieManager.addMovie(tenth);

        movieManager.getAll();

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth,third,second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void lessTenMovies() {
        movieManager.addMovie(first);
        movieManager.addMovie(second);
        movieManager.addMovie(third);
        movieManager.addMovie(fourth);
        movieManager.addMovie(fifth);
        movieManager.addMovie(sixth);

        Movie[] expected = new Movie[]{sixth, fifth, fourth,third,second, first};

        assertArrayEquals(expected, movieManager.getAll());
    }

    @Test
    public void moreTenMovies() {
        movieManager.addMovie(first);
        movieManager.addMovie(second);
        movieManager.addMovie(third);
        movieManager.addMovie(fourth);
        movieManager.addMovie(fifth);
        movieManager.addMovie(sixth);
        movieManager.addMovie(seventh);
        movieManager.addMovie(eighth);
        movieManager.addMovie(ninth);
        movieManager.addMovie(tenth);
        movieManager.addMovie(eleventh);

        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth,third,second};

        assertArrayEquals(expected, movieManager.getAll());
    }
}