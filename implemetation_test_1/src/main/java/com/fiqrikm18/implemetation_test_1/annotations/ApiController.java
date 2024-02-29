package com.fiqrikm18.implemetation_test_1.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@RestController
@RequestMapping("/api/")
public @interface ApiController {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
