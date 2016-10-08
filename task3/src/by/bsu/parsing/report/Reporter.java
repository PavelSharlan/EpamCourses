package by.bsu.parsing.report;

import by.bsu.parsing.entity.Candy;
import by.bsu.parsing.entity.GlazedCandy;
import by.bsu.parsing.entity.Lollipop;

import java.util.ArrayList;

/**
 * Created by 7 on 22.06.2016.
 */
public interface Reporter {
    public void reportLollipops(ArrayList<Lollipop> al);
    public void reportGlazedCandies(ArrayList<GlazedCandy> al);
}
