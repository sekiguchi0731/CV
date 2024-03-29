import java.io.*;

class Co
{
        static final int N=4;   //未知数の個数
}

public class Gauss {
        static double a[][]={{1.0,1.0,-3.0,-4.0,-1.0},{2.0,1.0,5.0,1.0,5.0},
                            {3.0,6.0,-2.0,1.0,8.0},{2.0,2.0,2.0,-3.0,2.0}}; //解きたい連立方程式より
        static double x[]=new double[Co.N];
        static double b[][]=new double[1][Co.N+1];

        public static void main(String[] args) {
                int i,j,k,l,pivot;
                double p,q,m;

                for(i=0;i<Co.N;i++) 
                {
                        m=0;
                        pivot=i;

                        for(l=i;l<Co.N;l++) 
                        {
                                if(Math.abs(a[l][i])>m) //i列の中で一番値が大きい行を選ぶ 
                                {   
                                        m=Math.abs(a[l][i]);
                                        pivot=l;
                                }
                        }

                        if(pivot!=i)    //pivotがiと違えば、行の入れ替え 
                        {                          
                                for(j=0;j<Co.N+1;j++) 
                                {
                                        b[0][j]=a[i][j];        
                                        a[i][j]=a[pivot][j];
                                        a[pivot][j]=b[0][j];
                                }
                        }
                }

                for(k=0;k<Co.N;k++) 
                {
                        p=a[k][k];              //対角要素を保存
                        a[k][k]=1;              //対角要素は１になることがわかっているから

                        for(j=k+1;j<Co.N+1;j++) 
                        {
                                a[k][j]/=p;
                        }

                        for(i=k+1;i<Co.N;i++) 
                        {
                                q=a[i][k];

                                for(j=k+1;j<Co.N+1;j++) 
                                {
                                        a[i][j]-=q*a[k][j];
                                }
                                a[i][k]=0;              //0となることがわかっているところ
                        }
                }

/*解の計算*/
                for(i=Co.N-1;i>=0;i--) 
                {
                        x[i]=a[i][Co.N];
                        for(j=Co.N-1;j>i;j--) 
                        {
                                x[i]-=a[i][j]*x[j];
                        }
                }

/*行列が最後どうなったかみる*/

        for(i=0;i<Co.N;i++) {
                for(j=0;j<Co.N+1;j++) {
                        System.out.print(a[i][j] + " ");
                }
                System.out.println("");
                
        }

                System.out.println("解は");
                for(i=0;i<Co.N;i++) 
                {
                        System.out.println(x[i]);
                }

        }
}
