package dao.jpa;

import dao.CountryDao;
import model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    public void save(Country country) {
//		TODO: Implement it
        EntityManager em = null;

        if (em != null) {
            em.close();
        }
    }

    public List<Country> getAllCountries() {
//	TODO: Implement it
        return null;
    }// getAllcountries()

    public Country getCountryByName(String name) {
//		TODO: Implement it

        return null;
    }

}
