package com.sdl.swagger.dao;

import com.sdl.swagger.entity.ItemDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sundonglin
 * @date 2019/9/3 11:25
 */
@Repository
public class ItemDemandDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<ItemDemand> ItemDemandMapper;
    static {
        ItemDemandMapper = new RowMapper<ItemDemand>() {

            @Override
            public ItemDemand mapRow(ResultSet rs, int rowNum) throws SQLException {
                ItemDemand itemDemand = new ItemDemand();
                itemDemand.setId(rs.getInt("id"));
                itemDemand.setMoid(rs.getString("moid"));
                itemDemand.setPrincipal(rs.getString("principal"));
                itemDemand.setDescribe(rs.getString("describe"));
                itemDemand.setTitle(rs.getString("title"));
                itemDemand.setCreateDate(rs.getDate("create_date"));
                itemDemand.setStartDate(rs.getDate("start_date"));
                itemDemand.setEntDate(rs.getDate("ent_date"));
                itemDemand.setState(rs.getInt("state"));
                itemDemand.setItemMoid(rs.getString("item_moid"));
                return itemDemand;
            }


        };
    }

    /**
     * 根据项目moid获取需求
     */
    private static String LIST_IEMDEMAND_BY_ITEMMOID = "select * from item_demand where item_moid = ?";
    public List<ItemDemand> listItemDemandByItemMoid(String itemMoid){
        List<ItemDemand> list = jdbcTemplate.query(LIST_IEMDEMAND_BY_ITEMMOID, ItemDemandMapper, itemMoid);
        return list;
    }

    /**
     * 添加需求
     */
    private static String INSTART_ITEMDEMAND = "insert into item_demand (moid, item_moid,principal,`describe`,title,create_date,start_date,ent_date,state)" +
            "values(?,?,?,?,?,?,?,?,?)";
    public void saveItemDemand(ItemDemand itemDemand){
        jdbcTemplate.update(INSTART_ITEMDEMAND, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                int i = 0;

                preparedStatement.setObject(++i, itemDemand.getMoid());
                preparedStatement.setObject(++i, itemDemand.getItemMoid());
                preparedStatement.setObject(++i, itemDemand.getPrincipal());
                preparedStatement.setObject(++i, itemDemand.getDescribe());
                preparedStatement.setObject(++i, itemDemand.getTitle());
                preparedStatement.setObject(++i, itemDemand.getCreateDate());
                preparedStatement.setObject(++i, itemDemand.getStartDate());
                preparedStatement.setObject(++i, itemDemand.getEntDate());
                preparedStatement.setObject(++i, itemDemand.getState());
            }
        });
    }

    /**
     * 添加需求
     */
    private static String UPDATE_ITEMDEMAND = "update item_demand set item_moid = ?,principal = ?,`describe` = ?,title = ?,start_date = ?,ent_date = ?,state = ? " +
            "where moid = ?";
    public void updateItemDemand(ItemDemand itemDemand){
        jdbcTemplate.update(UPDATE_ITEMDEMAND, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                int i = 0;
                preparedStatement.setObject(++i, itemDemand.getItemMoid());
                preparedStatement.setObject(++i, itemDemand.getPrincipal());
                preparedStatement.setObject(++i, itemDemand.getDescribe());
                preparedStatement.setObject(++i, itemDemand.getTitle());
                preparedStatement.setObject(++i, itemDemand.getStartDate());
                preparedStatement.setObject(++i, itemDemand.getEntDate());
                preparedStatement.setObject(++i, itemDemand.getState());
                preparedStatement.setObject(++i, itemDemand.getMoid());
            }
        });
    }

    private static String GET_ITEMDEMAND_BY_MOID = "select * from item_demand where moid = ?";
    public ItemDemand getItemDemandByMoid(String moid){
       return jdbcTemplate.queryForObject(GET_ITEMDEMAND_BY_MOID, ItemDemandMapper, moid);
    }
}
