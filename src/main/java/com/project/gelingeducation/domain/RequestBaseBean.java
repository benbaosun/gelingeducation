package com.project.gelingeducation.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestBaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String data;
    private String sign;


}