public class Main{
    public static void main(String[] args){
        ExpressionParser parser = new ExpressionParser();
        String[] expressions = {"2+4*3-8^3",
                "4*sin(0.5)+2*cos(2*0.5)",
                "log(64,2)*lg(100)",
                "mult(x,a)",
                "2*f*50",
                "e^2+1"};

        for(String expression:expressions){
            System.out.print(expression+"  ");
            try{
                double str = parser.Parse(expression);
                System.out.print(str+"\n");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}