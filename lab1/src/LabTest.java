
import MatrixLab.Matrix;
    public class LabTest {
        public static void main(String[] args)
        {
            double[][]arr={{2,5},{7,3}};
            double[][]arr1={{3,2},{1,6}};
            var a=new Matrix(arr);
            var b=new Matrix(arr1);
            var c=new Matrix(2,2);
            c=a.add(b);
            System.out.println(c.get(0,0));
            a.set(9,0,0);
            System.out.println(a.get(0,0));
            for(int i=0;i<c.getRows();i++)
            {
                for(int j=0;j<c.getCols();j++)
                {
                    System.out.print(c.get(i,j));
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
