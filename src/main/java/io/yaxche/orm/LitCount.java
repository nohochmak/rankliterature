package io.yaxche.orm;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity ( name =  "litsearchcounts" )
@Cacheable
public class LitCount extends PanacheEntityBase implements Serializable {

//    @Column( unique = true )
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
//    @Column( name = "\"ArticleTitle\"" )  
    //                                  Don't need to quote the column identifiers
    //                                  in Postgres because of the hibernate orm setting:
    //                                  quarkus.hibernate-orm.database.globally-quoted-identifiers=true
    //                                  in application.properties
    @Column( name = "genename" )
    public String geneName;
    @Column( name = "totalpapers" )
    public Integer totalCountToDate;
    //                                  Of course thii isn't the way to do a moving window or
    //                                  time series, but we're in a bit of a hurry and it's a demo
    //                                  Each year should be a row of course, or be in a compound field that holds the time series in a JSON string or similar
    @Column( name = "yr2010" )
    public Integer yr2010;
    @Column( name = "yr2011" )
    public Integer yr2011;
    @Column( name = "yr2012" )
    public Integer yr2012;
    @Column( name = "yr2013" )
    public Integer yr2013;
    @Column( name = "yr2014" )
    public Integer yr2014;
    @Column( name = "yr2015" )
    public Integer yr2015;
    @Column( name = "yr2016" )
    public Integer yr2016;
    @Column( name = "yr2017" )
    public Integer yr2017;
    @Column( name = "yr2018" )
    public Integer yr2018;
    @Column( name = "yr2019" )
    public Integer yr2019;
    @Column( name = "yr2020" )
    public Integer yr2020;

    @Column( name = "searchsite" )
    public String searchSite;
    
    public LitCount() {        
    }

    public LitCount(String geneName, Integer totalCountToDate, Integer yr2010, Integer yr2011, Integer yr2012, Integer yr2013, Integer yr2014, Integer yr2015, Integer yr2016, Integer yr2017, Integer yr2018, Integer yr2019, Integer yr2020, String searchSite) {
        this.geneName = geneName;
        this.totalCountToDate = totalCountToDate;
        this.yr2010 = yr2010;
        this.yr2011 = yr2011;
        this.yr2012 = yr2012;
        this.yr2013 = yr2013;
        this.yr2014 = yr2014;
        this.yr2015 = yr2015;
        this.yr2016 = yr2016;
        this.yr2017 = yr2017;
        this.yr2018 = yr2018;
        this.yr2019 = yr2019;
        this.yr2020 = yr2020;
        this.searchSite = searchSite;
    }
    
    public static List<LitCount> findbyGeneName(String geneName) {
        return list("geneName", geneName);
    }


}
