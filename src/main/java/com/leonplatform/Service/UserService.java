package com.leonplatform.Service;

import com.leonplatform.Objects.User;

public interface UserService {

    User checkUser(String username, String password);
}
