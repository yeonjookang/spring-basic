package kuit.springbasic.dao;

import kuit.springbasic.core.jdbc.connection.ConnectionManager;
import kuit.springbasic.web.repository.UserRepository;
import kuit.springbasic.web.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {

    private static UserRepository userRepository;
    private ResourceDatabasePopulator populator;

    @BeforeEach
    public void setup() {
        userRepository = new UserRepository();
        populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("jwp.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    public void crud() throws Exception {
        // create
        User expected = new User("userId", "password", "name", "jungwoo@email.com");
        userRepository.insert(expected);
        User actual = userRepository.findByUserId(expected.getUserId());
        assertThat(expected.equals(actual)).isTrue();

        // update
        expected.update(new User("userId", "password2", "name2", "jungwoo2@email.com"));
        userRepository.update(expected);
        actual = userRepository.findByUserId(expected.getUserId());
        assertThat(expected.equals(actual)).isTrue();

        // read
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isEqualTo(2);
    }

}
