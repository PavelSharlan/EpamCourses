package by.bsu.infhandling.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LexemeSorter {
    public static ArrayList<String> sortLexemesByFirstSymbol(ArrayList<String> lexemes){
        Collections.sort(lexemes, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Character.toString(o1.charAt(0)).compareToIgnoreCase(Character.toString(o2.charAt(0)));
            }
        });
        return lexemes;
    }

    public static String getStringFromList(ArrayList<String> al) {
        char cur = al.get(0).toLowerCase().charAt(0);
        char prev = al.get(0).toLowerCase().charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < al.size(); i++){
            cur = al.get(i).toLowerCase().charAt(0);
            if (cur == prev){
                sb.append(al.get(i) + " ");
                prev = al.get(i).toLowerCase().charAt(0);
            } else {
                prev = cur;
                sb.append("\n" + al.get(i) + " ");
            }
        }
        return sb.toString();
    }
}
