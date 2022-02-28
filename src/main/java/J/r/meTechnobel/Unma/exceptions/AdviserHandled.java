package J.r.meTechnobel.Unma.exceptions;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AdviserHandled {

    @AliasFor("status")
    HttpStatus value() default HttpStatus.BAD_REQUEST;

    @AliasFor("value")
    HttpStatus status() default HttpStatus.BAD_REQUEST;



}
