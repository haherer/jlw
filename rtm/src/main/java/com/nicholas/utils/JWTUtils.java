package com.nicholas.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    private static final String jwtToken = "123456";//加密私钥

    public static String creatToken(Long userId){
        //userId包装为map
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId",userId);
        //设置参数
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, jwtToken)//算法，密钥为jwtToken
                .setClaims(claims)//body数据，唯一值
                .setIssuedAt(new Date())//创建时间
                .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000));//过期时间
        String token = jwtBuilder.compact();//创建token
        return token;
    }

    public static Map<String,Object> checkToken(String token) {

        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
