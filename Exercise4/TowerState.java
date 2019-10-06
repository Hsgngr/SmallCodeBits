import java.util.ArrayList;

public class TowerState {
    private ArrayList<Block> chosen;
    private ArrayList<Block> available;

    public TowerState(ArrayList<Block> chosen, ArrayList<Block> available) {
        this.chosen = chosen;
        this.available = available;
    }

    public int getHeight() {
        int sum = 0;
        for (Block block : chosen) {
            sum += block.getHeight();
        }
        return sum;
    }
    public int[] getBlocks(){ // available ve chosen olan blockların tamamını göstermek için kullanılan method
        int[] blockArray = new int[chosen.size() + available.size()];
        for(int i=0;i<chosen.size();i++){
            blockArray[i] = chosen.get(i).getHeight();
        }
        for(int i=chosen.size();i<available.size()+chosen.size();i++){
            blockArray[i] = available.get(i-chosen.size()).getHeight();
        }
        return blockArray;

    }

    public void addBlock(int height) {
        Block block = new Block(height);
        available.add(block);
    }

    public boolean choseBlock(int height) {
        for (Block block : available) {
            if (block.getHeight() == height) {
                chosen.add(block);
                available.remove(block);
                return true;
            }
        }
        System.out.println("There is no available block with height of " + height);
        return false;
    }
    public ArrayList<TowerState> getDaughters() {
        ArrayList<TowerState> tsArray = new ArrayList<>(); //towerState array'i veriyor.
        for (Block block : this.available) {
            int height = block.getHeight();
            ArrayList<Block> CopyChosen = new ArrayList<>(chosen); //shallow copy yapmamızı sağlıyor.
            ArrayList<Block> CopyAvailable = new ArrayList<>(available);
            TowerState copyTowerState = new TowerState(CopyChosen, CopyAvailable);
            copyTowerState.choseBlock(height);
            tsArray.add(copyTowerState);
        }
        return tsArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : chosen) {
            sb.append(block.getHeight());
        }
        sb.append("|");
        for (Block block : available) {
            sb.append(block.getHeight());
        }
        return sb.toString();
    }
}
