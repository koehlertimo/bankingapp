package utils;

import entities.Account;

public class ArrayUtils {
    private ArrayUtils(){};

    public static Account[] extendArray(Account[] arr){
        Account[] bigArr = new Account[arr.length+1];
        for(int i = 0; i<arr.length; i++){
            bigArr[i] = arr[i];
        }
        return bigArr;
    }

    public static int generateRandomInt(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    public static int generateRandomInt(){
        int min = 10000;
        int max = 99999;
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
