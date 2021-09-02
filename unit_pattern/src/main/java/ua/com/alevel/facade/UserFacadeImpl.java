package ua.com.alevel.facade;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.UserRequestDto;
import ua.com.alevel.dto.UserResponseDto;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserService;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void create(UserRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(UserRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        userService.delete(id);
    }

    @Override
    public UserResponseDto findById(String id) {
        return new UserResponseDto(userService.findById(id));
    }

    @Override
    public List<UserResponseDto> findAll() {
//        List<User> users = userService.findAll();
//        List<UserResponseDto> dtoList = new ArrayList<>();
//        for (User user : users) {
//            dtoList.add(new UserResponseDto(user));
//        }
//        return dtoList;
        return userService.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    private void createOrUpdate(UserRequestDto dto, String id) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setBirthDay(dto.getBirthDay());
        if (id == null) {
            userService.create(user);
        } else {
            user.setId(id);
            userService.update(user);
        }
    }
}
//        User user = User.newUser()
//                .setFirstName(dto.getFirstName())
//                .setLastName(dto.getLastName())
//                .setEmail(dto.getEmail())
//                .setBirthDay(dto.getBirthDay())
//                .build();
