package com.muyun.redisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("people")
public class Person {
    @Id
    private Long id;
    @Indexed
    private String firstname;
    private String lastname;
    private Address address;
    private List<Address> addresses;
    private Date date;
    private LocalDateTime localDateTime;
}
