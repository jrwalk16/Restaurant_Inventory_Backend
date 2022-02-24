package com.example.inventory.service;
import com.example.inventory.exceptions.InformationExistException;
import com.example.inventory.model.Ingredient;
import com.example.inventory.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient createIngredient(Ingredient ingredientObject){
        Ingredient ingredient = ingredientRepository.findByIngredientName(ingredientObject.getIngredientName());
        if(ingredient != null){
            throw new InformationExistException("ingredient with name " + ingredient.getIngredientName() + "already exists");
        } else {
            return ingredientRepository.save(ingredientObject);
        }
    }
}
