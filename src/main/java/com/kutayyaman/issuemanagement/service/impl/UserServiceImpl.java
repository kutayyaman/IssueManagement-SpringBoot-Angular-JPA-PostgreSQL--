package com.kutayyaman.issuemanagement.service.impl;

import com.kutayyaman.issuemanagement.dto.IssueDto;
import com.kutayyaman.issuemanagement.dto.UserDto;
import com.kutayyaman.issuemanagement.entity.Issue;
import com.kutayyaman.issuemanagement.entity.User;
import com.kutayyaman.issuemanagement.repository.UserRepository;
import com.kutayyaman.issuemanagement.service.UserService;
import com.kutayyaman.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service//IoC contanerda singleton instancelari olusturacak bu anatasyon boylelikle @Autowired diyerek veya kurucu ile injecti edebilecez
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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
}
