package magademo.maganorthwind.dataAccess.abstracts;

import magademo.maganorthwind.entities.concretes.Product;
import magademo.maganorthwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductDao extends JpaRepository<Product,Integer> {
    //interface interfac i extends eder
    //CRUD işlem leri için
    Product getByProductName(String productName);

    Product getByProductNameAndCategory(String productName,int categoryId);

    List<Product> getByProductNameOrCategory(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartingWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> GetByNameAndCategory(String productName,int categoryId);


    //join işlemi
    //bu query dB de bu işlemi yapar-> select p.product_id,p.product_name,c.category_name from categories c inner join products p on c.category_id=p.category_id
    @Query("Select new magademo.maganorthwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c inner Join c.products p ")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();


}
