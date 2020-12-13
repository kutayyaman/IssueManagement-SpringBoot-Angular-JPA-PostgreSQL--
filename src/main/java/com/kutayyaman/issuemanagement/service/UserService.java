package com.kutayyaman.issuemanagement.service;

import com.kutayyaman.issuemanagement.dto.UserDto;
import com.kutayyaman.issuemanagement.entity.User;
import com.kutayyaman.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User save(User user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);

    UserDto update(Long id, UserDto userDto);

    Boolean deleteById(Long id);

    List<UserDto> getAll();
}
