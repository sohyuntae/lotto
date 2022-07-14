package com.example.testweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usr_info")
public class UserDto {
    @Id
    private String uid;
    private String userName;
    private String userPw;
    private String email;
    private SystemDto systemInfo;
}
