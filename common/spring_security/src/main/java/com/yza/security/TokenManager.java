package com.yza.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenManager {

    //token有效时长
    private long tokenEcpiration = 24*60*60*1000;
    //编码密钥
    private String tokenSignKey = "123456";

    //1.根据用户名生成token
    public String createToken(String username) {
        String s = Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + tokenEcpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return s;
    }

    //2.根据token字符串得到用户信息



}
