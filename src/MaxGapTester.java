import java.util.Random;

public class MaxGapTester {
    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 3, 1,  2,  4,  6,  8,  10};

        for (int cnt = 1; true; cnt++) {
            System.out.println("Test " + cnt);
            test(Integer.parseInt(args[0]));
        }
    }

    static void test(int n) {
        int[] arr = random(n);
        MaxGapDeleteHeadTail nsv = new MaxGapNSV(arr);
        MaxGapDeleteHeadTail simple = new MaxGapNaive(arr);

        nsv.print();
        Random rng = new Random();
        for (int i = 0; i < arr.length - 1; i++) {
            if (rng.nextInt() % 2 == 0) {
                final int max = nsv.deleteHead();
                final int check = simple.deleteHead();

                System.out.println("delete head: " + max);
                nsv.print();
                if (max != check) {
                    System.out.println("ERROR! " + max + " != " + check);
                    System.exit(1);
                }
            } else {
                final int max = nsv.deleteTail();
                final int check = simple.deleteTail();

                System.out.println("delete tail: " + max);
                nsv.print();
                if (max != check) {
                    System.out.println("ERROR! " + max + " != " + check);
                    System.exit(1);
                }
            }
        }
    }

    // Implementing Fisher–Yates shuffle
    static void shuffle(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i >= 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    static int[] random(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        shuffle(arr);
        return arr;
    }
        
}

