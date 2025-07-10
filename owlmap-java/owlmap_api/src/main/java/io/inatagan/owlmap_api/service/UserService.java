package io.inatagan.owlmap_api.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.inatagan.owlmap_api.entity.User;
import io.inatagan.owlmap_api.repository.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(null == id ? 0L : id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void updateById(User user) {
        userRepository.save(null == user.getId() ? user : userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("User not found")));
    }

    public void deleteById(User user) {
        userRepository.deleteById(null == user.getId() ? user.getId() : userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("User not found")).getId());
    }
}
