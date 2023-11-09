package CDK.Cookbook;

import java.io.Serializable;
import java.util.Objects;

public class Recipe_IngredientId implements Serializable {
    private Long recipe;

    private Long ingredient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe_IngredientId that = (Recipe_IngredientId) o;
        return Objects.equals(getRecipe(), that.getRecipe()) && Objects.equals(getIngredient(), that.getIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipe(), getIngredient());
    }

    public Long getRecipe() {
        return recipe;
    }

    public void setRecipe(Long recipe) {
        this.recipe = recipe;
    }

    public Long getIngredient() {
        return ingredient;
    }

    public void setIngredient(Long ingredient) {
        this.ingredient = ingredient;
    }
}
