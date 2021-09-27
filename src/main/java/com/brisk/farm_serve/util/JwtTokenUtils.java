package com.brisk.farm_serve.util;


import com.brisk.farm_serve.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shuang.kou
 * @description JWT工具类
 */
public class JwtTokenUtils {


    /**
     * 生成足够的安全随机密钥，以适合符合规范的签名
     */
    // JWT安全密钥转字节数组
    private static final byte[] API_KEY_SECRET_BYTES = DatatypeConverter.parseBase64Binary(SecurityConstants.JWT_SECRET_KEY);
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(API_KEY_SECRET_BYTES);

    public static String createToken(String username, String id, List<String> roles, boolean isRememberMe) {
        // 设定过期时间
        long expiration = isRememberMe ? SecurityConstants.EXPIRATION_REMEMBER : SecurityConstants.EXPIRATION;
        final Date createdDate = new Date();
        // 过期时间的Date类
        final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);
        // JwtBuilder
        String tokenPrefix = Jwts.builder()
                // set jwt header type: jwt
                .setHeaderParam("type", SecurityConstants.TOKEN_TYPE)
                // 对key做签名
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                // 自定义claim参数键值
                // 添加了rol：roles
                .claim(SecurityConstants.ROLE_CLAIMS, String.join(",", roles))
                // 设置jwtid
                .setId(id)
                // 设置颁发者
                .setIssuer("SnailClimb")
                // 设置发布于
                .setIssuedAt(createdDate)
                // 设置主体
                .setSubject(username)
                // 设置过期时间
                .setExpiration(expirationDate)
                // 构建一个紧凑的 URL 安全 JWT 字符串。
                .compact();
        return SecurityConstants.TOKEN_PREFIX + tokenPrefix; // 添加 token 前缀 "Bearer ";
    }

    // 从claims中getId
    public static String getId(String token) {
        Claims claims = getClaims(token);
        return claims.getId();
    }

    // UsernamePasswordAuthenticationToken 代表一个被验证的请求对象
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        // 获取token中的claims
        Claims claims = getClaims(token);
        // 获取authorities claim
        List<SimpleGrantedAuthority> authorities = getAuthorities(claims);
        String userName = claims.getSubject();
        // 用户名 密码 权限
        return new UsernamePasswordAuthenticationToken(userName, token, authorities);
    }

    private static List<SimpleGrantedAuthority> getAuthorities(Claims claims) {
        String role = (String) claims.get(SecurityConstants.ROLE_CLAIMS);
        // 转换成流 https://blog.csdn.net/piglite/article/details/53823584
        return Arrays.stream(role.split(","))
                // 对list中每个元素新建一个SimpleGrantedAuthority对象
                .map(SimpleGrantedAuthority::new)
                // 将流收集为list
                .collect(Collectors.toList());
    }

    private static Claims getClaims(String token) {
        // jwt解析器
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

}
