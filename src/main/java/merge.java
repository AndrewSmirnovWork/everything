import java.io.BufferedReader;
import java.io.InputStreamReader;

public class merge {

    public static void main(String[] args) throws Exception {
        new merge().run();

    }

    public int[] merge(int[] a, int [] b){

        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];
        for(int k = 0; k < res.length; k++){
            if((i < a.length && a[i] <= b[j]) || j == b.length){
                res[k] = a[i];
                i++;
            }
            else {
                res[k] = b[j];
                j++;
            }
        }
        return res;
    }

    public int[] mergeSort(int[] a){
        if(a.length == 1) return a;
        int n = a.length;
        int m = n/2;
        int[] left = new int[m];
        int[] right = new int [n-m];
        System.arraycopy(a, 0 , left, 0, m);
        System.arraycopy(a, m , right, 0, n-m);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    public void run() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] A = new int [n];
        String[] str = reader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        int[] sortedA = mergeSort(A);
        for(Integer out : sortedA) {
            System.out.print(out + " ");
        }
    }
}