package CDK.Cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/ingredients")
    public List<Ingredient> getAll(@RequestParam(required = false) String title) {
        return ingredientService.getAll();
    }

    @PostMapping("/ingredients")
    public void create(@RequestBody Ingredient ingredient) {
        ingredientService.save(ingredient);
    }

    @DeleteMapping("/ingredients/delete/{id}")
    public void delete(@PathVariable Long id) {
        ingredientService.delete(id);
    }
}
