import java.util.*;

class Mechanism {
    public static final int X = 1, O = -1;
    public static final int BLANK = 0;

    public int player = X;

    private int[][] grid = new int[3][3];
    public boolean isEmpty = false;

    public void marking(int a, int b) {
        if (a < 0 || a > 2 || b < 0 || b > 2) {
            System.out.println("Board Entry does not exist!");
            return;
        }
        if (grid[a][b] != BLANK) {
            System.out.println("Position already Marked");
            return;
        }
        grid[a][b] = player;
        player = -player;
    }

    public boolean Won(int player) {
        return (
                (grid[0][0] + grid[0][1] + grid[0][2] == player * 3) ||
                        (grid[1][0] + grid[1][1] + grid[1][2] == player * 3) ||
                        (grid[2][0] + grid[2][1] + grid[2][2] == player * 3) ||
                        (grid[0][0] + grid[1][0] + grid[2][0] == player * 3) ||
                        (grid[0][1] + grid[1][1] + grid[2][1] == player * 3) ||
                        (grid[0][2] + grid[1][2] + grid[2][2] == player * 3) ||
                        (grid[0][0] + grid[1][1] + grid[2][2] == player * 3) ||
                        (grid[2][0] + grid[1][1] + grid[0][2] == player * 3)
        );


    }

    public void WinAnnounce() {
        if (Won(X)) {
            System.out.println("\n X Won..");
            isEmpty = false;
        } else if (Won(O)) {
            System.out.println("\n O Won..");
            isEmpty = false;
        } else {
            if (!isEmpty) {
                System.out.println("DRAW.. Try Again!");
            }
        }
    }

    public String Drawings() {
        StringBuilder s = new StringBuilder();
        isEmpty = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (grid[i][j]) {
                    case X:
                        s.append(" X ");
                        break;
                    case O:
                        s.append(" O ");
                    case BLANK:
                        s.append(" ");
                        isEmpty = true;
                        break;
                }
                if (j < 2) {
                    s.append("|");
                }
            }
            if (i < 2) {
                s.append("\n__________\n");
            }
        }
        return s.toString();
    }
}

public class TikTakToe {
    public static void main(String[] args) {
        Mechanism m = new Mechanism();
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0;

        do {

                System.out.println(m.player == m.X ? "X's Turn" : "O's Turn");
                System.out.println("Enter X and Y Coordinates");

                x = sc.nextInt();
                y = sc.nextInt();

                m.marking(x, y);
                System.out.println(m.toString());
                System.out.println("__________\n__________");
                m.WinAnnounce();
            }while (m.isEmpty) ;


    }
}

