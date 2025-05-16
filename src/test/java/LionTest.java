import com.example.Lion;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LionTest {

    // Проверяем метод getFood у льва.
    // Проверяем, что метод возвращает правильный список пищи для хищника.
    // @throws Exception Если возникает ошибка при получении пищи
    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    // Проверяем метод doesHaveMane у льва.
    // Проверяем, что у самца льва есть грива, а у самки - нет.
    // @throws Exception Если возникает ошибка при создании льва
    @Test
    public void testDoesHaveMane() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);

        Lion lionMale = new Lion("Самец", felineMock);
        assertTrue(lionMale.doesHaveMane());

        Lion lionFemale = new Lion("Самка", felineMock);
        assertFalse(lionFemale.doesHaveMane());
    }

    // Проверяем метод getKittens у льва.
    // Проверяем, что метод возвращает правильное количество котят.
    // @throws Exception Если возникает ошибка при получении количества котят
    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);
        int kittens = lion.getKittens();

        assertEquals(3, kittens);
    }

    // Проверяем конструктор Lion на обработку исключения при некорректном поле.
    // Проверяем, что при передаче некорректного пола возникает исключение с правильным сообщением.
    @Test
    public void testLionConstructorException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Некорректный пол", new Feline()));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    // Проверяем метод getFamily у льва.
    // Проверяем, что метод корректно возвращает семейство "Кошачьи"
    @Test
    public void testGetFamily() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getFamily()).thenReturn("Кошачьи");

        Lion lion = new Lion("Самец", felineMock);
        assertEquals("Кошачьи", lion.getFamily());
    }

    // Проверяем конструктор Lion с валидным объектом Feline.
    // Проверяем, что конструктор успешно создает экземпляр Lion
    @Test
    public void testConstructorWithValidFeline() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        assertNotNull(lion);
    }

    // Проверяем метод getKittens с нулевым значением.
    // Проверяем корректную обработку случая с нулевым количеством котят
    @Test
    public void testGetKittensWithZero() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(0);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(0, lion.getKittens());
    }

    // Проверяем метод getKittens с отрицательным значением.
    // Проверяем корректную обработку отрицательного значения
    @Test
    public void testGetKittensWithNegative() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(-1);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(-1, lion.getKittens());
    }

    // Проверяем конструктор Lion с null значением пола.
    // Проверяем, что при null значении пола возникает исключение
    @Test
    public void testConstructorWithNullSex() {
        assertThrows(Exception.class, () -> new Lion(null, new Feline()));
    }

    // Проверяем конструктор Lion с пустым значением пола.
    // Проверяем, что при пустой строке пола возникает исключение
    @Test
    public void testConstructorWithEmptySex() {
        assertThrows(Exception.class, () -> new Lion("", new Feline()));
    }

    // Проверяем конструктор Lion с неправильным регистром пола.
    // Проверяем, что при неверном регистре значения пола возникает исключение
    @Test
    public void testConstructorWithDifferentCase() {
        assertThrows(Exception.class, () -> new Lion("самец", new Feline()));
    }

    // Проверяем конструктор Lion с null значением Feline.
    // Проверяем, что при null значении Feline возникает NullPointerException
    @Test
    public void testConstructorWithNullFeline() {
        assertThrows(NullPointerException.class, () -> new Lion("Самец", null));
    }

    // Проверяем метод getFood с пустым списком.
    // Проверяем корректную обработку случая с пустым списком пищи
    @Test
    public void testGetFoodWithEmptyList() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of());

        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.getFood().isEmpty());
    }

    // Проверяем метод getFood на обработку исключения.
    // Проверяем, что метод корректно обрабатывает исключение при получении пищи
    @Test
    public void testGetFoodException() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getFood("Хищник"))
                .thenThrow(new Exception("Ошибка получения пищи"));

        Lion lion = new Lion("Самец", felineMock);
        assertThrows(Exception.class, lion::getFood);
    }

}
