import java.util.Scanner;

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
            
        //String s = "^#";
        char[] p = new char[2*str.length()+3];
        p[0] = '^';
        p[1] = '#';
        for (int i = 0; i < str.length(); i++) {
            //s = s + str.charAt(i) + "#"; ///使用string拼接将导致tle
            p[i*2+2] = str.charAt(i);
            p[i*2+3] = '#';
        }
        p[p.length-1] = '$';
        int[] f = new int[p.length];
        int j = 0;
        int maxEdge = 0;
        f[0] = 1;
        for (int i = 1; i < p.length-1; i++) {
            if (maxEdge > i) { // j + f[j] >= i
                f[i] = Math.min(f[2*j-i], maxEdge - i);                
            } else {
                f[i] = 1;
            }
            while (p[i-f[i]]==p[i+f[i]]) {
                f[i]++;
            }
            if (i+f[i] > maxEdge) {
                maxEdge = i+f[i];
                j = i;
            }
        }

        int maxL = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] > maxL) {
                maxL = f[i];
            }
        }
        System.out.println(maxL-1);
    }
}