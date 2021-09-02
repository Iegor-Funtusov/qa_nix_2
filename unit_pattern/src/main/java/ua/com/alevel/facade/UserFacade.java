package ua.com.alevel.facade;

import ua.com.alevel.dto.UserRequestDto;
import ua.com.alevel.dto.UserResponseDto;

import java.util.List;

public interface UserFacade {

    void create(UserRequestDto dto);
    void update(UserRequestDto dto, String id);
    void delete(String id);
    UserResponseDto findById(String id);
    List<UserResponseDto> findAll();
}
