package CDK.Cookbook;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Recipe_IngredientController.class)
public class Recipe_IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Recipe_IngredientService service;

    @Test
    public void getRecipeIngredientTest() throws Exception {
        Recipe_Ingredient ri = new Recipe_Ingredient();
        ri.setRecipe(new Recipe());
        ri.getRecipe().setId(1L);
        ri.setIngredient(new Ingredient());
        ri.getIngredient().setId(2L);
        ri.setQuantity(BigDecimal.TEN);

        when(service.get(1L, 2L)).thenReturn(ri);

        this.mockMvc.perform(get("/recipe_ingredients/1/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"recipe\":{\"id\":1},\"ingredient\":{\"id\":2},\"quantity\":10}"));
    }

    @Test
    public void getAllRecipeIngredientsTest() throws Exception {
        Recipe_Ingredient ri1 = new Recipe_Ingredient();
        ri1.setRecipe(new Recipe());
        ri1.getRecipe().setId(1L);
        ri1.setIngredient(new Ingredient());
        ri1.getIngredient().setId(2L);
        ri1.setQuantity(BigDecimal.TEN);

        Recipe_Ingredient ri2 = new Recipe_Ingredient();
        ri2.setRecipe(new Recipe());
        ri2.getRecipe().setId(3L);
        ri2.setIngredient(new Ingredient());
        ri2.getIngredient().setId(4L);
        ri2.setQuantity(BigDecimal.valueOf(5));

        when(service.getAll()).thenReturn(List.of(ri1, ri2));

        this.mockMvc.perform(get("/recipe_ingredients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"recipe\":{\"id\":1},\"ingredient\":{\"id\":2},\"quantity\":10}," +
                        "{\"recipe\":{\"id\":3},\"ingredient\":{\"id\":4},\"quantity\":5}]"));
    }

    @Test
    public void deleteRecipeIngredientTest() throws Exception {
        Recipe_Ingredient ri = new Recipe_Ingredient();
        ri.setRecipe(new Recipe());
        ri.getRecipe().setId(1L);
        ri.setIngredient(new Ingredient());
        ri.getIngredient().setId(2L);
        ri.setQuantity(BigDecimal.TEN);

        when(service.get(1L, 2L)).thenReturn(ri);

        this.mockMvc.perform(get("/recipe_ingredients/1/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"recipe\":{\"id\":1},\"ingredient\":{\"id\":2},\"quantity\":10}"));

        this.mockMvc.perform(delete("/recipe_ingredients/delete/1/2"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/recipe_ingredients"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void createRecipeIngredientTest() throws Exception {
        Recipe_Ingredient ri = new Recipe_Ingredient();
        ri.setRecipe(new Recipe());
        ri.setIngredient(new Ingredient());
        ri.setQuantity(BigDecimal.TEN);

        doNothing().when(service).save(Mockito.any(Recipe_Ingredient.class));

        this.mockMvc.perform(post("/recipe_ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"recipe\":{\"id\":1},\"ingredient\":{\"id\":2},\"quantity\":10}"))
                .andExpect(status().isOk());
    }
}

