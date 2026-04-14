// Product.java – Validation annotations public class Product {
@NotBlank(message = "Product name is required") private String name;
@Positive(message = "Price must be positive") private double price;
@Min(value = 0, message = "Stock cannot be negative") private int stock;
}
// GlobalExceptionHandler.java @ControllerAdvice
public class GlobalExceptionHandler { @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) { return ResponseEntity.status(404)
.body(new ErrorResponse(404, ex.getMessage()));
}
@ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,String>> handleValidation(
MethodArgumentNotValidException ex) { Map<String,String> errors = new HashMap<>(); ex.getBindingResult().getFieldErrors()
.forEach(e -> errors.put(e.getField(), e.getDefaultMessage())); return ResponseEntity.badRequest().body(errors);
}
}
