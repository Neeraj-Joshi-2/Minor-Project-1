package studentclassificationsystem;
import java.sql.*;

public class Classify {
    
    int data[][] = new int[1100][4],i,l,i1=0,i2=1,i3=2,i4=3 ;
    int label[] = new int[1100] ;
    int len ;
    
    Classify()
    {
        conn ccc = new conn();
        len = 0 ;
        i=0;
        try 
        {
            
            String query1 = "select * from students";                
            ResultSet rs = ccc.s.executeQuery(query1);

            while (rs.next()) 
            {            
                data[i][i1] = rs.getInt(3) ;
                data[i][i2] = rs.getInt(4) ;
                data[i][i3] = rs.getInt(5) ;
                data[i][i4] = rs.getInt(6) ;
                
                i+=1 ;
                len +=  1 ;                
            }   
        }catch(Exception e){
            e.printStackTrace();
            }
        
        try
        {
            l=0;
            String query2 = "select * from label" ;
            ResultSet rs2 = ccc.s.executeQuery(query2) ;
            
            while(rs2.next())
            {
                label[l] = rs2.getInt(1) ;
                l+=1 ;
            }
           
        }catch(Exception e){
            e.printStackTrace();
            }
    }
    
    public static void main(String[] args)
    {
        Classify obj = new Classify() ;
        
        for(int i = 0 ; i < 1000 ; i++)
        {
            for(int k = 0 ; k < 4 ; k++)
            {
                System.out.print(obj.data[i][k] + " ") ;
            } 
            System.out.println() ;
        }
        
        System.out.println("\n\nLABELS\n") ;
        
        for(int k = 0 ; k < 1000 ; k++)
        {
            System.out.print(obj.label[k] + " ") ;
        }
              
    }    
}
