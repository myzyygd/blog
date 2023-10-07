package com.islide.blog.dto.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "登陆成功返回DTO")
public class LoginSuccessDto implements Serializable {
    private static final long serialVersionUID = -2294304243330158374L;

    @ApiModelProperty(value = "token")
    private String token;
}
