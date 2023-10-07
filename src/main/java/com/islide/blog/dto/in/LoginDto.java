package com.islide.blog.dto.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@ApiModel(value = "登陆参数")
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 2668104436337137972L;

    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;
}
