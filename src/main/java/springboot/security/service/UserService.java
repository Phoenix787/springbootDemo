package springboot.security.service;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.security.domain.Role;
import springboot.security.domain.Roles;
import springboot.security.domain.User;
import springboot.security.repository.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;

    @PostConstruct
    public void init(){
        if (!userRepository.findByUsername("user").isPresent()){
            userRepository.save(User.builder()
                    .username("user")
                    .password("password")
                    .authorities(ImmutableList.of(Roles.builder().role(Role.ADMIN).build()))
//                    .authorities(ImmutableList.of(Role.ADMIN))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true).build());
        }
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        UserDetails loadedUser;
//        User client = userRepository.findByUsername(s).orElseThrow(()-> new UsernameNotFoundException("Пользователь не найден"));
//        loadedUser = User.builder()
//                .username(client.getUsername())
//                .password(client.getPassword())
//                .authorities(client.getAuthorities())
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .enabled(true).build();
//        return loadedUser;
               return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException("Пользователь не найден"));
    }
}
