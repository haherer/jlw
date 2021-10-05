package com.nicholas.bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//加密解密工具
@Component
public class MyBCrypt extends BCryptPasswordEncoder {
}
