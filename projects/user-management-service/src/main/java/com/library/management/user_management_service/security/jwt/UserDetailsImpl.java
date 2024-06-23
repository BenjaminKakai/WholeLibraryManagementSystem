package com.library.management.user_management_service.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.user_management_service.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of {@link UserDetails} representing a user's authentication information.
 *
 * @since 9
 */
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;

    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Constructs a new {@code UserDetailsImpl} with the specified details.
     *
     * @param id the user's ID
     * @param username the user's username
     * @param password the user's password
     * @param authorities the authorities granted to the user
     * @since 9
     */
    public UserDetailsImpl(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Builds a {@code UserDetailsImpl} instance from a {@link User} entity.
     *
     * @param user the {@code User} entity
     * @return a new {@code UserDetailsImpl} instance
     * @since 9
     */
    public static UserDetailsImpl build(User user) {
        // Logic to build UserDetailsImpl from User entity
        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                List.of() // Populate with user's authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the user's ID.
     *
     * @return the user's ID
     * @since 9
     */
    public Long getId() {
        return id;
    }

    // Setters and other overridden methods from UserDetails interface
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl that = (UserDetailsImpl) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
