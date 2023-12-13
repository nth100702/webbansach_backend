package com.server.webbansach_backend.service;

import com.server.webbansach_backend.entity.NguoiDung;
import com.server.webbansach_backend.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    public static final String SERECT ="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    @Autowired
    private UserDetailService userDetailService;

    public String generateToken(String tenDangNhap){
        Map<String, Object> claims=new HashMap<>();
        NguoiDung nguoiDung = userDetailService.findByUsername(tenDangNhap);

        boolean isAdmin = false;
        boolean isStaff = false;
        boolean isUser = false;
        if (nguoiDung!=null && nguoiDung.getRoleList().size()>0){
            List<Role> list =  nguoiDung.getRoleList();
            for (Role q: list) {
                if(q.getTenQuyen().equals("ADMIN")){
                    isAdmin = true;
                }
                if(q.getTenQuyen().equals("STAFF")){
                    isStaff = true;
                }
                if(q.getTenQuyen().equals("USER")){
                    isUser = true;
                }
            }
        }

        claims.put("isAdmin", isAdmin);
        claims.put("isStaff", isStaff);
        claims.put("isUser", isUser);

        return createToken(claims, tenDangNhap);
    }

    private String createToken(Map<String, Object> claims, String tenDangNhap){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(tenDangNhap)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 30*60*1000))
                .signWith(SignatureAlgorithm.HS256,getSignKey())
                .compact();
    }

    private Key getSignKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SERECT);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token).getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String tenDangNhap = extractUsername(token);
        System.out.println(tenDangNhap);
        return (tenDangNhap.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }
}
