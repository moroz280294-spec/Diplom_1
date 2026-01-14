package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BurgerTest {

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 100.0f);

        burger.setBuns(bun);

        assertNotNull(burger.bun);
        assertEquals("black bun", burger.bun.getName());
        assertEquals(100.0f, burger.bun.getPrice(), 0.01f);
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 15.0f);

        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 15.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "cutlet", 50.0f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 15.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "cutlet", 50.0f);
        Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "sour cream", 20.0f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);

        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(1));
        assertEquals(ingredient1, burger.ingredients.get(2));
    }
}

