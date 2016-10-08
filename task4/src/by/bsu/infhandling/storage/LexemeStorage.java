package by.bsu.infhandling.storage;

import java.util.ArrayList;

/**
 * Created by 7 on 14.07.2016.
 */
public class LexemeStorage {
    private static ArrayList<String> lexemes = new ArrayList<String>();

    public static void addLexeme(String lexeme){
        if(!lexeme.isEmpty() & !lexeme.equals("\n") & !lexeme.equals(" ")){
            lexemes.add(lexeme);
        }
    }

    public static ArrayList<String> getLexemes(){
        return new ArrayList<String>(lexemes);
    }
}
