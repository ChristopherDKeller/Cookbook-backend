package CDK.Cookbook;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "recipe_ingredient")
@IdClass(Recipe_IngredientId.class)
public class Recipe_Ingredient {

    @Id
    @ManyToOne
    @JoinColumn(name = "recepe_id")
    private Recipe recipe;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column
    private BigDecimal quantity;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

}
