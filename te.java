    /**
     * 1
     */
public class te {
    static void m_sort(int[] input,int pass){
        int size = input.length;
        if(size>1){
            int mid = input.length/2;
            int[] left = new int[mid]; 
            int[] right = new int[size-mid]; 
            pass++;
            for(int i=0 ; i<mid ; i++)
                left[i] = input[i];
            for(int j = 0; j<right.length;j++)
                right[j] = input[j+mid];
            m_sort(left,pass);
            m_sort(right,pass);
            merge(input, left, right);
        }
    }
    static void merge(int [] input, int [] left, int [] right){
        int p = left.length;
        int q = right.length;
        int i=0,j=0,k=0;
        while((i<p)&&(j<q)){
            if(left[i]<=right[j])
                input[k++] = left[i++];
            else
                input[k++] = right[j++];
        }
        if(i == p) 
            while(j<q)
                input[k++] = right[j++];
        else 
            while(i<p)
                input[k++] = left[i++]; 
    }
}
    