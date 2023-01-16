package api.airtable.resource.airtableapi;

import javax.ws.rs.HttpMethod;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod(HttpMethod.PATCH)
@Documented
public @interface PATCH {
}