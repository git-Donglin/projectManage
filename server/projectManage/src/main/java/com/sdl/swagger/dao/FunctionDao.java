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

import com.sdl.swagger.entity.Function;

/**
 * @author sundonglin
 * @date 2019年6月10日 下午2:02:59
 */
@Repository
public class FunctionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<Function> personalMtMapper;
	private static final RowMapper<Function> personalMtMapperByItmeName;
	static {
		personalMtMapper = new RowMapper<Function>() {

			@Override
			public Function mapRow(ResultSet rs, int rowNum) throws SQLException {
				Function function = new Function();
				function.setId(rs.getInt("id"));
				function.setMoid(rs.getString("moid"));
				function.setState(rs.getInt("state"));
				function.setName(rs.getString("name"));
				function.setAffect(rs.getString("affect"));
				function.setPeriod(rs.getInt("period"));
				function.setContent(rs.getString("content"));
				function.setDescribe(rs.getString("descc"));
				function.setPrincipal(rs.getString("principal"));
				function.setCreateTime(rs.getDate("create_time"));
				function.setItemDemandMoid(rs.getString("item_demand_moid"));
				//function.setItemName(rs.getString("item_name"));
				function.setStartDate(rs.getDate("start_data"));
				function.setEntDate(rs.getDate("ent_data"));
				return function;
			}
		};
		personalMtMapperByItmeName = new RowMapper<Function>() {

			@Override
			public Function mapRow(ResultSet rs, int rowNum) throws SQLException {
				Function function = new Function();
				function.setId(rs.getInt("id"));
				function.setMoid(rs.getString("moid"));
				function.setState(rs.getInt("state"));
				function.setName(rs.getString("name"));
				function.setAffect(rs.getString("affect"));
				function.setPeriod(rs.getInt("period"));
				function.setContent(rs.getString("content"));
				function.setDescribe(rs.getString("descc"));
				function.setPrincipal(rs.getString("principal"));
				function.setCreateTime(rs.getDate("create_time"));
				function.setItemDemandMoid(rs.getString("item_demand_moid"));
				function.setStartDate(rs.getDate("start_data"));
				function.setEntDate(rs.getDate("ent_data"));
				return function;
			}
		};
	}

	/**
	 * 获取所有功能信息
	 * 
	 * @return
	 */
	private static final String ALL_FUNCTION_SQL = "select * from Function";

	public List<Function> allFunction() {
		List<Function> list = jdbcTemplate.query(ALL_FUNCTION_SQL, personalMtMapper);
		return list;
	}

	/**
	 * 根据功能Id获取功能信息
	 * 
	 * @param key：功能Id
	 * @return
	 */
	private static final String GET_FUNCTIONBYID_SQL = "select * from Function";

	public Function getFunctionById(String moid) {
		try {
			return jdbcTemplate.queryForObject(GET_FUNCTIONBYID_SQL, personalMtMapper, moid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * 新增功能信息
	 * 
	 * @param detail:功能信息
	 * @throws BusinessException
	 */
	private static final String ADD_FUNCTION_SQL = "insert into Function (moid, `name`, state, period, principal, content, descc, item_demand_moid, affect, create_time, start_data, ent_data) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public void saveFunction(Function function) {
		jdbcTemplate.update(ADD_FUNCTION_SQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				int i = 0;

				preparedStatement.setObject(++i, function.getMoid());
				preparedStatement.setObject(++i, function.getName());
				preparedStatement.setObject(++i, function.getState());
				preparedStatement.setObject(++i, function.getPeriod());
				preparedStatement.setObject(++i, function.getPrincipal());
				preparedStatement.setObject(++i, function.getContent());
				preparedStatement.setObject(++i, function.getDescribe());
				preparedStatement.setObject(++i, function.getItemDemandMoid());
				preparedStatement.setObject(++i, function.getAffect());
				preparedStatement.setObject(++i, function.getCreateTime());
				preparedStatement.setObject(++i, function.getStartDate());
				preparedStatement.setObject(++i, function.getEntDate());
			}
		});
	}

	/**
	 * 根据功能Id删除功能信息
	 * 
	 * @param key:功能Id
	 * @throws BusinessException
	 */
	private static final String DEL_Function_SQL = "delete from Function where moid = ?";

	public void delFunction(String moid) {
		jdbcTemplate.update(DEL_Function_SQL, moid);
	}

	/**
	 * 修改功能信息
	 * 
	 * @param key:功能Id
	 * @param detail：功能信息
	 * @throws BusinessException
	 */
	private static final String PUT_Function_SQL = "update Function set name = ?, state = ?, period = ?, principal = ?, content = ?, descc = ?, item_demand_moid = ?, affect = ?, start_data = ?, end_data = ? where moid = ?";

	public void updateFunction(Function function) {
		jdbcTemplate.update(PUT_Function_SQL, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				int i = 0;
				preparedStatement.setObject(++i, function.getName());
				preparedStatement.setObject(++i, function.getState());
				preparedStatement.setObject(++i, function.getPeriod());
				preparedStatement.setObject(++i, function.getPrincipal());
				preparedStatement.setObject(++i, function.getContent());
				preparedStatement.setObject(++i, function.getDescribe());
				preparedStatement.setObject(++i, function.getItemDemandMoid());
				preparedStatement.setObject(++i, function.getCreateTime());
				preparedStatement.setObject(++i, function.getStartDate());
				preparedStatement.setObject(++i, function.getEntDate());
				preparedStatement.setObject(++i, function.getMoid());
			}
		});
	}
	
	

	private static final String GET_BYITEMMOID_SQL = "select * from Function a where a.item_demand_moid = ?";

	public List<Function> getFunctionByItemMoid(String itemMoid) {
		List<Function> list = jdbcTemplate.query(GET_BYITEMMOID_SQL, personalMtMapperByItmeName, itemMoid);
		return list;
	}
}
