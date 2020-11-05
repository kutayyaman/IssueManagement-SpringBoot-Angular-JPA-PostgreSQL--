package com.kutayyaman.issuemanagement.service.impl;

import com.kutayyaman.issuemanagement.entity.User;
import com.kutayyaman.issuemanagement.repository.UserRepository;
import com.kutayyaman.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service//IoC contanerda singleton instancelari olusturacak bu anatasyon boylelikle @Autowired diyerek veya kurucu ile injecti edebilecez
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {

        if(user.getEmail() == null){
            throw new IllegalArgumentException("Email cannot be null");
        }

        return userRepository.save(user);

    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
