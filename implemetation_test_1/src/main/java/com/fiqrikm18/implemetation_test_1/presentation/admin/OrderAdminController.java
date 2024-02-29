package com.fiqrikm18.implemetation_test_1.presentation.admin;

import com.fiqrikm18.implemetation_test_1.annotations.AdminController;
import com.fiqrikm18.implemetation_test_1.domain.admin.order.Order;
import com.fiqrikm18.implemetation_test_1.domain.order.OrderResponse;
import com.fiqrikm18.implemetation_test_1.domain.order.OrderService;
import com.fiqrikm18.implemetation_test_1.domain.order.OrderStatusRequest;
import com.fiqrikm18.implemetation_test_1.exceptions.RestResponseEntityExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@AdminController
@Tag(name = "Order (Admin)")
@SecurityRequirement(name = "Basic Auth")
public class OrderAdminController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Get order data")
    @ApiResponses(value = {
            @ApiResponse(description = "Get order data success", responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderResponse.class)))),
            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            ))
    })
    @RequestMapping(value = "order", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<OrderResponse>> getAllOrder() {
        return new ResponseEntity<>(OrderResponse.fromListOrder(orderService.getAllOrder()), HttpStatus.OK);
    }

    @Operation(summary = "Get order data by id")
    @ApiResponses(value = {
            @ApiResponse(description = "Get order data success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            ))
    })
    @RequestMapping(value = "order/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id) {
        return new ResponseEntity<>(OrderResponse.fromOrder(orderService.getOrderById(id)), HttpStatus.OK);
    }

    @Operation(summary = "Update order status")
    @ApiResponses(value = {
            @ApiResponse(description = "Update order status success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = OrderResponse.class))),
            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            ))
    })
    @RequestMapping(value = "order/{id}", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderResponse> updateOrderStatus(@RequestBody OrderStatusRequest status, @PathVariable String id) {
        Order order = orderService.updateStatusOrder(status, id);
        return new ResponseEntity<>(OrderResponse.fromOrder(order), HttpStatus.OK);
    }

}
