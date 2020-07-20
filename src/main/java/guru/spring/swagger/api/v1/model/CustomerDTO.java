package guru.spring.swagger.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
    private Long id; //?????????????????

    @ApiModelProperty(value = "First Name", required = true)
    private String firstName;
    @ApiModelProperty(value = "Last Name", required = true)
    private String lastName;
    private String customer_url;
    private String customer_det;
}
