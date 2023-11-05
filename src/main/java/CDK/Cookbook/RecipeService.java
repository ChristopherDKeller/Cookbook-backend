package CDK.Cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Recipe get(Long id) {
        return recipeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Recipe> getAll() {
        return new ArrayList<>(recipeRepository.findAll());
    }

    public void delete(Long id){
        recipeRepository.deleteById(id);
    }
}
