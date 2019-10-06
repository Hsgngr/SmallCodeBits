import java.util.ArrayList;
import java.util.Stack;

public class TowerSearch {
    private TowerState start;
    private int goal;
    private int[] blocks;
    private ArrayList<String> successors;

    public TowerState getStart() {
        return start;
    }

    public TowerSearch(int goal, int[] blocks) {
        this.goal = goal;
        this.blocks = blocks;
        ArrayList<Block> available = new ArrayList<>();
        ArrayList<Block> chosen = new ArrayList<>();
        this.start = new TowerState(chosen, available);
        for (int block : blocks) {
            start.addBlock(block);
        }
        successors = new ArrayList<String>();

    }

    public boolean checkTheTower(TowerState tower) {
        if (tower.getHeight() == goal && !successors.contains(tower.toString())) {
            successors.add(tower.toString());
            return true;
        } else {
            return false;
        }
    }

    public TowerState depthFirstSearch() {
        ArrayList<String> alreadySeen = new ArrayList<>(); //ArrayList'in contains methodunu kullanacağız, Geçtiğimiz nodedan tekrar geçmemek için seen/Unseen booleanı
        Stack<TowerState> stack = new Stack<>(); //Operasyonu gerçekleştireceğimiz stack
        stack.push(start); //first push
        alreadySeen.add(start.toString()); //marked as seen;
        while (!stack.isEmpty()) { //stack boşaldığından tüm kombinasyonlar denenmiş oluyor.
            TowerState tower = stack.peek();
            if (!alreadySeen.contains(tower.toString())) { //daha önce görülmediyse
                alreadySeen.add(tower.toString()); // görüldü ekle.
                if (checkTheTower(tower)) System.out.println(tower.toString()); // condition'ı sağlıyorsa printle.
            } else {
                stack.pop(); //eğer daha önce görüldüyse stackten çıkar.
            }
            ArrayList<TowerState> neighbours = tower.getDaughters(); //stackten çıkarttığımız hala elimizde. childlarına bakıyoruz.
            for (int i = 0; i < neighbours.size(); i++) {
                TowerState n = neighbours.get(i);
                if (n != null && !alreadySeen.contains(n.toString())) {
                    if (checkTheTower(n)) System.out.println(n.toString());
                    stack.push(n);
                }
            }
        }
        return null;
    }
}
//contains kullanımında bir problem var o yüzden stringleri kullandım. Ama towerStatelerin kendilerini kullanmak daha iyi olurdu eğer consistleri çalıştırabilseydim.

