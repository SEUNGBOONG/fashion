package com.example.demo.profile.global.application;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Optional;

import com.example.demo.profile.global.exception.exceptions.jwt.NotFoundTokenException;
import com.example.demo.profile.global.exception.exceptions.jwt.TokenTimeException;
import com.example.demo.profile.member.infrastructure.auth.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final JwtTokenProvider jwtTokenProvider;

    public DecodedJWT verifyJwtToken(String token) {
        return jwtTokenProvider.verifyToken(token);
    }

    public Long verifyAndExtractJwtToken(String token) {
        try {
            return validateTokenExist(token);
        } catch (TokenExpiredException e) {
            throw new TokenTimeException();
        }
    }

    private Long validateTokenExist(String token) {
        return Optional.of(extractJwtToken(token))
                .orElseThrow(NotFoundTokenException::new);
    }

    private Long extractJwtToken(String token) {
        return verifyJwtToken(token).getClaim("memberId")
                .asLong();
    }
}
