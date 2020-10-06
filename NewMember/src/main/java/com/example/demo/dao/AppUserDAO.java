package com.example.demo.dao;

/**
 * Created by mdtofazzal.hossain on 4/1/2019.
 */


import com.example.demo.formbean.AppUserForm;
import com.example.demo.model.AppUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserDAO {
    void initDATA();
    Long getMaxUserId();

    AppUser findAppUserByUserName(String userName);

    AppUser findAppUserByEmail(String email);

    List<AppUser> getAppUsers();

    AppUser createAppUser(AppUserForm form);
}
