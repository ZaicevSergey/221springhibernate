package hiber.service;

import hiber.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void add(User user);
    List<User> getUserByCar(String model, int series);
    List<User> listUsers();
}