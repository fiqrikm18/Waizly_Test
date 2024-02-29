package com.fiqrikm18.implemetation_test_1.presentation;

import com.fiqrikm18.implemetation_test_1.annotations.ApiController;
import com.fiqrikm18.implemetation_test_1.domain.order.OrderResponse;
import com.fiqrikm18.implemetation_test_1.domain.security.*;
import com.fiqrikm18.implemetation_test_1.domain.security.user.UserInfo;
import com.fiqrikm18.implemetation_test_1.domain.security.user.UserService;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ApiController
@Tag(name = "Authentication")
class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Operation(summary = "register")
    @ApiResponses(value = {
            @ApiResponse(description = "register success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = RegisterResponse.class))),
            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
            ))
    })
    @RequestMapping(value = "auth/register", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        UserInfo userInfo = userService.save(request);
        return new ResponseEntity<>(RegisterResponse.builder()
                .username(userInfo.getUsername())
                .roles(userInfo.getRole())
                .build(), HttpStatus.OK);
    }

//    @Operation(summary = "login")
//    @ApiResponses(value = {
//            @ApiResponse(description = "login success", responseCode = "200",
//                    content = @Content(schema = @Schema(implementation = RegisterResponse.class))),
//            @ApiResponse(description = "Internal server error", responseCode = "500", content = @Content(
//                    schema = @Schema(implementation = RestResponseEntityExceptionHandler.ErrorResponse.class)
//            ))
//    })
//    @RequestMapping(value = "auth/login", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
//        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            throw new UsernameNotFoundException("invalid username or password");
//        }
//
//        return new ResponseEntity<>(AuthenticationResponse.builder()
//                .accessToken(jwtService.GenerateToken(request.getUsername()))
//                .build(), HttpStatus.OK);
//    }

}
