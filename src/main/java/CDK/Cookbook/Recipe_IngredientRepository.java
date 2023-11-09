package CDK.Cookbook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Recipe_IngredientRepository extends JpaRepository<Recipe_Ingredient, Long> {
    Optional<Recipe_Ingredient> findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    void deleteByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
