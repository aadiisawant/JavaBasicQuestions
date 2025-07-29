class IsValidAgeException extends Exception{
    public IsValidAgeException(String message){
        super(message);
    }
}
public class CustomException {
    public static void drivingL(int age) throws IsValidAgeException{
        if(age<18){
            throw new IsValidAgeException("Illegel age to Drive...");
        }else{
            System.out.println("It's a Valid age.");;
        }
    }
    public static void main(String args[]){
        try{
            drivingL(18);
        }catch(IsValidAgeException e){
            System.out.println("Exception : "+e.getMessage());
        }
    }
}
