package guru.spring.swagger.api.v1.controllers;

import guru.spring.swagger.api.v1.model.CategoryDTO;
import guru.spring.swagger.api.v1.model.CategoryListDTO;
import guru.spring.swagger.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CategoryRestController.BASE_URL)
public class CategoryRestController {

    public static final String BASE_URL = "/api/v1/categoriesrest";

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories(){
        return new CategoryListDTO(categoryService.getAllCategories());
    }
    /*
    public ResponseEntity<CategoryListDTO> getAllCategories(){

        return new ResponseEntity<CategoryListDTO>(
                new CategoryListDTO(
                        categoryService.getAllCategories()),
                HttpStatus.OK
        );
    }
    */


    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
/*
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name){
        return new ResponseEntity<CategoryDTO>(
                    categoryService.getCategoryByName(name),
                    HttpStatus.OK
                );
    }
*/
}
