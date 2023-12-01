package test;

import com.ndh.model.UserModel;
import com.ndh.service.IUserService;
import com.ndh.service.impl.UserService;

public class Test {


    public static void main(String[] args) {
        IUserService userService = new UserService();
        UserModel userModel = userService.findOneByUsername("user1");
        System.out.println(userModel.getUserName());

    }
}
