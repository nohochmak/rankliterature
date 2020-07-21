package io.yaxche.orm;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity ( name =  "LiteratureRank" )
@Cacheable
public class LiteratureRankMizedCase extends PanacheEntityBase {

//    @Column( unique = true )
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    
//    @Column( name = "\"ArticleTitle\"" )  
    //                                  Don't need to quote the column identifiers
    //                                  in Postgres because of the hibernate orm setting:
    //                                  quarkus.hibernate-orm.database.globally-quoted-identifiers=true
    //                                  in application.properties
    @Column( name = "ArticleTitle" )
    public String articleTitle;
    @Column( name = "ArticleURL" )
    public String articleURL;
    @Column( name = "PublishDate" )
    public String publishDate;
    @Column( name = "PubSource" )
    public String pubSource;
    
    public LiteratureRankMizedCase() {        
    }
    

    public LiteratureRankMizedCase( /*String LR_ID,*/ String articleTitle, String articleURL, String pubSource, String publishDate) {
        //this.LR_ID = LR_ID;
        this.articleTitle = articleTitle;
        this.articleURL = articleURL;
        this.pubSource = pubSource;
        this.publishDate = publishDate;
    }


}
