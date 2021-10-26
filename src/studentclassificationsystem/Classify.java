package studentclassificationsystem;

public class Classify {
    
    static int totalData[][] = new int[1000][5] ;
    static int label[] = new int[1000] ;
    
    public static void main(String[] args)
    {
        Segment obj = new Segment() ;
        label = obj.getLabel() ;
        
        for(int k = 0 ; k < 1000 ; k++)
        {
            System.out.print(label[k] + " ") ;
        }        
    }    
}
