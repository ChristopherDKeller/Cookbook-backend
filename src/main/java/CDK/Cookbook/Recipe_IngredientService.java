package CDK.Cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Recipe_IngredientService {

    @Autowired
    Recipe_IngredientRepository recipe_ingredientRepository;

    public void save(Recipe_Ingredient recipe_ingredient){
        recipe_ingredientRepository.save(recipe_ingredient);
    }

    public Recipe_Ingredient get(Long recipe_id, Long ingredient_id) {
        return recipe_ingredientRepository.findByRecipeIdAndIngredientId(recipe_id,ingredient_id).orElseThrow(RuntimeException::new);
    }

    public List<Recipe_Ingredient> getAll() {
        return new ArrayList<>(recipe_ingredientRepository.findAll());
    }

    public void delete(Long recipe_id, Long ingredient_id){
        recipe_ingredientRepository.deleteByRecipeIdAndIngredientId(recipe_id,ingredient_id);
    }
}
