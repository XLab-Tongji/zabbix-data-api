package rainlf.zabbix.utils;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class JWTTokenUtils {

    private final Logger log = LoggerFactory.getLogger(JWTTokenUtils.class);

    private static final String AUTHORITIES_KEY = "auth";

    private String secretKey;           //签名密钥
    @PostConstruct
    public void init() {
        this.secretKey = "MyJwtSecret";
        int secondIn1day = 1000 * 60 * 60 * 24;
    }

    private final static long EXPIRATIONTIME = 432_000_000;

    //创建Token
    public String createToken(String username){
        return Jwts.builder()                                   //创建Token令牌
                .claim("authorities", "ROLE_ADMIN,AUTH_WRITE")             //添加权限属性
                .setSubject(username)                                                           //设置面向用户
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")   //生成签名
                .compact();
    }
    public Authentication getAuthentication(String token){
      //  System.out.println("token:"+token);
        Claims claims = Jwts.parser()                           //解析Token的payload
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))         //获取用户权限字符串
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());                                                  //将元素转换为GrantedAuthority接口集合

        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }
    //验证Token是否正确
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);   //通过密钥验证Token
            return true;
        }catch (SignatureException e) {                                     //签名异常
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {                                 //JWT格式错误
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {                               //不支持该JWT
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {                              //参数错误异常
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }


}