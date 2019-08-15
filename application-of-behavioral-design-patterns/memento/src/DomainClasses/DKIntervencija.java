

package DomainClasses;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DKIntervencija implements Serializable, GeneralDObject {
  
    private int SifraIntervencije;
    private String JMBG;
    private int SifraStomatologa;
    private String Usluga;
    private java.util.Date Datum;
    
    public DKIntervencija() 
    {   SifraIntervencije=0;			   
        JMBG="";			   
        SifraStomatologa=0;			   
        Usluga="Popravka";			   
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        Datum = java.sql.Date.valueOf(sm.format(dDatum)); 
    }

    public DKIntervencija(int SifraIntervencije, String JMBG, int SifraStomatologa, String Usluga, Date Datum)  	
    {   this.SifraIntervencije = SifraIntervencije;
        this.JMBG = JMBG;
        this.SifraStomatologa = SifraStomatologa;
        this.Usluga = Usluga;
        this.Datum = Datum;
    }   
    
    public DKIntervencija(DKIntervencija state)  	
    {   this.SifraIntervencije = state.SifraIntervencije;
        this.JMBG = state.JMBG;
        this.SifraStomatologa = state.SifraStomatologa;
        this.Usluga = state.Usluga;
        this.Datum = state.Datum;
    }
    
   	
    public DKIntervencija(int SifraIntervencije)  	
    {   this.SifraIntervencije = SifraIntervencije;
    }

    public int getSifraIntervencije(){ return SifraIntervencije;} 
    public String getJMBG(){ return JMBG;} 
    public int getSifraStomatologa(){ return SifraStomatologa;} 
    public String getUsluga(){ return Usluga;} 
    public Date getDatum(){ return Datum;} 

    public void setSifraIntervencije(int SifraIntervencije){this.SifraIntervencije = SifraIntervencije;}
    public void setJMBG(String JMBG){this.JMBG = JMBG;}
    public void setSifraStomatologa(int SifraStomatologa){this.SifraStomatologa = SifraStomatologa;}
    public void setUsluga(String Usluga){this.Usluga = Usluga;}
    public void setDatum(Date Datum){this.Datum = Datum;}
    @Override
    public String getNameByColumn(int column)
        { String names[] = {"SifraIntervencije","JMBG","SifraStomatologa","Usluga","Datum"}; 
          return names[column];
        }		
 
    @Override
    public GeneralDObject getNewRecord(ResultSet rs)  throws SQLException
    {return new DKIntervencija(rs.getInt("SifraIntervencije"),rs.getString("JMBG"),rs.getInt("SifraStomatologa"),rs.getString("Usluga"),rs.getDate("Datum"));} 
    @Override
    public String getAtrValue() {return SifraIntervencije + ", " + (JMBG == null ? null : "'" + JMBG + "'") + ", " + SifraStomatologa + ", " + "Usluga=" + (Usluga == null ? null : "'" + Usluga + "'") + ',' + "'" + Datum + "'";}
    @Override
    public String setAtrValue(){return "SifraIntervencije=" + SifraIntervencije + ", " + "JMBG=" + (JMBG == null ? null : "'" + JMBG + "'") + ", " + "SifraStomatologa=" + SifraStomatologa + ", " + "Usluga=" + (Usluga == null ? null : "'" + Usluga + "'") + ',' + "Datum=" + "'" + Datum + "'";}
    @Override
    public String getClassName(){return "DKIntervencija";}
    @Override
    public String getWhereCondition(){return "SifraIntervencije = " + SifraIntervencije;}
}



    
    
    
