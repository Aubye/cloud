package com.app.system.domain.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String uuid;

    private String username;

    private String password;

    private String name;

    private Integer status;

    private Integer isDel;

}
