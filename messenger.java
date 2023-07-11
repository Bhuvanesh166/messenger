import java.util.*;
import java.util.regex.Pattern;


interface MessagingService{
    void sendMessage();
}
class SMSMessagingService implements MessagingService{
          String msg="";
          public  void sendMessage(){
                  System.out.println(msg+" sms send successfully");
              }
     public boolean validateNumber(String mobilenumber){
      String mob=(mobilenumber);
      if(mobilenumber.length()!=10 || Integer.parseInt(String.valueOf(mob.charAt(0)))<6){
                  return false;
              }
              else {
                  return true;
              }


              }



}

class EmailMessagingService implements MessagingService{
    String email="";
    String body="";
   public  void sendMessage(){
        System.out.println("Successfully emailed to "+email);
    }
   
public  boolean validateEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&-]+)@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    
}

class WhatsAppMessagingService implements MessagingService {
    String msg="";
    public void sendMessage() {
        System.out.println(msg+"Message send Successfully ");
    }
           public boolean validateNumber(String  mobilenumber,boolean iswhatsapp){
         String mob=(mobilenumber);
              if(mob.length()!=10 || Integer.parseInt(String.valueOf(mob.charAt(0)))<6 || iswhatsapp==false){
                  return false;
              }
              else {
                  return true;
              }


              }
                        
        public static void main(String[] args) {
       Message msg=new Message();
        SMSMessagingService sms1=new SMSMessagingService();
         
   EmailMessagingService email1=new EmailMessagingService();
        
      WhatsAppMessagingService whats1=new WhatsAppMessagingService();
        
            Scanner scanner = new Scanner(System.in);
            int v=0;
            do{
            System.out.println("Enter 1 for SMS");
            System.out.println("Enter 2 for Email");
            System.out.println("Enter 3  for Whatsapp");
            System.out.println("Enter 0 for exit");
            int choice = scanner.nextInt();
            v=choice;
            if(choice==1){
           System.out.println("Enter mobile number ");
                
       String mobileNumber=scanner.next();
            if(sms1.validateNumber(mobileNumber)){
         System.out.println("Enter the message")  ;
         String mesg=scanner.next();
         sms1.msg=mesg;
             msg.display(sms1); 
                }
                else{
                    System.out.println("Invalid mobile number");
            }
            
            }
            if(choice==2){
            System.out.println("Enter email id");
                String to=scanner.next();
           if(email1.validateEmail(to)){
                    System.out.println("Type the message");
          String bdy=scanner.next();
              email1.email=to;
              email1.body=bdy;
              msg.display(email1);
                }
                else{
                    System.out.println("Invalid Email");
                }
            }
            if(choice==3){
            System.out.println("Enter mobile number") ;
            
                              
           String mobileNumber=scanner.next();
               if(whats1.validateNumber(mobileNumber,true)){
            System.out.println("Type the message");      
         String mesg=scanner.next();
         whats1.msg=mesg;
             msg.display(whats1) ;   
                }
                else{
                    System.out.println("Invalid mobile number");
            }
            }
            }while(v!=0);
}
}

    class Message{
    public void display(MessagingService m){
        m.sendMessage();
    }
    }