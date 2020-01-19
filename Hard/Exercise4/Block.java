//Boylarına göre block yaratmamıza yarayan bir block classı
public class Block {
    int height;

    public Block(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Block{" +
                "height=" + height +
                '}';
    }
}
