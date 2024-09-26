package org.example.appecomtech.dao.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class MyUserPrincipal implements UserDetails {
    private final Utilisateur utilisateur;
    private final List<GrantedAuthority> authorities;

    public MyUserPrincipal(Utilisateur utilisateur, List<GrantedAuthority> authorities) {
        this.utilisateur = utilisateur;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return utilisateur.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return utilisateur.getNom();
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

    public String getNom() {
        return utilisateur.getNom();
    }

    public String getEmail() {
        return utilisateur.getEmail();
    }

    public String getRole() {
        return utilisateur.getRole();
    }
}
