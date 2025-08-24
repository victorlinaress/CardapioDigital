package Controller;

import Entitys.Food;
import Entitys.FoodRequestDTO;
import Entitys.FoodResponseDTO;
import Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData); //salva no banco de dados
        return;

    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){//pega todas as comidas do banco

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();// converte para FoodResponse
        return foodList;

    }
}
