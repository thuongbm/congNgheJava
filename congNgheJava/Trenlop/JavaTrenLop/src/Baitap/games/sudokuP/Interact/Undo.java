package Baitap.games.sudokuP.Interact;

import java.util.ArrayList;
import java.util.List;


public class Undo {

    private Pair <int[][], Integer> und;
    private List <Pair <int [][], Integer>> undoList = new ArrayList<>();
    private Redo redo;

    public Undo(Redo redo) {
        this.redo = redo;
    }
    public void addUndo(int posX, int posY,int value){
        this.und = new Pair<>(new int[][]{{posX, posY}}, value);
        undoList.add(und);
    }

    public Pair <int [][], Integer> getLastUndo(){
        if (!undoList.isEmpty()){
            Pair <int [][], Integer> lastUndo = undoList.remove(undoList.size() - 1);
            redo.addRedo(lastUndo.getKey()[0][0], lastUndo.getKey()[0][1], lastUndo.getValue());
            return lastUndo;
        }
        return null;
    }
}
