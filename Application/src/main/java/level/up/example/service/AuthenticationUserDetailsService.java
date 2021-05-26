package level.up.example.service;

import level.up.example.module.ApiUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApiUser apiUser = userService.readUserByEmail(email);
        if (apiUser == null) {
            throw new UsernameNotFoundException(email);
            }
        return new org.springframework.security.core.userdetails.User(apiUser.getEmail(), apiUser.getPassword(), Collections.emptyList());
    }
}