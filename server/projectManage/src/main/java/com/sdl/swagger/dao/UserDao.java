package com.sdl.swagger.dao;

import com.sdl.swagger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sundonglin
 * @date 2019/10/28 9:52
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<User> personalMtMapper;
    static {
        personalMtMapper = new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setAccount(rs.getString("account"));
                user.setAge(rs.getString("age"));
                user.setCreateTime("create_time");
                user.setMoid(rs.getString("moid"));
                user.setPassword(rs.getString("password"));
                user.setE164(rs.getString("e164"));
                user.setEmail(rs.getString("email"));
                user.setEnable(rs.getInt("enable") ==1 ? true:false);
                user.setDeleted(rs.getInt("isdelete") == 1 ? true:false);
                user.setUserId(rs.getInt("id"));
                return user;
            }
        };
    }
    private static final String GET_USER_BY_ACCOUNT_SQL = "selete * from user where account = ? or email = ? ";
    public User getUserByAccount(String account){
        try {
            return jdbcTemplate.queryForObject(GET_USER_BY_ACCOUNT_SQL, personalMtMapper, account, account);
        } catch (Exception e){
            return null;
        }
    }

    private static final String INSTER_USER_SQL = "insert into user_info(account, `name`, `password`, e164, email, create_time, moid) values(?,?,?,?,?,?,?)";
    public void insterUser(User user){
        Object[] parm = new Object[]{
                user.getAccount(), user.getName(),user.getPassword(),user.getE164(),user.getEmail(),user.getCreateTime(),user.getMoid()
        };
        jdbcTemplate.update(INSTER_USER_SQL, parm);
    }
}
