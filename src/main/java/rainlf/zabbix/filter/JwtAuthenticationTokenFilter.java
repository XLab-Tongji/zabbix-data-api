package rainlf.zabbix.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import rainlf.zabbix.configuration.WebSecurityConfig;
import rainlf.zabbix.utils.JWTTokenUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by linyuan on 2017/12/11.
 */
public class JwtAuthenticationTokenFilter extends GenericFilterBean {

    private final Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private JWTTokenUtils tokenProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
            String header=httpReq.getHeader("Authorization");
            if(header==null||!header.startsWith("Bearer ")){
                filterChain.doFilter(httpReq,servletResponse);
                return;
            }
            UsernamePasswordAuthenticationToken authentication = getAuthentication(httpReq);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(httpReq,servletResponse);
            /*String jwt = resolveToken(httpReq);
            if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {            //验证JWT是否正确
                Authentication authentication = this.tokenProvider.getAuthentication(jwt);      //获取用户认证信息
                SecurityContextHolder.getContext().setAuthentication(authentication);           //将用户保存到SecurityContext
            }
            filterChain.doFilter(servletRequest, servletResponse);*/
        }catch (ExpiredJwtException e){                                     //JWT失效
            log.info("Security exception for user {} - {}",
                    e.getClaims().getSubject(), e.getMessage());

            log.trace("Security exception trace: {}", e);
            ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey("MyJwtSecret")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
    /*private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(WebSecurityConfig.AUTHORIZATION_HEADER);         //从HTTP头部获取TOKEN
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());                              //返回Token字符串，去除Bearer
        }
        String jwt = request.getParameter(WebSecurityConfig.AUTHORIZATION_TOKEN);               //从请求参数中获取TOKEN
        if (StringUtils.hasText(jwt)) {
            return jwt;
        }
        return null;
    }*/

}