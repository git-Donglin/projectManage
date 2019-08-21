/**
 * @author sundonglin
 * @date 2019年6月10日 下午2:02:59
 */
package com.sdl.swagger.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.sdl.swagger.entity.Item;

/**
 * @author sundonglin
 * @date 2019年6月10日 下午2:02:59
 */
@Repository
public class ItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<Item> personalMtMapper;
	static {
		personalMtMapper = new RowMapper<Item>() {

			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setMoid(rs.getString("moid"));
				item.setState(rs.getInt("state"));
				item.setName(rs.getString("item_name"));
				item.setAddress(rs.getString("address"));
				item.setPeriod(rs.getInt("period"));
				item.setContent(rs.getString("content"));
				item.setDescribe(rs.getString("descc"));
				item.setPrincipal(rs.getString("principal"));
				item.setCreateTime(rs.getDate("create_time"));
				item.setVersion(rs.getString("version"));
				return item;
			}
		};
	}
	
	/**
	 * 获取所有项目信息
	 * @return
	 */
	private static final String ALL_ITEM_SQL = "select * from item";
	public List<Item> allItem(){
		List<Item> list = jdbcTemplate.query(ALL_ITEM_SQL, personalMtMapper);
		return list;
	}
	
	/**
	 * 根据项目Id获取项目信息
	 * @param key：项目Id
	 * @return
	 */
	private  static final String GET_ITEMBYID_SQL = "select * from item where moid = ?";
	public Item getItemById(String moid) {
		try {
			return jdbcTemplate.queryForObject(GET_ITEMBYID_SQL, personalMtMapper, moid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	/**
	 * 新增项目信息
	 * @param detail:项目信息
	 * @throws BusinessException 
	 */
	private static final String add_Item_Sql = "insert into item (moid, item_name, state, address, period, principal, content, descc, create_time, version) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public void saveItem(Item item){
		jdbcTemplate.update(add_Item_Sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				int i = 0;
				preparedStatement.setObject(++i, item.getMoid());
				preparedStatement.setObject(++i, item.getName());
				preparedStatement.setObject(++i, item.getState());
				preparedStatement.setObject(++i, item.getAddress());
				preparedStatement.setObject(++i, item.getPeriod());
				preparedStatement.setObject(++i, item.getPrincipal());
				preparedStatement.setObject(++i, item.getContent());
				preparedStatement.setObject(++i, item.getDescribe());
				preparedStatement.setObject(++i, item.getCreateTime());
				preparedStatement.setObject(++i, item.getVersion());
			}
		});
	}
	
	/**
	 * 根据项目Id删除项目信息
	 * @param key:项目Id
	 * @throws BusinessException 
	 */
	private static final String DEL_ITEM_SQL = "delete from item where moid = ?";
	public void delItem(String moid){
		jdbcTemplate.update(DEL_ITEM_SQL, moid);
	}
	
	/**
	 * 修改项目信息
	 * @param key:项目Id
	 * @param detail：项目信息
	 * @throws BusinessException
	 */
	private static final String PUT_ITEM_SQL = "update item set item_name = ?, state = ?, address = ?, period = ?, principal = ?, content = ?, descc = ?, version= ? where moid = ?";
	public void updateItem(Item item){
		jdbcTemplate.update(PUT_ITEM_SQL, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				int i = 0;
				preparedStatement.setObject(++i, item.getName());
				preparedStatement.setObject(++i, item.getState());
				preparedStatement.setObject(++i, item.getAddress());
				preparedStatement.setObject(++i, item.getPeriod());
				preparedStatement.setObject(++i, item.getPrincipal());
				preparedStatement.setObject(++i, item.getContent());
				preparedStatement.setObject(++i, item.getDescribe());
				preparedStatement.setObject(++i, item.getVersion());
				preparedStatement.setObject(++i, item.getMoid());
			}
		});
	}

}
