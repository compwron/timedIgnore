import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface TimedIgnore {
    String expires() default "0-0-0";
}