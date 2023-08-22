package com.muyun.redisdemo.service;

import com.muyun.redisdemo.entity.Address;
import com.muyun.redisdemo.entity.Person;
import com.muyun.redisdemo.entity.User;
import com.muyun.redisdemo.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Test {

    private final RedisTemplate<String, Object> redisTemplate;
    private final RedisTemplate<String, User> user1RedisTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        User user = User.builder()
                .id(1L)
                .name("牧云")
                .username("muyun")
                .phoneNumber("13415436789")
                .build();
        redisTemplate.opsForValue().set("object:value:" + user.getId(), user);
        User user1 = (User) redisTemplate.opsForValue().get("object:value:" + user.getId());

        user1RedisTemplate.opsForValue().set("user:value:" + user.getId(), user);
        User user2 = user1RedisTemplate.opsForValue().get("user:value:" + user.getId());

        stringRedisTemplate.opsForValue().set("string:value:" + user.getId(), user.getPhoneNumber());

        Person person = Person.builder()
                .id(1L)
                .firstname("Jon")
                .lastname("Snow")
                .date(new Date())
                .localDateTime(LocalDateTime.now())
                .address(new Address("Castle Black", "The North"))
                .addresses(List.of(new Address("Castle Black", "The North")))
                .build();
        personRepository.save(person);

        Optional<Person> byId = personRepository.findById(1L);

    }

}
