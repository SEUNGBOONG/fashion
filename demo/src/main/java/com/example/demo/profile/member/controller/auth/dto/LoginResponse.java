package com.example.demo.profile.member.controller.auth.dto;

public record LoginResponse(
        String token,
        Long memberId,
        String memberName,
        String memberNickName
) {
}
