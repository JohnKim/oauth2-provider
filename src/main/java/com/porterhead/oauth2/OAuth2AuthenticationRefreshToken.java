package com.porterhead.oauth2;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.porterhead.persistence.BaseEntity;

/**
 * @version 1.0
 * @author: Iain Porter
 * @since 23/05/2013
 */

@Entity
public class OAuth2AuthenticationRefreshToken extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String tokenId;
	
	@Lob
	@Embedded
    private OAuth2RefreshToken oAuth2RefreshToken;
    @Lob
    @Embedded
    private OAuth2Authentication authentication;

    public OAuth2AuthenticationRefreshToken(OAuth2RefreshToken oAuth2RefreshToken, OAuth2Authentication authentication) {
        this.oAuth2RefreshToken = oAuth2RefreshToken;
        this.authentication = authentication;
        this.tokenId = oAuth2RefreshToken.getValue();
    }

    public String getTokenId() {
        return tokenId;
    }

    public OAuth2RefreshToken getoAuth2RefreshToken() {
        return oAuth2RefreshToken;
    }

    public OAuth2Authentication getAuthentication() {
        return authentication;
    }
}
