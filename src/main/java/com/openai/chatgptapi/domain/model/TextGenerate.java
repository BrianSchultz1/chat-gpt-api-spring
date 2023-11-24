package com.openai.chatgptapi.domain.model;

import lombok.Data;

@Data
public class TextGenerate {
    private String question;
    private Double temperature = 0.0;
}
