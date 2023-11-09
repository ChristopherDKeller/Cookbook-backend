package CDK.Cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Recipe_IngredientController {
    @Autowired
    Recipe_IngredientService recipe_ingredientService;

    @GetMapping("/recipe_ingredients")
    public List<Recipe_Ingredient> getAll() {
        return recipe_ingredientService.getAll();
    }

    @PostMapping("/recipe_ingredients")
    public void create(@RequestBody Recipe_Ingredient recipe_ingredient) {
        recipe_ingredientService.save(recipe_ingredient);
    }

    @DeleteMapping("/recipe_ingredients/delete/{recipeId}/{ingredientId}")
    public void delete(@PathVariable Long recipeId,@PathVariable Long ingredientId) {
        recipe_ingredientService.delete(recipeId,ingredientId);
    }
}
