package by.bsu.infhandling.action;

import java.util.ArrayList;

public class SymbolDeleter {
    public static ArrayList<String> deleteSymbols(ArrayList<String> lexemes){
        ArrayList<String> newAL = new ArrayList<String>();
        for (String s : lexemes){
            newAL.add(s.replace(Character.toString(s.charAt(0)), ""));
        }
        return newAL;
    }
}
