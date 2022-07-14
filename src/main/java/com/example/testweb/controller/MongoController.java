package com.example.testweb.controller;

import com.example.testweb.dto.SystemDto;
import com.example.testweb.dto.UserDto;
import com.example.testweb.repository.mongo.userRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class MongoController {

    private final userRepository userRepository;

    @PostMapping("/mongoTest")
    @ResponseBody
    public String makeUserInfo() {
        UserDto userInfo = new UserDto();
        userInfo.setUid("izex_id");
        userInfo.setUserName("izex_name");
        userInfo.setUserPw("izex_0329");
        userInfo.setEmail("izex@izex.co.kr");
        SystemDto systemInfo = new SystemDto();
        systemInfo.setSystemKey(1L);
        systemInfo.setSystemName("izex_System");
        userInfo.setSystemInfo(systemInfo);
        return userRepository.save(userInfo).getUid();
    }

    @GetMapping("/userList")
    public void getUserList() {
        log.info("testStart");
        List<UserDto> userList = userRepository.findAll();
        userList.forEach(info -> {
            log.info(info.getUid());
            log.info(info.toString());
        });
    }

}
