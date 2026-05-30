package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller exposing CRUD and search operations on {@link User} resources.
 */
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    private final UserProvider userProvider;

    private final UserMapper userMapper;

    /**
     * Returns basic information about all users (ID, first name, last name).
     *
     * @return list of simplified user representations
     */
    @GetMapping("/simple")
    public List<SimpleUserDto> getSimpleUsers() {
        return userProvider.findAllUsers().stream()
                .map(userMapper::toSimpleUserDto)
                .toList();
    }

    /**
     * Searches users by email fragment (case-insensitive).
     *
     * @param email fragment of the email address to search for
     * @return list of matching users with ID and email only
     */
    @GetMapping("/email")
    public List<UserEmailDto> getUsersByEmail(@RequestParam String email) {
        return userProvider.findUsersByEmailFragment(email).stream()
                .map(userMapper::toUserEmailDto)
                .toList();
    }

    /**
     * Returns users born before the given date.
     *
     * @param time reference date
     * @return list of users older than the given date
     */
    @GetMapping("/older/{time}")
    public List<UserDto> getUsersOlderThan(@PathVariable LocalDate time) {
        return userProvider.findUsersOlderThan(time).stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    /**
     * Returns details of a single user identified by ID.
     *
     * @param id user identifier
     * @return full user details
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userProvider.getUser(id)
                .map(userMapper::toUserDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Returns full details of all users.
     *
     * @return list of all users
     */
    @GetMapping
    public List<UserDto> getUsers() {
        return userProvider.findAllUsers().stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    /**
     * Creates a new user.
     *
     * @param userDto user data from the request body
     * @return created user with assigned ID
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) {
        final User createdUser = userService.createUser(userMapper.toUser(userDto));
        return userMapper.toUserDto(createdUser);
    }

    /**
     * Updates an existing user.
     *
     * @param userId  identifier of the user to update
     * @param userDto updated user data
     * @return updated user
     */
    @PutMapping("/{userId}")
    public UserDto updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        final User updatedUser = userService.updateUser(userId, userMapper.toUser(userDto));
        return userMapper.toUserDto(updatedUser);
    }

    /**
     * Deletes a user identified by the given ID.
     *
     * @param userId identifier of the user to delete
     */
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
