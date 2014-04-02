import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

class MaxGapNSV implements MaxGapDeleteHeadTail {

    int start;
    int end;
    int max;
    
    final int[] A;
    final int n;
    
    //L[i] is the index of first element to the left that is greater than i
    final int[] L; 
    
    //R[i] is the index of first element to the right that is greater than i
    final int[] R; 

    final List<Deque<Integer>> Rv;
    final List<Deque<Integer>> Lv;

    public MaxGapNSV(int[] arr) {
        A = arr;
        n = arr.length;
    
        start = 0;
        end = n - 1;

        L = new int[n];
        R = new int[n];
        Rv = new ArrayList<Deque<Integer>>();
        Lv = new ArrayList<Deque<Integer>>();
        for (int i = 0; i < n; i++) {
            Rv.add(new ArrayDeque<Integer>());
            Lv.add(new ArrayDeque<Integer>());
        }
        init();
    }
    
    public void print() {
        for (int i = start; i <= end; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    private void init() {
        final Deque<Integer> Q = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            while (Q.size() > 0 && A[Q.getLast()] < A[i]) {
                Q.removeLast();
            }
            if (Q.size() == 0) {
                L[i] = i;
            } else {
                final int j = Q.getLast();
                L[i] = j;
                Rv.get(j).addLast(i);
            }

            
            Q.addLast(i);
        }
        
        Q.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (Q.size() > 0 && A[Q.getLast()] < A[i]) {
                Q.removeLast();
            }
            if (Q.size() == 0) {
                R[i] = i;
            } else {
                final int j = Q.getLast();
                R[i] = j;
                Lv.get(j).addLast(i);
            }

            
            Q.addLast(i);
        }
        
        max = slowMax();;
    }

    public int max() {
        return max;
    }

    private int slowMax() {
        int m = start;
        for (int i = start; i <= end; i++) {
            if (A[i] > A[m]) {
                m = i;
            }
        }
        return m;
    }

    public int deleteHead() {
        final int i = start;
        final int j = R[i];
        
        if (i != j) {
            Lv.get(j).removeLast();
        }
        
        if (i == max) {
            max = Rv.get(i).getLast();
        }

        start += 1;
        
        return max;
    }

    public int deleteTail() {
        final int j = end;
        final int i = L[j];
        
        if (i != j) {
            Rv.get(i).removeLast();
        }

        if (j == max) {
            max = Lv.get(j).getLast();
        }

        end -= 1;
        
        return max;
    }
}
