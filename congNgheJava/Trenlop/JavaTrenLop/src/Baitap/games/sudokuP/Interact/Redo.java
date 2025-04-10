package Baitap.games.sudokuP.Interact;

import java.util.ArrayList;
import java.util.List;

public class Redo {
    private Pair <int[][], Integer> reD;
    private List < Pair <int [][], Integer>> redoList = new ArrayList<>();

    public void addRedo(int posX, int posY,int value){
        this.reD = new Pair<>(new int[][]{{posX, posY}}, value);
        redoList.add(reD);
    }

    public Pair <int[][], Integer> getLastRedo(){
        if (redoList != null && !redoList.isEmpty()){
            return redoList.get(redoList.size() - 1);
        }
        else return null;
    }
}
