package com.capg.nutrition.services;

import java.util.List;
import com.capg.nutrition.dto.UserDTO;
import com.capg.nutrition.entity.User;
import com.capg.nutrition.exceptions.InvalidDataException;

public interface UserService {
    public List<UserDTO> getAllUsers() throws InvalidDataException;

    //    public List<Userdto> getByUserId(Userdto user) {
    //        return userRepository.findAll();
    //    }
    public UserDTO getUserByUserId(int id) throws InvalidDataException;

    public User registerUser(User user)throws InvalidDataException;

    public UserDTO deleteUser(int id)throws InvalidDataException;
    
    public UserDTO updateUser(UserDTO user)throws InvalidDataException;
}
