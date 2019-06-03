package com.app.system.service;

import com.app.platform.utils.BeanMapper;
import com.app.system.dao.UserRepository;
import com.app.system.domain.dto.UserDTO;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BeanMapper beanMapper;

    @Override
    public String getUser() {
        Specification specification = (root, query, cb) -> {
            List<Predicate> predicates = Lists.newArrayList();
            List<Long> userIds = Lists.newArrayList();
            userIds.add(1L);
            if (CollectionUtils.isNotEmpty(userIds)) {
                Predicate predicate = root.get("id").in(userIds);
                predicates.add(predicate);
            }
            predicates.add(cb.equal(root.get("id"), 1));
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        Integer pageNum = 1;
        Integer pageLimit = 1;
        PageRequest id = new PageRequest(1, 10, new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageLimit, Sort.by(Sort.Direction.DESC, "id"));
        Page page = userRepository.findAll(specification, pageRequest);
        List dataList = beanMapper.mapAsList(page, UserDTO.class);
        long totalElements = page.getTotalElements();
        long totalPages = page.getTotalPages();

        return "Test User...";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return Lists.newArrayList();
    }
}
