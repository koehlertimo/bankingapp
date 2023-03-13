package utils;

import entities.*;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVUtils {
    public void writeDataToCSV(Admin[] arr, String path){
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(path)) ;
            ){
                writer.write("id;firstname;lastname;email;password;street;housenumber;postalcode;city;country;creationDate");
                writer.newLine();
                for(Account element: arr){
                    writer.write(element.toString());
                    if(!element.equals(arr[arr.length-1])) {
                        writer.newLine();
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
