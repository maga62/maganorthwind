package magademo.maganorthwind.api.conrollers;

import magademo.maganorthwind.bussines.abstracts.ProductService;
import magademo.maganorthwind.core.utilities.results.DataResult;
import magademo.maganorthwind.core.utilities.results.Result;
import magademo.maganorthwind.entities.concretes.Product;
import magademo.maganorthwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>>  getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>>  getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product>getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getByProductNameOrCategory")
    public DataResult <List<Product>> getByProductNameOrCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
        return this.productService.getByProductNameOrCategory(productName,categoryId);
    }

    @GetMapping("/getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategoryIn(categories);
    }


    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return  this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartingWith")
    public DataResult<List<Product>> getByProductNameStartingWith(@RequestParam String productName){
        return this.productService.getByProductNameStartingWith(productName);
    }

    @GetMapping("/GetByNameAndCategory")
    public DataResult<List<Product>> GetByNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.GetByNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllSortedDesc")
    public DataResult<List<Product>> getAllSorted(){
        return  this.productService.getAllSorted();
    }

}
