package com.vplus.demo.user.consume.models.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String phone;
}
