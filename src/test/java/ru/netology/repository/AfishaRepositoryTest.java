package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();
    Movie first = new Movie(1, "Бладшот", "Боевик", "ссылка на картинку");
    Movie second = new Movie(2, "Вперёд", "Мультфильм", "ссылка на картинку");
    Movie third = new Movie(3, "Отель Белград", "Комедия", "ссылка на картинку");
    Movie fourth = new Movie(4, "Джентельмены", "Боевик", "ссылка на картинку");
    Movie fifth = new Movie(5, "Человек-невидимка", "Ужасы", "ссылка на картинку");
    Movie sixth = new Movie(6, "Тролли. Мировой тур", "Мультфильм", "ссылка на картинку");
    Movie seventh = new Movie(7, "Номер один", "Комедия", "ссылка на картинку");
    Movie eighth = new Movie(8, "Невидимый гость", "Триллер", "ссылка на картинку");
    Movie ninth = new Movie(9, "Сердце из стали", "Фантастика", "ссылка на картинку");
    Movie tenth = new Movie(10, "Балканский рубеж", "Боевик", "ссылка на картинку");
    Movie eleventh  = new Movie(11, "Поезд в Пусан", "Боевик", "ссылка на картинку");

    @BeforeEach
    public void sutUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);
    }

    @Test
    void shouldFindAll() {
        repository.findAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSave() {
        Movie twelve = new Movie(12, "Боги Египта", "Фэнтези", "ссылка на картинку");
        repository.save(twelve);
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindById() {
        Movie expected = new Movie(3, "Отель Белград", "Комедия", "ссылка на картинку");
        assertEquals(expected, repository.findById(3));
    }

    @Test
    void shouldFindInvalidId() {
        assertNull(repository.findById(12));
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);

        Movie[] expected = new Movie[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, repository.findAll());
    }
}