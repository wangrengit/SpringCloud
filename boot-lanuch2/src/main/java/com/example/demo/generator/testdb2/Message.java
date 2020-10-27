package com.example.demo.generator.testdb2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private Long id;

    private String name;

    private String content;
}
