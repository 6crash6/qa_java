import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {
    private Feline felineMock;
    private Cat cat;
    private List<String> expectedFood;

    @BeforeEach
    void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
        expectedFood = List.of("Мясо");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        cat = new Cat(felineMock);
    }

    // Проверяем метод getFood у кота
    @Test
    public void testGetFood() throws Exception {
        List<String> food = cat.getFood();
        assertEquals(expectedFood, food);
    }

    // Проверяем метод getSound у кота
    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    // Дополнительная проверка взаимодействия кота с объектом Predator
    @Test
    public void testCatInteractsWithPredator() throws Exception {
        List<String> food = cat.getFood();
        assertEquals(expectedFood, food);
    }
}
