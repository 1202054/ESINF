package ex4.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exercicio {

    public int longestJourney(Graph<String,Integer> g, String s, String a, String b){
        int valor = 0;

        LinkedList<String> paths = new LinkedList<>();
        LinkedList<String> paths1 = new LinkedList<>();

        Algorithms.shortestPath(g,s,a,Integer::compare,Integer::sum,0,paths);
        Algorithms.shortestPath(g,s,b,Integer::compare,Integer::sum,0,paths1);

        Iterator<String> itema = paths.iterator();
        Iterator<String> itemb = paths1.iterator();

        while (itema.hasNext() && itemb.hasNext()){
            if (!itema.next().equals(itemb.next())) {
                break;
            }
            valor += 1;
        }
        return valor;
    }
}
