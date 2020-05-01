package csubbcluj.lisamunteanu.authservice.securityconfig;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import csubbcluj.lisamunteanu.authservice.dao.CustomerDao;
import csubbcluj.lisamunteanu.authservice.model.CustomUser;
import csubbcluj.lisamunteanu.authservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<CustomUser> optionalCustomUser = customerService.findByName(username);

        if (optionalCustomUser.isPresent()) {
            CustomUser user = optionalCustomUser.get();
            // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
            // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_" + user.getRole());

            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }

        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }
}
