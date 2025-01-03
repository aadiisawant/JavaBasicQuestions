class IsValidAgeException extends Exception{
    public IsValidAgeException(String message){
        super(message);
    }
}
public class CustomException {
    public static void divide(int num1 , int num2) throws IsValidAgeException{
        if(num2==0){
            throw new IsValidAgeException("cannot divide by zero");
        }else{
            int num = num1/num2;
        }
    }
    public static void main(String args[]){
        try{
            divide(10,0);
        }catch(IsValidAgeException e){
            System.out.println("Exception : "+e.getMessage());
        }
    }
}
