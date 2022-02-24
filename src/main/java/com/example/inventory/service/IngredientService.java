package com.example.inventory.service;
import com.example.inventory.exceptions.InformationExistException;
import com.example.inventory.exceptions.InformationNotFoundException;
import com.example.inventory.model.Ingredient;
import com.example.inventory.repository.IngredientRepository;
import com.example.inventory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;


    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }



    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient createIngredient(Ingredient ingredientObject){
        Ingredient ingredient = ingredientRepository.findByIngredientName(ingredientObject.getIngredientName());
        if(ingredient != null){
            throw new InformationExistException("ingredient with name " + ingredient.getIngredientName() + "already exists");
        } else {
            return ingredientRepository.save(ingredientObject);
        }
    }

    public Optional<Ingredient> getIngredient(Long ingredientId){
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);
        if(ingredient.isPresent()){
            return ingredient;
        } else {
            throw new InformationNotFoundException("ingredient with id " + ingredientId + " doesnt exist");
        }
    }
}
