/**
 * 
 */
package dao;

import domain.Country;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author it.vaclav.kiev.ua
 * 
 */

public class HsqlCountryDao extends JdbcDaoSupport implements CountryDao {

	private static Log log = LogFactory.getLog(HsqlCountryDao.class);

	public void insert(Country country) {

		if (country != null) {
			log.debug( "Processing country: " + country);
			this.getJdbcTemplate().update(
					"insert into country (name) values (?)",
					country.getName());

		} else {
			log.debug("Domain country is null!");
		}
	}

	public Country select(int id) {

		Country country = null;

		if (id > 0) {
			country = this.getJdbcTemplate().queryForObject(
					"select id, name from country where id = ?",
					new Object[] { id }, new CountryMapper());
		}
		log.debug("Receidved country: " + country);
		
		return country;
	}

	public List<Country> selectAll() {
		return this.getJdbcTemplate().query(
				"select id, name from country"
				, new CountryMapper());
	}

	private static final class CountryMapper implements RowMapper<Country> {

		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();
			country.setId(rs.getInt("id"));
			country.setName(rs.getString("name"));
			return country;
		}
	}
}
