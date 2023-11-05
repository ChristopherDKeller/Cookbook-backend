package CDK.Cookbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getAllTutorials(@RequestParam(required = false) String title) {
        return recipeService.getAll();
    }


}
