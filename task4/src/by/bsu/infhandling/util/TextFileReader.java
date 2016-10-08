package by.bsu.infhandling.util;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class TextFileReader {
    public static String readFile(String filePath){
        StringBuilder sb = new StringBuilder();
        try{
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                sb.append(sc.nextLine());
                sb.append('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
