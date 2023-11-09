package CDK.Cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public void save(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }

    public Ingredient get(Long id) {
        return ingredientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Ingredient> getAll() {
        return new ArrayList<>(ingredientRepository.findAll());
    }

    public void delete(Long id){
        ingredientRepository.deleteById(id);
    }
}
