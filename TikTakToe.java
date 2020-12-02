import java.util.Scanner;

class Mechanism {
    public static final int X = 1, O = -1;
    public static final int BLANK = 0;

    public int player = X;
    private int[][] grid = new int[3][3];
    public boolean isBLANK = false;

    public void marking(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Entered Position does not Exist!");
            return;
        }
        if (grid[x][y] != BLANK) {
            System.out.println("Entered position already occupied!");
            return;
        }
        grid[x][y] = player;
        player = -player;
    }

    public boolean isWin(int player) {
        return ((grid[0][0] + grid[0][1] + grid[0][2] == player * 3) ||
                (grid[1][0] + grid[1][1] + grid[1][2] == player * 3) ||
                (grid[2][0] + grid[2][1] + grid[2][2] == player * 3) ||
                (grid[0][0] + grid[1][0] + grid[2][0] == player * 3) ||
                (grid[0][1] + grid[1][1] + grid[2][1] == player * 3) ||
                (grid[0][2] + grid[1][2] + grid[2][2] == player * 3) ||
                (grid[0][0] + grid[1][1] + grid[2][2] == player * 3) ||
                (grid[2][0] + grid[1][1] + grid[0][2] == player * 3));
    }

    public void AnnounceWin() {
        if (isWin(X)) {
            System.out.println("\n X won...!!");
            isBLANK = false;
        } else if (isWin(O)) {
            System.out.println("\n O won...!!");
            isBLANK = false;
        } else {
            if (!isBLANK) {
                System.out.println("DRAW.. Try Again!");
            }

        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        isBLANK = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (grid[i][j]) {
                    case X:
                        s.append(" X ");
                        break;
                    case O:
                        s.append(" O ");
                        break;
                    case BLANK:
                        s.append("   ");
                        isBLANK = true;
                        break;
                }
                if (j < 2) {
                    s.append("|");
                }

            }
            if (i < 2) {
                s.append("\n-----------\n");
            }
        }
        return s.toString();
    }
}
public class TikTakToe  {

    public static void main(String[] args) {

        Mechanism m = new Mechanism();
        Scanner s = new Scanner(System.in);
        int x=0,y=0;
        do
        {
            System.out.println(m.player==m.X?"X's Turn":"O's Turn");
            System.out.println("Enter X and Y Coordinates [0,1,2]");
            x=s.nextInt();
            y=s.nextInt();

            m.marking(x, y);
            System.out.println(m.toString());
            System.out.println("___________\n\n");
            m.AnnounceWin();

        }while(m.isBLANK);
    }
}

