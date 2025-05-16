import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

     // Проверяем метод getFood у кота.
     // Проверяем, что метод возвращает правильный список пищи для хищника.
     // @throws Exception Если возникает ошибка при получении пищи
    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));

        Cat cat = new Cat(felineMock);
        List<String> food = cat.getFood();

        assertEquals(List.of("Мясо"), food);
    }


     // Проверяем метод getSound у кота.
     // Проверяем, что метод возвращает правильное звучание.
    @Test
    public void testGetSound() {
        Feline felineMock = Mockito.mock(Feline.class);

        Cat cat = new Cat(felineMock);
        String sound = cat.getSound();

        assertEquals("Мяу", sound);
    }


    // Дополнительная проверка взаимодействия кота с объектом Predator.
    // Проверяем, что кот корректно получает пищу через объект Feline.
    // @throws Exception Если возникает ошибка при получении пищи
    @Test
    public void testCatInteractsWithPredator() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));

        Cat cat = new Cat(felineMock);
        List<String> food = cat.getFood();

        assertEquals(List.of("Мясо"), food);
    }
}
