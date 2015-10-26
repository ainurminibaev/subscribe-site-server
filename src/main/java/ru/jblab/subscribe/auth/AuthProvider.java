package ru.jblab.subscribe.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.jblab.subscribe.service.UserService;
import ru.jblab.subscribe.util.PasswordHelper;
import ru.jblab.subscribe.util.SecurityContextUtil;
import ru.jblab.subscribe.model.User;

/**
 * Created by ainurminibaev on 12.05.14.
 */
@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String password = authentication.getCredentials().toString();
        String email = authentication.getName();
        User user = userService.findUser(email);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        String hashedPassword = PasswordHelper.encrypt(password, user.getSalt());
        String generatedHash = PasswordHelper.encryptForGenerated(password, user.getSalt());
        if (user.getPassword().equals(hashedPassword) || generatedHash.equals(user.getPassword())) {
            return SecurityContextUtil.setAuthentication(user);
        } else {
            throw new BadCredentialsException("Bad user password");
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
