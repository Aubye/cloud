package com.app.system.service;

import com.app.system.dao.UserRepository;
import com.app.system.domain.dto.UserDTO;
import com.app.system.util.BeanMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public String getUser() {
        return "Test User...";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return Lists.newArrayList();
    }
}
