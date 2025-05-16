import com.example.Animal;
import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    // Проверяем метод getFamily у класса Animal.
    // Проверяем, что метод возвращает правильное семейство животных.
    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }

    // Проверяем метод getFood у класса Animal на обработку исключения.
    // Проверяем, что при передаче некорректного значения вида животного возникает исключение с правильным сообщением.
    @Test
    public void testGetFoodException() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Неизвестный"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    // Проверяем метод getFood у класса Animal для травоядных.
    // Проверяем, что метод возвращает правильный список пищи для травоядных.
    // @throws Exception Если возникает ошибка при получении пищи
    @Test
    public void testGetFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    // Проверяем метод eatMeat у класса Feline.
    // Проверяем, что метод возвращает правильный список пищи для хищника.
    // @throws Exception Если возникает ошибка при получении пищи
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    // Проверяем метод getFood у класса Animal для хищников.
    // Проверяем, что метод возвращает правильный список пищи для хищников.
    // @throws Exception Если возникает ошибка при получении пищи
    @Test
    public void testGetFoodForCarnivore() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
