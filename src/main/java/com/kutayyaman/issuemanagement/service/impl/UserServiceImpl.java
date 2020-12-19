package com.kutayyaman.issuemanagement.service.impl;

import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.dto.RegistrationRequest;
import com.kutayyaman.issuemanagement.dto.UserDto;
import com.kutayyaman.issuemanagement.entity.Issue;
import com.kutayyaman.issuemanagement.entity.User;
import com.kutayyaman.issuemanagement.repository.UserRepository;
import com.kutayyaman.issuemanagement.service.UserService;
import com.kutayyaman.issuemanagement.util.TPage;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@Service//IoC contanerda singleton instancelari olusturacak bu anatasyon boylelikle @Autowired diyerek veya kurucu ile injecti edebilecez
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User save(User user) {

        if(user.getEmail() == null){
            throw new IllegalArgumentException("Email cannot be null");
        }

        return userRepository.save(user);

    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.getOne(id);
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public TPage<UserDto> getAllPageable(Pageable pageable) {

        Page<User> page = userRepository.findAll(pageable);

        UserDto[] dtos = modelMapper.map(page.getContent(), UserDto[].class);

        return new TPage<UserDto>(page, Arrays.asList(dtos));
    }

    @Override
    public UserDto getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return Arrays.asList(modelMapper.map(users, UserDto[].class));
    }

    @Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setNameSurname(registrationRequest.getNameSurname());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUsername(registrationRequest.getUsername());
            userRepository.save(user);
            return Boolean.TRUE;
        }
        catch (Exception e){
            log.error("Registration => ",e);
            return Boolean.FALSE;
        }

    }
}
