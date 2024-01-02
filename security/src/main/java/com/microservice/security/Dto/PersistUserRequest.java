package com.microservice.security.Dto;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("contains all the fields required to create new user in to the system")
public class PersistUserRequest {
    @ApiModelProperty("username of the user")
    private String userName;
    @ApiModelProperty("email of the user")
    private String email;
    @ApiModelProperty("password of the user")
    private String password;
    @ApiModelProperty("role of the user")
    private String roles;
}
