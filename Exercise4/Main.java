import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
    //    ArrayList<Block> chosen = new ArrayList<>();
        //ArrayList<Block> available = new ArrayList<>();
        //TowerState towerState = new TowerState(chosen,available);
        int[] blocks = new int[5]; // for TowerSearch int array
        for(int i=1;i<=5;i++){
            blocks[i-1] = i;
        }
       // towerState.choseBlock(5);
        //towerState.choseBlock(1);
        //System.out.println(towerState.toString());
        //towerState.choseBlock(5);
      //System.out.println(towerState.getDaughters());
        //System.out.println(Arrays.toString(towerState.getBlocks()));

        TowerSearch ts = new TowerSearch(3,blocks);
        //ts.depthFirstSearch();

        System.out.println(ts.depthFirstSearch());
    }

}
