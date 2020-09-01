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
//    @Column( name = "totalpapers")
//    public Integer totalCountToDate;
    @Column( name = "linreg")
    public String linReg;

    @Column( name = "pubbyyr" )
    public String pubByYr;
    @Column( name = "hallmarkscancer" )
    public String hallMarksCancer;
    @Column( name = "discometrics" )
    public String discoMetrics;
    
 
    
    
    
//    @Column( name = "slope" )
//    public Double slope;
//    @Column( name = "ry2017" )
//    public Double ry2017;
//    @Column( name = "ry2018" )
//    public Double ry2018;
//    @Column( name = "ry2019" )
//    public Double ry2019;


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

    public LitCount( String geneName ) {
        this.geneName = geneName;
        
    }
    
    public static List<LitCount> findbyGeneName(String geneName) {
        return list("geneName", geneName);
    }

    public static List<LitCount> findbyUniPID(String unipID) {
        return list("unipid", unipID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LitCount{id=").append(id);
        sb.append(", geneName=").append(geneName);
        sb.append(", uniprotID=").append(uniprotID);
        sb.append(", pdbID=").append(pdbID);
        sb.append(", geneID=").append(geneID);
        sb.append(", aliasesKeywords=").append(aliasesKeywords);
        sb.append(", proteinFunction=").append(proteinFunction);
        sb.append(", description=").append(description);
        sb.append(", smeDesc=").append(smeDesc);
        sb.append(", targetScore=").append(targetScore);
        sb.append(", linReg=").append(linReg);
        sb.append(", pubByYr=").append(pubByYr);
        sb.append(", hallMarksCancer=").append(hallMarksCancer);
        sb.append(", discoMetrics=").append(discoMetrics);
        sb.append(", inEmerging=").append(inEmerging);
        sb.append(", inHot=").append(inHot);
        sb.append(", inProcess=").append(inProcess);
        sb.append(", inReview=").append(inReview);
        sb.append(", inShortNom=").append(inShortNom);
        sb.append(", inSelected=").append(inSelected);
        sb.append('}');
        return sb.toString();
    }



}
