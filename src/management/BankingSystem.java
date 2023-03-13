package management;

import entities.Account;
import entities.User;
import utils.ArrayUtils;

import java.util.Date;

public class BankingSystem {
    private static Account[] accounts = {new User(232323, "Timo","Köhler", "s", "bb1c795b69b7cdee87f1eb9a04d63996",
            "asdasd", "12", 123123, "asdasd", "asdasd", 150.0, 0, new Date())};
    private static Account loggedInAccount = accounts[0];

    public static Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public static void setLoggedInAccount(Account loggedInAccount) {
        BankingSystem.loggedInAccount = loggedInAccount;
    }

    public static void addAccountToArray(Account account){
        accounts = ArrayUtils.extendArray(accounts);
        accounts[accounts.length-1] = account;
    }

    public static boolean doesAccountExist(String email){
        for(int i=0; i<accounts.length; i++){
            if(accounts[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesAccountExist(int id){
        for(int i=0; i<accounts.length; i++){
            if(accounts[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
    public static Account findAccountByMail(String email){
        for(int i=0; i<accounts.length; i++){
            if(accounts[i].getEmail().equals(email)) {
                return accounts[i];
            }
        }
        return null;
    }
    public static int generateID(){
        if(accounts.length <1){
            return ArrayUtils.generateRandomInt();
        }
        int id;
        do{
           id = ArrayUtils.generateRandomInt();
        }while(doesAccountExist(id));

        return id;
    }

}
