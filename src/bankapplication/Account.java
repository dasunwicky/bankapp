/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dasun Wickramasinghe
 */


public class Account {
    
    static int noCustomers = 0;
    static String userIn = "not_done", checkContinue = "yes";
    private int  balancePosition, invalid = 5;
    private ArrayList details = new ArrayList();
    private String  name,username="empty",password,address,accType,NIC,accNo;
    private double Balance;
    
    Date date = new Date();

    InputStreamReader inputReader = new InputStreamReader(System.in);
    BufferedReader reader =  new BufferedReader(inputReader);
    
    public void GetDate(){
        System.out.println("("+date.toString()+")");
    }
    /**
     * @param accType the accType to set
     */
    public void SetAccType() throws IOException {
        System.out.println("======== Create a new Account ============");
        System.out.println("\t1. Savings Account");
         System.out.println("\t2. Current Account");
         int accTypeCheck=0;
         
         while(accTypeCheck==0){

             System.out.print("Please select an account type:");
             String accTypeTemp = reader.readLine();
             
             if(accTypeTemp.isEmpty()){
                 System.out.println("You haven't selected an account type.");
             }
             else{
                 
                 
                 if(accTypeTemp.equals("1")||accTypeTemp.equals("2")){
                     details.add(accTypeTemp);
                     accTypeCheck =1;    
                 }
                 else{
                     System.out.println("Please enter a valid account type");
                 }
                 
             }

    }
    }


    /**
     * @param NIC the NIC to set
     */
    public void SetNIC() throws IOException {
        
        while(true){
        try{
            System.out.print("NIC no (Ignore 'V'):");
            Scanner in = new Scanner(System.in);
            int NICtemp = in.nextInt();
            String NICstring = Integer.toString(NICtemp);
            details.add(NICstring);
            break;
            
        }
        catch(InputMismatchException e){
             System.out.println("It does not seem to be your NIC number. Please enter it again");
         }
        } 
        
    }

    /**
     * @param name the name to set
     */
    public void SetName() throws IOException {

         while(true){
         System.out.print("Name:");
         String tempName = reader.readLine();
         
         if(tempName.isEmpty()){
          System.out.println("Name field can't be empty! :");  
         }
         else{
             details.add(tempName);
             break;
         }
         
         }    
    }


    /**
     * @param address the address to set
     */
    public void SetAddress() throws IOException {
        
        while(true){ 
        System.out.print("Address:");
        String tempAddress = reader.readLine();
        
        if(tempAddress.isEmpty()){
            System.out.println("Address field can't be empty!");
        }
        else{
            details.add(tempAddress);
            break;
        }

        }

    }

    /**
     * @param password the password to set
     */
    public void SetPassword() throws IOException {
        
        while(true){
        System.out.print("Password:");
        String tempPassword = reader.readLine();
        
        if(tempPassword.isEmpty()){
            System.out.println("Password field can't be empty!");
        }
        else{
            details.add(tempPassword);
            break;
        }
        
        
        }  
 
    }

    /**
     * @param Deposit the Deposit to set
     */
    public void SetDeposit() {
        
        while(true){
        try{
            System.out.print("Deposit(LKR):");
            Scanner in = new Scanner(System.in);
            double deposit = in.nextDouble();
            String tempDeposit = Double.toString(deposit);
            
            if(tempDeposit.isEmpty()){
                System.out.println("Password field can't be empty!");    
            }
            else if(deposit<500){
                System.out.println("Minimum deposit is 500 LKR");
                
            }
            else{
                details.add(tempDeposit);
                break;
            }
                

        }
        catch(InputMismatchException e){
             System.out.println("Invalid amount! Please enter again. ");
         }
        
        
    }
    }

    /**
     * @param username the username to set
     */
    public void SetUsername() throws IOException {
        int usernameExist=0;
        while(true){
            
            System.out.print("Username:");
            String tempUsername = reader.readLine();
            
            if(tempUsername.isEmpty()){
                System.out.println("Username field can't be empty!");  
            }
            else{
                if(details.size()<5){
                        details.add(tempUsername);
                        this.username = tempUsername; 
                        break;
                }
                else{
                    
               
                for(int i=4; i<details.size(); i=i+7){
                String userNameExist = details.get(i).toString();
                
                    if(userNameExist.equals(tempUsername)){
                        System.out.println("Username already exists! Try with a different one.");
                        usernameExist = 1; 
                        break;
                    }
                    else{
                        usernameExist = 0;
                    }

                    }
                if(usernameExist==0){
                    details.add(tempUsername);
                    this.username = tempUsername;
                    break;
                }
                }
            }
            }   
        }  
    public void CheckUsername() throws IOException, InterruptedException {

            int invalidCount=0, checkuser=0;
            if(username=="empty"){
                 System.out.println("The bank has no customers at the moment.");
                 noCustomers = 1;
            }
            else{
                
           while(checkuser==0 && invalidCount<3){
              
              String InputUsername;
              while(true){
                System.out.print("Username:");
                InputUsername = reader.readLine();
                if(InputUsername.isEmpty()){
                    System.out.println("Please enter your username");
                }
                else{  
                    break;  
                }
              }
              
              String InputPassword;
              while(true){
              System.out.print("Password:");
              InputPassword = reader.readLine();
              
                if(InputPassword.isEmpty()){
                    System.out.println("Please enter your password");
                }
                else{
                    break;
                }
              }
              
              for(int i=4; i< details.size(); i=i+8){
                  String tempuser = details.get(i).toString();
                  String tempPassword = details.get(i+1).toString();
                  String tempname = details.get(i-3).toString();
                  String tempBal = details.get(i+2).toString();
                  String tempAddress = details.get(i-2).toString();
                  String tempAccType = details.get(i-4).toString();
                  String tempNIC = details.get(i-1).toString();
                  String tempAccNo = details.get(i+3).toString();
                  double tempBalance = Double.valueOf(tempBal);
                  
                  
                  if(tempuser.equals(InputUsername) && tempPassword.equals(InputPassword)){
                      this.username = tempuser;
                      this.password = tempPassword;
                      this.name = tempname;
                      this.Balance = tempBalance;
                      this.address = tempAddress;
                      this.accType = tempAccType;
                      this.NIC = tempNIC;
                      this.accNo = tempAccNo;
                      this.balancePosition = i+2;
                      
                      userIn = "done";
                      checkuser =1;
                      
                      
                  }
                  
              }
              if(userIn=="not_done"){
                     invalidCount++;
                     System.out.println("Invalid Username or Password! You have "+ (3-invalidCount) + " more attempt(s)"); 
                     
                     if(invalidCount==3){
                          System.out.println("\nSystem halted! You will return to the main menu after "+invalid+" second(s)");
                          int k=0;
                          while(k<invalid){
                              Thread.sleep(1000);
                              System.out.print(". ");
                              k++;
                          }
                          System.out.print("\n");
                          invalid = invalid*2;
                          break;
                     }
                  }
           }
              
                } 
            
                }

    public void AskContinue() throws IOException{
        
        System.out.print("\nType 'yes' to continue or type any key to return to the main menu.>");
        String tempcontinue = reader.readLine();
        
        if(tempcontinue.equals("yes")){
            checkContinue = "yes";
        }
        else{
            checkContinue = "no";
        }
        
    }
    
    public void setAccNo(){
        Random random = new Random();
        int randomNo = random.nextInt(1000000000);
        String accNum = Integer.toString(randomNo);
        details.add(accNum);
        System.out.println("\nAccount created sucessfully. Your account number is "+accNum);
    }
    
    public void Logout(){
        if(userIn.equals("done")){
            userIn = "not_done";
            System.out.println("You have successfully logged out of the system.");
        }
        else{
            System.out.println("You are not logged in.");
        }
        
}
    
    public void UserInfo(){
        System.out.println("------ Account Information ------");
        System.out.println("\nName: "+name);
        System.out.println("Address: "+address);
        System.out.println("NIC No: "+NIC+"V");

        if(accType.equals("1")){
            System.out.println("Account type: Savings");
        }
        if(accType.equals("2")){
            System.out.println("Account type: Current");
        }
        System.out.println("Account No: "+accNo);
        System.out.println("Balance: "+Balance+" LKR");
}
    
    public void DepositMoney(){
        
        int depo =0; 
        double depositAmount=0;
        System.out.println("\nWelcome "+name);
        System.out.println("------ Deposit Money ------");
        
        
        while(depo==0){
            try{
                System.out.print("Amount(LKR):");
                Scanner in = new Scanner(System.in);
                depositAmount = in.nextDouble();
                depo = 1;
            }
                catch(InputMismatchException e){
                System.out.println("Invalid amount! Please enter again. ");
            }
        
    }
        if(depo==1){
            double BAL = Balance + depositAmount;
            String Bal = Double.toString(BAL);
            details.set(balancePosition, Bal);
            System.out.println("Deposit added. Your account balance is " + BAL +" LKR");
        }
    }
    
    public void Withdraw(){
        
        int with =0,sufficient = 0;
        double withdrawAmount=0;
        System.out.println("\nWelcome "+name);
        System.out.println("------ Withdraw Money ------");
        
        
        while(with==0 || sufficient==0){
            try{
                System.out.print("Amount(LKR):");
                Scanner in = new Scanner(System.in);
                withdrawAmount = in.nextDouble();
                with = 1;
            }
                catch(InputMismatchException e){
                System.out.println("Invalid amount! Please enter again. ");
            }
        
    
        if(with==1){
            
            if(Balance < withdrawAmount){
                System.out.println("Insufficient Funds! Your available balance is " + Balance+" LKR");   
            }
            else{
                double BAL = Balance - withdrawAmount;
                String Bal = Double.toString(BAL);
                details.set(balancePosition, Bal);
                System.out.println(withdrawAmount+" LKR has withdrawn. Your new account balance is " + BAL+" LKR");
                sufficient = 1;
                
            }
            
        }
        }
    }
    
    
}
