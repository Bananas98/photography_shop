package com.example.photography_shop.service.impl;

import com.example.photography_shop.entity.Role;
import com.example.photography_shop.entity.User;
import com.example.photography_shop.entity.dto.RemindPassword;
import com.example.photography_shop.repository.RoleRepository;
import com.example.photography_shop.repository.UserRepository;
import com.example.photography_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.SetUtils;


@Service
public class UserServiceImpl implements UserService {

    private final String USER_ROLE = "ROLE_USER";

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        Set<Role> roles = SetUtils.singletonSet(roleRepository.findByName(USER_ROLE));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (CollectionUtils.isEmpty(user.getRoles())) {
            user.setRoles(roles);
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
        return userRepository.findByFirstNameAndAndLastName(username);
    }

    @Override
    public User update(User user) {
        User oldUser = userRepository.findByLogin(user.getLogin()).get();
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setLogin(user.getLogin());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        return userRepository.save(oldUser);
    }

    @Override
    public User getCurrentUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByLoginOptional(login).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public User getById(Long id) {
        return userRepository.findById(id.toString())
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + "does not exist"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id.toString());
    }

//    @Override
//    public Page<User> getPage(Pageable pageable) {
//        return userRepository.findAll(pageable);
//    }

    @Override
    public void remindPassword(RemindPassword remindPassword) {
        userRepository.findByLoginOptional(remindPassword.getMail())
                .ifPresent(user -> {
                    user.setActivatedCode(UUID.randomUUID().toString());
                    userRepository.save(user);
                });
    }

    @Override
    public void restartPassword(String activatedCode, RemindPassword remindPassword) {
        userRepository.findByActivatedCode(activatedCode)
                .ifPresent(user -> {
                    user.setPassword(passwordEncoder.encode(remindPassword.getPassword()));
                    userRepository.save(user);
                });

    }

    @Override
    public User findOne(String login) {
        return userRepository.findByLogin(login).get();
    }

//    @Override
//    public Collection<User> findByRole(String role) {
//        return null;
//    }
}