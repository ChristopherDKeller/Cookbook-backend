package CDK.Cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getAll(@RequestParam(required = false) String title) {
        return recipeService.getAll();
    }

    @PostMapping("/recipes")
    public void create(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
    }

    @DeleteMapping("/recipes/delete/{id}")
    public void delete(@PathVariable Long id) {
        recipeService.delete(id);
    }
}
