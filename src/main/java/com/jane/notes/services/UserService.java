package com.jane.notes.services;



import com.jane.notes.DTOs.UserDTO;
import com.jane.notes.models.Role;
import com.jane.notes.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

    User findByUsername(String username);

    List<Role> getAllRoles();

    void updatePassword(Long userId, String password);

    Optional<User> findByEmail(String email);

    User registerUser(User user);

}
