import java.util.Scanner;
import java.util.Vector;

public class Main {
    
    public static void main(String[] args) {
        new Main().start();
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            pal(scanner.next());
        }
    }

    void pal(String str) {

        if (str.length() < 2) {
            System.out.println(str.length());
            return;
        }
        Vector<Character> p = new Vector<>(str.length()*2+3);
        p.add('^');
        p.add('#');
        for (int i = 0; i < str.length(); i++) {
            p.add(str.charAt(i));
            p.add('#');
        }
        p.add('$');
        int[] f = new int[p.size()];
        int j = 0;
        int maxEdge = 0;
        int maxL = 0;
        f[0] = 1;
        for (int i = 1; i < p.size()-1; i++) {
            if (maxEdge > i) { // j + f[j] >= i
                f[i] = Math.min(f[2*j-i], maxEdge - i);                
            } else {
                f[i] = 1;
            }
            while (p.get(i-f[i])==p.get(i+f[i])) {
                f[i]++;
            }
            if (f[i] > maxL) {
                maxL = f[i];
            }
            if (i+f[i] > maxEdge) {
                maxEdge = i+f[i];
                j = i;
            }
        }
        System.out.println(maxL-1);
    }
}