/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author Dasun Wickramasinghe
 */
public class BankApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Account user = new Account();
        
        while(true){
        String option ="0", accType="0"; 
        
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader =  new BufferedReader(inputReader);
        
        System.out.println("\n=========== DBW Bank PLC ===============");
        System.out.println("=========== Main Menu ================");
               
        System.out.println("\t1. Create a new Account");
        System.out.println("\t2. Deposit Money");
        System.out.println("\t3. Withdraw Money");
        System.out.println("\t4. Account Information");
        System.out.println("\t5. Logout");
        System.out.println("\t6. Exit");
        
        int optionCheck=0;
        while(optionCheck==0){
        
        System.out.print("\n Enter your option number :" );
        String tempOption = reader.readLine();
        
        
        if(tempOption.isEmpty()){
            System.out.println("You haven't selected an option." );
        }
        
        else{
            
           
            if(tempOption.equals("1") || tempOption.equals("2") || tempOption.equals("3")||tempOption.equals("4")|| tempOption.equals("5")|| tempOption.equals("6")) {
                option = tempOption;
                optionCheck =1;
                
            }
            else{ 
            System.out.println("Please enter a valid option number");
        }
  
    }
               

        }
        
     if(option.equals("1")){

         Account.userIn = "not_done";
         user.SetAccType();
         user.SetName();
         user.SetAddress();
         user.SetNIC();
         user.SetUsername();
         user.SetPassword();
         user.SetDeposit();
         user.setAccNo();
         Account.noCustomers = 0;
         user.GetDate();
        
     }  
     if(option.equals("2")){

         if(Account.userIn.equals("not_done")){
             user.CheckUsername();
             Account.checkContinue = "yes";
         }
         if(Account.userIn.equals("done")){
             Account.checkContinue = "yes";
             while(Account.checkContinue.equals("yes")){
                    if(Account.noCustomers == 0){
                    user.DepositMoney();
                    user.GetDate();
                    user.AskContinue();
                    }
                    else{
                             break;
                        }
              }
             
         }
         
         
         
     }
     if(option.equals("3")){

         if(Account.userIn.equals("not_done")){
             user.CheckUsername();
             Account.checkContinue = "yes";
         }
         
         if(Account.userIn.equals("done")){
             Account.checkContinue = "yes";
             while(Account.checkContinue.equals("yes")){
                    if(Account.noCustomers == 0){
                    user.Withdraw();
                    user.GetDate();
                    user.AskContinue();
                    }
                    else{
                             break;
                        }
              }
             
         } 
     }
     if(option.equals("4")){

         if(Account.userIn.equals("not_done")){
             user.CheckUsername();
             Account.checkContinue = "yes";
         }
         
         if(Account.userIn.equals("done")){
             Account.checkContinue = "yes";
             while(Account.checkContinue.equals("yes")){
                    if(Account.noCustomers == 0){
                    user.UserInfo();
                    user.AskContinue();
                    }
                    else{
                             break;
                        }
              }
             
         } 
     }
     
     if(option.equals("5")){
         user.Logout();
         user.GetDate();
     }
     if(option.equals("6")){
        System.out.println("\nThank you for using the application. Have a nice day!");
        user.GetDate();
        break;
     }

     
    }
        }
    
}
