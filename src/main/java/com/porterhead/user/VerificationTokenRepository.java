package com.porterhead.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @version 1.0
 * @author: Iain Porter
 * @since 13/05/2013
 */
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findById(String id);

    VerificationToken findByToken(String token);

    List<VerificationToken> findByUserId(String userId);

    List<VerificationToken> findByUserIdAndTokenType(String userId, VerificationTokenType tokenType);
}
