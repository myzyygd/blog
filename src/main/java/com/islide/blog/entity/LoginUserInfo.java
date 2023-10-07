package com.islide.blog.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public class LoginUserInfo implements UserDetails, Serializable {
    private static final long serialVersionUID = -4226287466426351685L;
    private final Users users;

    private Collection<? extends GrantedAuthority> authorities;

    public LoginUserInfo(Users users, Collection<? extends GrantedAuthority> authorities) {
        this.users = users;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.users.getPassword();
    }

    @Override
    public String getUsername() {
        return this.users.getName();
    }

    public Integer getUserId() {
        return this.users.getId();
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
