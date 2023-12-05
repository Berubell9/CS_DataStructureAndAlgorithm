import java.util.Arrays;

class MergeSort_650022{
    public static void main(String[] args) {
        System.out.println("Demo1");
        demo1();
        System.out.println("Demo2");
        demo2_descending();
        System.out.println("Demo3");
        demo3_multi_key();
    }
    static void demo1(){
        int[] data = {8,3,2,9,7,1,4};
        m_sort(data,0);
        System.out.println(Arrays.toString(data));
    }
    static void demo2_descending(){   
        int[][] data = {{11,88},{33,99},{22,77}};
        m_sort(data,0);
        for(int row = 0 ; row<data.length ; row++){
            System.out.println(Arrays.toString(data[row]));
        } 
    }
    static void demo3_multi_key(){
        int[][] data = {{11,22,33,44},
                        {19,17,63,57},
                        {17,22,18,15},
                        {12,18,73,84},
                        {14,27,33,55}
        };
        // expected
        // [14, 27, 33, 55]
        // [11, 22, 33, 44]
        // [17, 22, 18, 15]
        // [12, 18, 73, 84]
        // [19, 17, 63, 57]
        m_sort(data,1,2,0);
        for(int row = 0 ; row<data.length ; row++){
            System.out.println(Arrays.toString(data[row]));
        } 
    }
    /*------------------------ demo1 ------------------------*/
    static void m_sort(int[] input,int pass){
        int size = input.length;
        if(size>1){
            int mid = input.length/2;
            int[] a = new int[mid]; //b
            int[] b = new int[size-mid]; //c
            pass++;
            for(int i=0 ; i<mid ; i++){
                a[i] = input[i];
            }
            for(int j = 0; j<b.length;j++){
                b[j] = input[j+mid];
            }
            m_sort(a,pass);
            m_sort(b,pass);
            merge(input, a, b);
        }
    }
    // a=input,a=b,b=c
    static void merge(int [] input, int [] left, int [] right){
        int p = left.length; // left = a
        int q = right.length; // right = b
        int i=0,j=0,k=0;
        while((i<p)&&(j<q)){
            if(left[i]<=right[j]){
                input[k++] = left[i++];
            }
            else{
                input[k++] = right[j++];
            }
        }
        if(i == p){
            while(j<q){
                input[k++] = right[j++];
            }
        }
        else{
            while(i<p){
                input[k++] = left[i++];
            }
        }
    }
    /*------------------------ demo2 ------------------------*/
    static void m_sort(int[][] input,int pass){
        int row = input.length;
        int col = input[0].length;
        if(row > 1){
            int mid = input.length/2;
            int [][] left = new int[mid][col];
            int [][] right = new int[row - mid][col];
            pass++;
            for (int i = 0; i < mid; i++) {
                left[i] = input[i];
            }
            int size2 = right.length;
            for (int i = 0; i < size2; i++) {
                right[i] = input[i+mid];
            }
            m_sort(left,pass);
            m_sort(right,pass);
            merge(input,left,right);
        }
    }
    static void merge(int [][] input, int [][] left, int [][] right){
        int p = left.length;
        int q = right.length;
        int i = 0,j = 0,k = 0;
        while ((i < p) && (j < q)) {
            if(left[i][0] >= right[j][0]){
                input[k++] = left[i++];
            }
            else{
                input[k++] = right[j++];
            }
        }
        if(i == p){
            while(j < q){
                input[k++] = right[j++];
            }
        }
        else{
            while (i < p) {
                input[k++] = left[i++];
            }
        }
    }
    /*------------------------ demo3 ------------------------*/
    //key 2 = เท่ากันให้ indexที่2 ในการเรียง
    static void m_sort(int[][] input,int key1,int key2,int pass){
        int row = input.length;
        int col = input[0].length;
        if(row > 1){
            int mid = input.length/2;
            int [][] left = new int[mid][col];
            int [][] right = new int[row - mid][col];
            pass++;
            for (int i = 0; i < mid; i++) {
                left[i] = input[i];
            }
            int size2 = right.length;
            for (int i = 0; i < size2; i++) {
                right[i] = input[i+mid];
            }
            m_sort(left,key1,key2,pass);
            m_sort(right,key1,key2,pass);
            merge(input,left,right,key1,key2);
        }
    }
    static void merge(int [][] input, int [][] left, int [][] right, int key1, int key2){
        int p = left.length;
        int q = right.length;
        int i = 0,j = 0,k = 0;
        while ((i < p) && (j < q)) {
            if(left[i][key1] > right[j][key1]){
                input[k++] = left[i++];
            }
            else if((left[i][key1] < right[j][key1])){
                input[k++] = right[j++];
            }
            else if(left[i][key2] >= right[j][key2]){
                input[k++] = left[i++];
            }
            else{
                input[k++] = right[j++];
            }
        }
        if(i == p){
            while(j < q){
                input[k++] = right[j++];
            }
        }
        else{
            while (i < p) {
                input[k++] = left[i++];
            }
        }
    }
}

        