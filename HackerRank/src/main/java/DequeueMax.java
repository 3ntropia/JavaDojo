import java.util.*;

/***
 *
 * In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that
 * generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).
 *
 * Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes.
 * For example, deque can be declared as:
 *
 * Deque deque = new LinkedList<>();
 * or
 * Deque deque = new ArrayDeque<>();
 *
 * In this problem, you are given N integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size M
 * Sample Input
 * N=6, M=3
 * arr=[5, 3, 5, 2, 3, 2]
 *
 * Output
 * 3
 *
 * second for this problem.
 */
public class DequeueMax {

    /*
    Would like to do this operation after I have all the arrange but it will increase load time.

    public static Integer maximumUniqueIntegers(List<Integer> list, Integer size){
        Set<Integer> uniques = new HashSet<>();
        Map<Integer, Set<Integer>> subArrayUnique = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;
        for(int value:list){
            deque.add(value);
            uniques.add(value);
            if(deque.size()==size){
                subArrayUnique.
            }
        }
        return max;
    }

     */

    public static int solve(int n, int m, List<Integer> arr)
    {
        Deque<Integer> d=new ArrayDeque<>();
        int ans=-1;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int num:arr)
        {
            d.add(num);
            if(mp.containsKey(num))
                mp.put(num, mp.get(num)+1);
            else
                mp.put(num, 1);
            if(d.size() == m+1)
            {
                int first=d.remove();
                if(mp.containsKey(first)) {
                    int count = mp.get(first);
                    if(count>1)
                        mp.put(first, count-1);
                    else
                        mp.remove(first);
                }
            }
            if(d.size()==m)
                ans=Math.max(ans, mp.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> uniques = new HashSet<>();
        int max = 0;
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            if(deque.size()==m){
                var head = deque.pop();
                for(var val:deque){
                    uniques.add(val);
                    if(max<uniques.size()){
                        max = uniques.size();
                    }
                }
                uniques.remove(head);
            }
        }
        System.out.println("max: " + max);
    }
}
