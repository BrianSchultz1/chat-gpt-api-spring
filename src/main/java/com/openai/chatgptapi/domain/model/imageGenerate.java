package com.openai.chatgptapi.domain.model;

import lombok.Data;

@Data
public class imageGenerate {
    private String text;
    private Integer number = 1;

    private String size = "1024x1024";
}
