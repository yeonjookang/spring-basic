package kuit.springbasic.web.dao;

import kuit.springbasic.jdbc.JdbcTemplate;
import kuit.springbasic.web.domain.User;

public class UserDao {

    private final JdbcTemplate<User> jdbcTemplate = new JdbcTemplate<>();

}
