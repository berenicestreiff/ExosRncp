package com.berenice.springConfigDeTestJUNIT.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

// avec jdbc template  ajout dans pom.xml
// crud de base

public class MessageDAOImpl implements RowMapper<Message>, MessageDAO {
	
private static final String SELECT_ALL= "select*from message";
private static final String SELECT_BY_ID= "select*from message where id=?";
private static final String UPDATE_ONE= "update message set titre=?,coprs=?where id=?";
private static final String INSERT_ONE= "insert into message(titre,corps)VALUES(?,?)";


private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;}

/* (non-Javadoc)
 * @see com.berenice.springConfigDeTestJUNIT.beans.MessageDAO#findAll()
 */
@Override
public List <Message>findAll(){
return getJdbctemplate().query(SELECT_ALL,this);
}


/* (non-Javadoc)
 * @see com.berenice.springConfigDeTestJUNIT.beans.MessageDAO#findById(int)
 */
@Override
public Message findById(int id){
	return getJdbctemplate().queryForObject(SELECT_BY_ID, this,id);
}


/* (non-Javadoc)
 * @see com.berenice.springConfigDeTestJUNIT.beans.MessageDAO#save(com.berenice.springConfigDeTestJUNIT.beans.Message)
 */
@Override
public int save (Message m){
	if (m.getId()>0){
		return getJdbctemplate().update(INSERT_ONE,m.getTitre(),m.getCorps());
	}
	else{
		return getJdbctemplate().update(UPDATE_ONE,m.getTitre(),m.getCorps(),m.getId());
	}
}

@Override
public Message mapRow(ResultSet rs, int pos) throws SQLException {
	// TODO Auto-generated method stub
	return new Message(rs.getInt("id"),rs.getString("titre"),rs.getString("corps"));
}

}

