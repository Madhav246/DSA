import java.util.Deque;
import java.util.LinkedList;

public class Practice {

    public static int sumMaxMin(int[] arr, int n, int k) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> mini = new LinkedList<>();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            while (!max.isEmpty() && arr[max.peekLast()] <= arr[i]) {
                max.pollLast();
            }

            while (!mini.isEmpty() && arr[mini.peekLast()] >= arr[i]) {
                mini.pollLast();
            }
            max.offer(i);
            mini.offer(i);
        }

        for (int i = k; i < n; i++) {
            sum += arr[max.peek()] + arr[mini.peek()];

            //Removing number out of range K :
            while (!max.isEmpty() && max.peek() == i - k) {
                max.pollFirst();
            }

            while (!mini.isEmpty() && mini.peek() == i - k) {
                mini.pollFirst();
            }

            //Removing smaller elements :
            while (!max.isEmpty() && arr[max.peek()] <= arr[i]) {
                max.pollLast();
            }

            //Removing larger elements :
            while (!mini.isEmpty() && arr[mini.peek()] >= arr[i]) {
                mini.pollLast();
            }

            max.offer(i);
            mini.offer(i);
        }

        sum += arr[max.peek()] + arr[mini.peek()];
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println(sumMaxMin(arr, arr.length, k));

    }
}
