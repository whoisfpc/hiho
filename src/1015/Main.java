import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        new Main().start();
    }

    void start() {
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();
        Scanner.nextLine();
        String p, s;
        for (int i = 0; i < n; i++) {
            p = Scanner.nextLine();
            s = Scanner.nextLine();
            kmp(p, s);
        }
    }

    void kmp(String pattern, String str) {
        if (str.length() == 0 || pattern.length() == 0) {
            System.out.println();
            return;
        }
        int[] next = new int[pattern.length() + 1];
        next[0] = -1;
        next[1] = 0;
        char[] p = pattern.toCharArray();
        char[] s = str.toCharArray();
        for (int i = 1; i < p.length; i++) {
            for (int j = next[i]; j != -1; j = next[j]) {
                if (p[j] == p[i]) {
                    next[i+1] = j+1;
                    break;
                }
            }
        }

        int i = 0, j = 0;
        int count = 0;
        while (i < s.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
                if (j == p.length) {
                    count++;
                    j = next[j];
                }
            } else {
                j = next[j];
            }
        }
        System.out.println(count);
    }
}