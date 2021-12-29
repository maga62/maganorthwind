package magademo.maganorthwind.bussines.abstracts;

import magademo.maganorthwind.core.utilities.results.DataResult;
import magademo.maganorthwind.core.utilities.results.Result;
import magademo.maganorthwind.entities.concretes.Product;
import magademo.maganorthwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllSorted();
    DataResult<List<Product>> getAll(int pageNo,int pageSize);
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartingWith(String productName);

    DataResult<List<Product>> GetByNameAndCategory(String productName,int categoryId);

    DataResult<List<ProductWithCategoryDto> >getProductWithCategoryDetails();
}
