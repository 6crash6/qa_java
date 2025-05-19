import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FelineTest {


     // Проверяем методы setKittens и getKittens
     // Проверяем корректность установки и получения количества котят

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testGetKittens(int expectedKittens) {
        Feline feline = new Feline();
        feline.setKittens(expectedKittens);
        int kittens = feline.getKittens();
        assertEquals(expectedKittens, kittens);
    }


     // Проверяем метод getFood для разных типов животных
     // Проверяем корректность получения списка пищи для хищников и травоядных
    @ParameterizedTest
    @ValueSource(strings = {"Хищник", "Травоядное"})
    public void testGetFood(String animalKind) throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood(animalKind);

        if ("Хищник".equals(animalKind)) {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        } else if ("Травоядное".equals(animalKind)) {
            assertEquals(List.of("Трава", "Различные растения"), food);
        }
    }


     // Проверяем метод getFamily в классе Feline
     // Проверяем, что возвращается правильное семейство
    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }


     // Проверяем обработку исключения в методе setKittens
     // Проверяем передачу отрицательного числа
    @Test
    public void testSetKittensException() {
        Feline feline = new Feline();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> feline.setKittens(-1));
        assertEquals("Количество котят не может быть отрицательным", exception.getMessage());
    }


     // Проверяем обработку исключения в методе getFood
     // Проверяем передачу неизвестного типа животного
    @Test
    public void testGetFoodException() {
        Feline feline = new Feline();
        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестный"));
        assertEquals("Неизвестный тип животного", exception.getMessage());
    }
}
