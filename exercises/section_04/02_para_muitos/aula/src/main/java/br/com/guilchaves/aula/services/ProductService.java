package br.com.guilchaves.aula.services;

import br.com.guilchaves.aula.dto.CategoryDTO;
import br.com.guilchaves.aula.dto.ProductDTO;
import br.com.guilchaves.aula.entities.Category;
import br.com.guilchaves.aula.entities.Product;
import br.com.guilchaves.aula.repositories.CategoryRepository;
import br.com.guilchaves.aula.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for (CategoryDTO e : dto.getCategories()) {
            // Category category = new Category();
            // category.setId(e.getId());
            Category category = categoryRepository.getReferenceById(e.getId());
            entity.getCategories().add(category);
        }

        entity = repository.save(entity);
        return new ProductDTO(entity);
    }
}
