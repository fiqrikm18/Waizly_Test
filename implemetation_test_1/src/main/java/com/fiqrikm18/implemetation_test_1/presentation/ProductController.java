package com.fiqrikm18.implemetation_test_1.presentation;

import com.fiqrikm18.implemetation_test_1.annotations.ApiController;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.Product;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.ProductResponse;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.ProductService;
import com.fiqrikm18.implemetation_test_1.exceptions.RestResponseEntityExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@ApiController
@Tag(name = "Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get product data")
    @ApiResponses(value = {
            @ApiResponse(description = "Get product data success", responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductResponse.class)))),
            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            ))
    })
    @RequestMapping(value = "product", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        return new ResponseEntity<>(ProductResponse.fromListProduct(productService.findAll()), HttpStatus.OK);
    }

    @Operation(summary = "Get product data by id")
    @ApiResponses(value = {
            @ApiResponse(description = "Get product data success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(description = "Showcase data not found", responseCode = "404", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            )),
            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            ))
    })
    @RequestMapping(value = "product/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(ProductResponse.fromProduct(product), HttpStatus.OK);
    }

}
