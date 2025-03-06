package com.hyetaekon.hyetaekon.common.jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.hyetaekon.hyetaekon.user.entity.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails, CustomUserPrincipal {
    private final Long id;
    private final String email;
    private final String nickname;
    private final Role role;
    private final String password;
    private final String name;
    private final String oauthName = null;

    public CustomUserDetails(Long id, String email, String nickname, Role role, String password, String name) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.password = password;
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name())); // 문자열 기반 권한
    }

    @Override
    public String getRole() {
        return role.name();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
