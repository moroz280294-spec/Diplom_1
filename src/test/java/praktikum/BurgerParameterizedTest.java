package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private final IngredientType ingredientType;

    public BurgerParameterizedTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        });
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();

        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient = mock(Ingredient.class);

        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient.getPrice()).thenReturn(15.0f);
        when(mockIngredient.getType()).thenReturn(ingredientType);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        float expectedPrice = 100.0f * 2 + 15.0f;
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Test
    public void testReceiptContainsBunName() {
        Burger burger = new Burger();
        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient = mock(Ingredient.class);

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient.getType()).thenReturn(ingredientType);
        when(mockIngredient.getName()).thenReturn("hot sauce");
        when(mockIngredient.getPrice()).thenReturn(15.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();

        assertNotNull(receipt);
        assertTrue(receipt.contains("black bun"));
    }

    @Test
    public void testReceiptContainsIngredientName() {
        Burger burger = new Burger();
        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient = mock(Ingredient.class);

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient.getType()).thenReturn(ingredientType);
        when(mockIngredient.getName()).thenReturn("hot sauce");
        when(mockIngredient.getPrice()).thenReturn(15.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("hot sauce"));
    }

    @Test
    public void testReceiptContainsIngredientType() {
        Burger burger = new Burger();
        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient = mock(Ingredient.class);

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient.getType()).thenReturn(ingredientType);
        when(mockIngredient.getName()).thenReturn("hot sauce");
        when(mockIngredient.getPrice()).thenReturn(15.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains(ingredientType.toString().toLowerCase()));
    }

    @Test
    public void testReceiptContainsPriceLabel() {
        Burger burger = new Burger();
        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient = mock(Ingredient.class);

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient.getType()).thenReturn(ingredientType);
        when(mockIngredient.getName()).thenReturn("hot sauce");
        when(mockIngredient.getPrice()).thenReturn(15.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("Price:"));
    }

    @Test
    public void testReceiptContainsTotalPriceValue() {
        Burger burger = new Burger();
        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient = mock(Ingredient.class);

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100.0f);
        when(mockIngredient.getType()).thenReturn(ingredientType);
        when(mockIngredient.getName()).thenReturn("hot sauce");
        when(mockIngredient.getPrice()).thenReturn(15.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        assertTrue(burger.getReceipt().contains("215"));
    }
}


