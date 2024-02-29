package com.fiqrikm18.implemetation_test_1.presentation;

import com.fiqrikm18.implemetation_test_1.annotations.ApiController;
import com.fiqrikm18.implemetation_test_1.domain.admin.order.Order;
import com.fiqrikm18.implemetation_test_1.domain.admin.order.OrderStatus;
import com.fiqrikm18.implemetation_test_1.domain.admin.product.ProductResponse;
import com.fiqrikm18.implemetation_test_1.domain.order.OrderRequest;
import com.fiqrikm18.implemetation_test_1.domain.order.OrderResponse;
import com.fiqrikm18.implemetation_test_1.domain.order.OrderService;
import com.fiqrikm18.implemetation_test_1.exceptions.RestResponseEntityExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@ApiController
@Tag(name = "Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Crate order data")
    @ApiResponses(value = {
            @ApiResponse(description = "Create order data success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            ))
    })
    @RequestMapping(value = "order", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderResponse> createOrder(@RequestBody List<OrderRequest> request) {
        Order order = orderService.saveOrder(request);
        return new ResponseEntity<>(OrderResponse.fromOrder(order), HttpStatus.OK);
    }

}
