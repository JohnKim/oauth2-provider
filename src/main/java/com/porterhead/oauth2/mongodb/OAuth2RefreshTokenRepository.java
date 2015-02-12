package com.porterhead.oauth2.mongodb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porterhead.oauth2.OAuth2AuthenticationRefreshToken;

/**
 * @version 1.0
 * @author: Iain Porter
 * @since 23/05/2013
 */
@Repository
public interface OAuth2RefreshTokenRepository extends JpaRepository<OAuth2AuthenticationRefreshToken, String> {

    public OAuth2AuthenticationRefreshToken findByTokenId(String tokenId);
}
