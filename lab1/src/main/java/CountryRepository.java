
import org.hibernate.validator.constraints.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {

            Country hungary = new Country();
		    hungary.setName("Hungary");
    		hungary.setCapital("Budapest");
    		hungary.setCurrency(Currency.HUF);
	    	hungary.setPopulation(9778371);

		    countries.put(hungary.getName(), hungary);

		    Country lithuania = new Country();
		    lithuania.setName("Lithuania");
    		lithuania.setCapital("Vilnius");
    		lithuania.setCurrency(Currency.EUR);
	    	lithuania.setPopulation(2797184);

		    countries.put(lithuania.getName(), lithuania);

            Country czech = new Country();
		    czech.setName("Czech");
    		czech.setCapital("Prague");
    		czech.setCurrency(Currency.CZK);
	    	czech.setPopulation(10538275);

		    countries.put(czech.getName(), czech);

    }

    public Country findCountry(String name) {
        Assert.notNull(name, "Странна не заданна, необходимо указать страну");
        return countries.get(name);
    }
}