package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager afishaManager = new AfishaManager(repository);

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
        Movie[] returned = new Movie[]{first};
        doReturn(returned).when(repository).findAll();

        afishaManager.addMovie(first);
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, afishaManager.getAll());
        verify(repository).save(any());
        verify(repository).findAll();
     }

    @Test
    public void tenMovies() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, afishaManager.getAll());
        verify(repository).findAll();
    }

    @Test
    public void lessTenMovies() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, afishaManager.getAll());
        verify(repository).findAll();
    }

    @Test
    public void moreTenMovies() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, afishaManager.getAll());
        verify(repository).findAll();
    }

    @Test
    public void customOutputSize() {
        AfishaManager manager = new AfishaManager(repository, 5);
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, afishaManager.getAll());
        verify(repository).findAll();
    }
}