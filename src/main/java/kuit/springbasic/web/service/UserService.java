package kuit.springbasic.web.service;

import kuit.springbasic.web.domain.User;
import kuit.springbasic.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUp(User user){
        //예외처리 필요
        userRepository.insert(user);
    }

    public List<User> showAll(){
        return userRepository.findAll();
    }

    public boolean isLogin(User user) throws SQLException {
        User findUser = userRepository.findByUserId(user.getUserId());
        if(findUser!=null && findUser.getPassword().equals(user.getPassword())){
            return true;
        }
        else
            return false;
    }
}
