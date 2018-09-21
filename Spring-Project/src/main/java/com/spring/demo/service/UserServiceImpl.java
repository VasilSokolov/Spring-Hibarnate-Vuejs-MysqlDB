package com.spring.demo.service;

import com.spring.demo.entity.User;
import com.spring.demo.exeptions.NotFoundException;
import com.spring.demo.model.LoginModel;
import com.spring.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

//    @Override
//    public boolean delete(Long id) {
//        return userRepository.delete(id);
//    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void login(LoginModel loginModel) {
        User user = this.modelMapper.map(loginModel, User.class);
//        String encryptedPassword = this.bCryptPasswordEncoder.encode(loginModel.getPassword());
        user.setPassword(loginModel.getPassword());
        this.userRepository.save(user);
    }
}
