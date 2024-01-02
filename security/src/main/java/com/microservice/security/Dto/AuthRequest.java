package com.microservice.security.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ApiModel("contains all the fields required for to login in to the system")
public class AuthRequest {
    @ApiModelProperty("username of the user while login")
    private String userName;
    @ApiModelProperty("password of the user while login")
    private String password;
}
