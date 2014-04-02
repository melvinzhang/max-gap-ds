class MaxGapNaive implements MaxGapDeleteHeadTail {
    
    int start;
    int end;
    
    final int[] A;
    final int n;
    
    public MaxGapNaive(int[] arr) {
        A = arr;
        n = arr.length;
    
        start = 0;
        end = n - 1;
    }
    
    public int max() {
        int m = start;
        for (int i = start; i <= end; i++) {
            if (A[i] > A[m]) {
                m = i;
            }
        }
        return m;
    }
    
    public int deleteHead() {
        start++;
        return max();
    }
    
    public int deleteTail() {
        end--;
        return max();
    }
    
    public void print() {
        for (int i = start; i <= end; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}
