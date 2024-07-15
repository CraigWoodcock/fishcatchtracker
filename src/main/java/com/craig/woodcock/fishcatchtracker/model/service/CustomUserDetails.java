package com.craig.woodcock.fishcatchtracker.model.service;

import com.craig.woodcock.fishcatchtracker.model.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.logging.Logger;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {

    private final User user;
    private static final Logger logger = Logger.getLogger(CustomUserDetails.class.getName());

    public CustomUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
        logger.info("CustomUserDetails created for user ID: " + user.getId());
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // Implement your authorities logic
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
