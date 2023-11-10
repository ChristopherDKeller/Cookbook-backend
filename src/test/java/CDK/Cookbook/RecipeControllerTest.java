package CDK.Cookbook;

import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService service;

    @Test
    public void getRecipeTest() throws Exception {

        Recipe r1 = new Recipe();
        r1.setId(1L);
        r1.setTitle("Eierkuchen");
        r1.setDescription("Eierkuchen mit Mehl und Milch");
        r1.setInstructions("Alles zusammenrühren und in die Pfanne geben");
        r1.setServings(4);
        r1.setTime(20);
        when(service.get(1L)).thenReturn(r1);

        this.mockMvc.perform(get("/recipes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"title\":\"Eierkuchen\",\"description\":\"Eierkuchen mit Mehl und Milch\",\"instructions\":\"Alles zusammenrühren und in die Pfanne geben\",\"servings\":4,\"time\":20}"));
    }
    @Test
    public void getAllRecipesTest() throws Exception{
        Recipe r1 = new Recipe();
        r1.setId(1L);
        r1.setTitle("Eierkuchen");
        r1.setDescription("Eierkuchen mit Mehl und Milch");
        r1.setInstructions("Alles zusammenrühren und in die Pfanne geben");
        r1.setServings(4);
        r1.setTime(20);

        Recipe r2 = new Recipe();
        r2.setId(2L);
        r2.setTitle("Spaghetti");
        r2.setDescription("Spaghetti mit Tomatensoße");
        r2.setInstructions("Spaghetti kochen und Soße kochen");
        r2.setServings(4);
        r2.setTime(30);

        when(service.getAll()).thenReturn(List.of(r1,r2));

        this.mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":1,\"title\":\"Eierkuchen\",\"description\":\"Eierkuchen mit Mehl und Milch\",\"instructions\":\"Alles zusammenrühren und in die Pfanne geben\",\"servings\":4,\"time\":20},{\"id\":2,\"title\":\"Spaghetti\",\"description\":\"Spaghetti mit Tomatensoße\",\"instructions\":\"Spaghetti kochen und Soße kochen\",\"servings\":4,\"time\":30}]"));
    }

    @Test
    public void deleteRecipeTest() throws Exception {
        Recipe r1 = new Recipe();
        r1.setId(1L);
        r1.setTitle("Eierkuchen");
        r1.setDescription("Eierkuchen mit Mehl und Milch");
        r1.setInstructions("Alles zusammenrühren und in die Pfanne geben");
        r1.setServings(4);
        r1.setTime(20);

        when(service.get(1L)).thenReturn(r1);

        this.mockMvc.perform(get("/recipes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"title\":\"Eierkuchen\",\"description\":\"Eierkuchen mit Mehl und Milch\",\"instructions\":\"Alles zusammenrühren und in die Pfanne geben\",\"servings\":4,\"time\":20}"));

        this.mockMvc.perform(delete("/recipes/delete/1"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void createRecipeTest() throws Exception {
        Recipe r1 = new Recipe();
        r1.setId(1L);
        r1.setTitle("Eierkuchen");
        r1.setDescription("Eierkuchen mit Mehl und Milch");
        r1.setInstructions("Alles zusammenrühren und in die Pfanne geben");
        r1.setServings(4);
        r1.setTime(20);

        doNothing().when(service).save(Mockito.any(Recipe.class));

        this.mockMvc.perform(post("/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Eierkuchen\",\"description\":\"Eierkuchen mit Mehl und Milch\",\"instructions\":\"Alles zusammenrÃ¼hren und in die Pfanne geben\",\"servings\":4,\"time\":20}"))
                .andExpect(status().isOk());
    }
}
