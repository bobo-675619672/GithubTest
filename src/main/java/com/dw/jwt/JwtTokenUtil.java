package com.dw.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.dw.model.entity.SysUser;
import com.google.common.collect.Lists;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.white}")
	private String whiteList;
    
    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = (String) claims.get("username");
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String generateToken(SysUser user) {
    	List<String> roles = Lists.newArrayList();
    	user.getRoles().forEach(role -> {
    		roles.add(role.getName());
    	});
    	
    	Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("username", user.getUsername());
        claims.put("role", roles);
        return generateToken(claims);
    }
    
    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        SysUser user = (SysUser) userDetails;
        final String username = getUsernameFromToken(token);
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token));
    }

	public String[] getWhiteList() {
		// 基础白名单
    	String[] baseWhiteArr = {
    					SecurityConstants.DEFAULT_VALIDATE_HTML_JS_SUFFIX,
    					SecurityConstants.DEFAULT_VALIDATE_HTML_FONTS_SUFFIX,
    					SecurityConstants.DEFAULT_VALIDATE_HTML_IMAGES_SUFFIX,
    					SecurityConstants.DEFAULT_VALIDATE_HTML_CSS_SUFFIX,
    					SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
    					SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
    					SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
    					SecurityConstants.DEFAULT_LOGIN_PAGE_URL,
    					SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM,
    					SecurityConstants.DEFAULT_SWAGGER_V2_API_DOCS_URL,
    					SecurityConstants.DEFAULT_SWAGGER_UI_URL,
    					SecurityConstants.DEFAULT_SWAGGER_RESOURCES_URL,
    					SecurityConstants.DEFAULT_SWAGGER_IMAGES_URL,
    					SecurityConstants.DEFAULT_SWAGGER_WEBJARS_URL,
    					SecurityConstants.DEFAULT_SWAGGER_CONFIGURATION_UI_URL,
    					SecurityConstants.DEFAULT_SWAGGER_CONFIGURATION_SECURITY_URL
    	};
    	// 自定义白名单
    	String[] custwhiteArr = {};
    	if (StringUtils.isNotEmpty(whiteList)) {
    		custwhiteArr = whiteList.split(",", -1);
    	}
    			
    	String[] whiteArr = ArrayUtils.addAll(baseWhiteArr, custwhiteArr);
    	
    	return whiteArr;
	}
}

