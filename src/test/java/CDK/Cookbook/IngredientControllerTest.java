package CDK.Cookbook;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IngredientController.class)
class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService service;

    @Test
    public void getIngredientTest() throws Exception{

        Ingredient i1 = new Ingredient();
        i1.setId(1L);
        i1.setName("Eier");
        i1.setUnit("pcs");
        when(service.get(1L)).thenReturn(i1);

        this.mockMvc.perform(get("/ingredients/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"Eier\",\"unit\":\"pcs\"}"));
    }

    @Test
    public void getAllIngredientTest() throws Exception{
        Ingredient i1 = new Ingredient();
        i1.setId(1L);
        i1.setName("Eier");
        i1.setUnit("pcs");

        Ingredient i2 = new Ingredient();
        i2.setId(2L);
        i2.setName("Mehl");
        i2.setUnit("g");
        when(service.getAll()).thenReturn(List.of(i1,i2));

        this.mockMvc.perform(get("/ingredients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":1,\"name\":\"Eier\",\"unit\":\"pcs\"},{\"id\":2,\"name\":\"Mehl\",\"unit\":\"g\"}]"));
    }

    @Test
    public void deleteIngredientTest() throws Exception {
        Ingredient i1 = new Ingredient();
        i1.setId(1L);
        i1.setName("Eier");
        i1.setUnit("pcs");

        when(service.get(1L)).thenReturn(i1);

        this.mockMvc.perform(get("/ingredients/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"Eier\",\"unit\":\"pcs\"}"));

        this.mockMvc.perform(delete("/ingredients/delete/1"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/ingredients"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }


    @Test
    public void createIngredientTest() throws Exception {
        Ingredient i1 = new Ingredient();
        i1.setId(1L);
        i1.setName("Eier");
        i1.setUnit("pcs");

        doNothing().when(service).save(Mockito.any(Ingredient.class));

        this.mockMvc.perform(post("/ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Eier\",\"unit\":\"pcs\"}"))
                .andExpect(status().isOk());
    }

}

