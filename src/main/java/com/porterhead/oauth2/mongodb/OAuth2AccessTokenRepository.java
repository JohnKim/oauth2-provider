package com.porterhead.oauth2.mongodb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porterhead.oauth2.Token;

/**
 * @version 1.0
 * @author: Iain Porter
 * @since 22/05/2013
 */
@Repository
public interface OAuth2AccessTokenRepository extends JpaRepository<Token, String> {

    public Token findByTokenId(String tokenId);

    public Token findByRefreshToken(String refreshToken);

    public Token findByAuthenticationId(String authenticationId);

    public List<Token> findByClientIdAndUserName(String clientId, String userName);

    public List<Token> findByClientId(String clientId);
}
