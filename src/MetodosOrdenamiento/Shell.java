package MetodosOrdenamiento;
//Programa que utilizia el metodo de ordenamiento Shell
public class Shell {
    //Metodo main
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 1, 6};
        shell(arr);
    }
    //Metodo que implementa el ordenamiento Shell
    public static void shell(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
