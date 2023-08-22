package com.muyun.redisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private String name;

    private String phoneNumber;

    private boolean deleted;

}
