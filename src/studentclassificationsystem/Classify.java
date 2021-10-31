package studentclassificationsystem;
import java.sql.*;
import java.util.Random;

public class Classify {
    
    static int data[][] = new int[1100][4],i,l,i1=0,i2=1,i3=2,i4=3 ;
    static int label[][] = new int[1100][3] ;
    static int trainData[][] = new int[800][4], testData[][] = new int[250][4] ;
    static int trainLabel[][] = new int[800][3], testLabel[][] = new int[250][3] ;
    static int len ,n_x=4,n_y=3,n_h=800 , iterations = 10;
    static double w1[][] = new double[n_h][n_x] ; 
    static double b1[][] = new double[n_h][1] ;
    static double w2[][] = new double[n_y][n_h] ; 
    static double b2[][] = new double[n_y][1] ;
    static double learningRate = 0.02 ;
    static double z1[][] = new double[n_h][800], a1[][] = new double[n_h][800] ;
    static double z2[][] = new double[n_y   ][800], a2[][] = new double[n_y][800] ;
    
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
                if(rs2.getInt(1)==0)
                {
                    label[l][0] = 1 ;
                    label[l][1] = 0 ;
                    label[l][2] = 0 ;
                }
                if(rs2.getInt(1)==1)
                {
                    label[l][0] = 0 ;
                    label[l][1] = 1 ;
                    label[l][2] = 0 ;
                }
                if(rs2.getInt(1)==2)
                {
                    label[l][0] = 0 ;
                    label[l][1] = 0 ;
                    label[l][2] = 1 ;
                }
                
                l+=1 ;
            }
           
        }catch(Exception e){
            e.printStackTrace();
            }
    }
    
    public static void printData()
    {
        for(int i = 0 ; i < 1000 ; i++)
        {
            for(int k = 0 ; k < 4 ; k++)
            {
                System.out.print(data[i][k] + " ") ;
            } 
            System.out.println() ;
        }
        
        System.out.println("\n\nLABELS\n") ;
        
        for(int k = 0 ; k < len ; k++)
        {
            for(int i = 0 ; i < 3 ; i++)
            {
                System.out.print(label[k][i] + " ") ;
            } 
            System.out.println() ;
        }
    }
    
    public static void splitData()
    {
        int k = 0 ;
        for(int i = 0 ; i < len ; i++)
        {
            for(int j = 0 ; j < 4 ; j++)
            {
                if(i<800)
                {
                    trainData[i][j] = data[i][j] ;
                }
                else
                {
                    testData[k][j] = data[i][j] ;
                    if(j==3)
                    {
                        k+=1 ;
                    }
                }
                
            } 
        }
        int a = 0 ;
        for(int i = 0 ; i < len ; i++)
        {
            for(int j = 0 ; j < 3 ; j++)
            {
                if(i<800)
                {
                    trainLabel[i][j] = label[i][j] ;
                }
                else
                {
                    testLabel[a][j] = label[i][j] ;
                    if(j==2)
                    {
                        a+=1 ;
                    }
                }
                
            } 
        }
        
//        for(int i = 0 ; i < 200 ; i++)
//        {
//            for(int j = 0 ; j < 3 ; j++)
//            {
//                System.out.print(testLabel[i][j] + " ") ;
//            } 
//            System.out.println() ;
//        }     
    }
    
    public static void initialize_parameters()
    {
        Random r = new Random();
//        double max = 0.015 ;
//        double min = -0.015 ;
        
        for(int i = 0 ; i < n_h ; i++)
        {
            for(int j = 0 ; j < n_x ; j++)
            {
                w1[i][j] = r.nextDouble();
            } 
        }
        for(int i = 0 ; i < n_h ; i++)
        {
            b1[i][0] = 0;
        }
        for(int i = 0 ; i < n_y ; i++)
        {
            for(int j = 0 ; j < n_h ; j++)
            {
                w2[i][j] = r.nextDouble();
            } 
        }
        for(int i = 0 ; i < n_y ; i++)
        {
            b2[i][0] = 0;  
        }
        
        
//        for(int i = 0 ; i < n_h ; i++)
//        {
//            for(int j = 0 ; j < n_x ; j++)
//            {
//                System.out.print(w1[i][j] + " ") ;
//            } 
//            System.out.println() ;
//        }
        
    }
    
    public static void tanh()
    {
        for (int c = 0; c < 800; c++)
        {
            for (int d = 0; d < 800; d++)
            {
                a1[c][d] = (Math.exp(z1[c][d]) - Math.exp(-z1[c][d])) / (Math.exp(z1[c][d]) + Math.exp(-z1[c][d]));
            }
        }
    }
    
    public static void softmax()
    {       
        for (int c = 0; c < 3; c++)
        {
            for (int d = 0; d < 800; d++)
            {
                a2[c][d] = Math.exp(z2[c][d]) ;
            }
        }
        
        double sum = 0 ;
        
        for (int c = 0; c < 800; c++)
        {
            for (int d = 0; d < 3; d++)
            {
                sum = sum + a2[d][c] ;
            }
           
            for (int i = 0; i < 3; i++)
            {
                a2[i][c] = a2[i][c] / sum ;
            }     
            sum = 0 ;
        }
    }

    public static void forwardPropagation()
    {
        double trainData_T[][] = new double[4][800] ;
        //transpose of feature array
        for (int i = 0; i < 800; ++i)
        {
            for (int j = 0; j < 4; ++j)
            {
                trainData_T[j][i] = trainData[i][j];
            }
        }
        
        //z1 = np.dot(w1, x) + b1
        double sum=0;
        for (int c = 0; c < 800; c++)
        {
            for (int d = 0; d < 800; d++)
            {
                for (int k = 0; k < 4; k++)
                {
                    sum = sum + w1[c][k] * trainData_T[k][d];
                }

                z1[c][d] = sum;
                sum = 0;
            }
        }
        for (int c = 0; c < 800; c++)
        {
            for (int d = 0; d < 800; d++)
            {
                z1[c][d] = z1[c][d] + b1[c][0];
            }
        }
        //a1 = tanh(z1)
        tanh() ;
        
        //z2 = np.dot(w2, a1) + b2
        for (int c = 0; c < 3; c++)
        {
            for (int d = 0; d < 800; d++)
            {
                for (int k = 0; k < 3; k++)
                {
                    sum = sum + w2[c][k] * a1[k][d];
                }
                z2[c][d] = sum;
                sum = 0;
            }
        }
        
        //a2 = softmax(z2)
        softmax() ;
    } 
    
    public static void backwardPropagation()
    {
        
    }
    
   
    public static void model(int itr , double learning_rate)
    {
        splitData() ;
        initialize_parameters() ;
        int temp = 0 ;
        while(temp<itr)
        {
            forwardPropagation() ;
            backwardPropagation() ;
        }       
    }
    
    public static void main(String[] args)
    {
        Classify obj = new Classify() ;
//        printData() ;
        
        splitData() ;  
        initialize_parameters() ;
        forwardPropagation() ;

//        model(iterations , learningRate);  

        for(int i = 0 ; i < 3 ; i++)
        {
            for(int j = 0 ; j < 800 ; j++)
            {
                System.out.print(a2[i][j] + " ") ;
            } 
            System.out.println() ;
        }

           
    }    
}
