package io.yaxche.orm;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity ( name =  "literaturerank" )
@Cacheable
public class LiteratureRank extends PanacheEntityBase implements Serializable {

//    @Column( unique = true )
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
//    @Column( name = "\"ArticleTitle\"" )  
    //                                  Don't need to quote the column identifiers
    //                                  in Postgres because of the hibernate orm setting:
    //                                  quarkus.hibernate-orm.database.globally-quoted-identifiers=true
    //                                  in application.properties.  Or just use lower-case
    //                                  and avoid the issues completely.
    @Column( name = "article_title" )
    public String articleTitle;
    @Column( name = "article_url" )
    public String articleURL;
    @Column( name = "publish_date" )
    public String publishDate;
    @Column( name = "pub_source" )
    public String pubSource;
    @Column( name = "search_source" )
    public String searchSource;
    
    public LiteratureRank() {        
    }
    

    public LiteratureRank( /*String LR_ID,*/ String articleTitle, String articleURL, String pubSource, String publishDate, String searchSource) {
        //this.LR_ID = LR_ID;
        this.articleTitle = articleTitle;
        this.articleURL = articleURL;
        this.pubSource = pubSource;
        this.publishDate = publishDate;
        this.searchSource = searchSource;
    }


}
