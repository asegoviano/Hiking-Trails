package com.ht;

import com.ht.business.TrailBusinessService;
import com.ht.business.TrailBusinessServiceInterface;
import com.ht.business.UserBusinessService;
import com.ht.business.UserBusinessServiceInterface;
import com.ht.data.TrailDAO;
import com.ht.data.TrailDAOInterface;
import com.ht.data.UserDAO;
import com.ht.data.UserDAOInterface;
import com.ht.data.entity.TrailEntity;
import com.ht.data.entity.UserEntity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class springconfig {

    @Bean(name = "userBusinessService")
    public UserBusinessServiceInterface getuserBusinessService() {
        return new UserBusinessService();
    }

    @Bean(name = "userDAO")
    public UserDAOInterface<UserEntity> getuserData() {
        return new UserDAO();
    }

    @Bean(name = "trailBusinessService")
    public TrailBusinessServiceInterface gettrailBusinessService() {
        return new TrailBusinessService();
    }

    @Bean(name = "trailDAO")
    public TrailDAOInterface<TrailEntity> gettrailData() {
        return new TrailDAO();
    }

}
