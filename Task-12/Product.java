// Product.java @Entity
public class Product {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
private String name; private double price; private int stock;
// Getters and Setters
}
// ProductController.java @RestController @RequestMapping("/api/products") public class ProductController {
@Autowired ProductRepository repo; @GetMapping
public ResponseEntity<List<Product>> getAllProducts() { return ResponseEntity.ok(repo.findAll());
}
@GetMapping("/{id}")
public ResponseEntity<Product> getProduct(@PathVariable Long id) { return repo.findById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}
@PostMapping
 
public ResponseEntity<Product> createProduct(@RequestBody @Valid Product p) { return ResponseEntity.status(201).body(repo.save(p));
}
@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product p) {
p.setId(id); return ResponseEntity.ok(repo.save(p));
}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteProduct(@PathVariable Long id) { repo.deleteById(id);
return ResponseEntity.ok("Product deleted");
}
}

