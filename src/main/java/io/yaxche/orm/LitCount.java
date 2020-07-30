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
    @Column( name = "unipid" )
    public String uniprotID;
    @Column( name = "pdbid" )
    public String pdbID;
    @Column( name = "geneid" )
    public String geneID;
    @Column( name = "aliaseskeywords" )
    public String aliasesKeywords;
    @Column( name = "proteinfunction" )
    public String proteinFunction;
    @Column( name = "description" )
    public String description;
    @Column( name = "smedesc" )
    public String smeDesc;
    @Column( name = "targetscore" )
    public String targetScore;
    @Column( name = "totalpapers")
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
    @Column( name = "slope" )
    public Double slope;
    @Column( name = "ry2017" )
    public Double ry2017;
    @Column( name = "ry2018" )
    public Double ry2018;
    @Column( name = "ry2019" )
    public Double ry2019;


    @Column( name = "inemerging" )
    public String inEmerging;
    @Column( name = "inhot" )
    public String inHot;
    @Column( name = "inprocess" )
    public String inProcess;
    @Column( name = "inreview" )
    public String inReview;
    @Column( name = "inshortnom" )
    public String inShortNom;
    @Column( name = "inselected" )
    public String inSelected;

    
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

    public static List<LitCount> findbyUniPID(String unipID) {
        return list("unipid", unipID);
    }

    @Override
    public String toString() {
        return "LitCount{" + "id=" + id + ", geneName=" + geneName + ", uniprotID=" + uniprotID + ", pdbID=" + pdbID + ", geneID=" + geneID + ", aliasesKeywords=" + aliasesKeywords + ", proteinFunction=" + proteinFunction + ", description=" + description + ", smeDesc=" + smeDesc + ", targetScore=" + targetScore + ", totalCountToDate=" + totalCountToDate + ", yr2010=" + yr2010 + ", yr2011=" + yr2011 + ", yr2012=" + yr2012 + ", yr2013=" + yr2013 + ", yr2014=" + yr2014 + ", yr2015=" + yr2015 + ", yr2016=" + yr2016 + ", yr2017=" + yr2017 + ", yr2018=" + yr2018 + ", yr2019=" + yr2019 + ", yr2020=" + yr2020 + ", searchSite=" + searchSite + ", slope=" + slope + ", ry2017=" + ry2017 + ", ry2018=" + ry2018 + ", ry2019=" + ry2019 + ", inEmerging=" + inEmerging + ", inHot=" + inHot + ", inProcess=" + inProcess + ", inReview=" + inReview + ", inShortNom=" + inShortNom + ", inSelected=" + inSelected + '}';
    }



}
