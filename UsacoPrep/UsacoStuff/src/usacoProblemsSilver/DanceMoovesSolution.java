
package usacoProblemsSilver;

/**
 * @author Johan Mathew
*/



import java.util.*; 

public class DanceMoovesSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        int[] cows = new int[N+1];
        List<Integer>[] viewed = new List[N+1];
        for (int j = 1; j <= N; j++) {
            cows[j] = j;
            viewed[j] = new ArrayList<>();
            viewed[j].add(j);
        }
        
        for (int t = 1; t <= K; t++) {
            int a = in.nextInt();
            int b = in.nextInt();
            
            int c = cows[a];
            int d = cows[b];
            
            cows[a] = d;
            cows[b] = c;
            
            viewed[cows[a]].add(a);
            viewed[cows[b]].add(b);
        }
        
        int[] answer = new int[N+1];
        for (int r = 1; r <= N; r++) {
            if (cows[r] == 0) continue;
            
            List<Integer> cycle = new ArrayList<>();
            int j = r;
            while (cows[j] != 0) {
                cycle.add(j);
                j = cows[j];
                cows[cycle.get(cycle.size() - 1)] = 0;
            }
            
            Set<Integer> viewedHere = new HashSet<>();
            for (int cow : cycle) {
                viewedHere.addAll(viewed[cow]);
            }
            
            for (int cow : cycle) {
                answer[cow] = viewedHere.size();
            }
        }
        
        for (int i = 1; i < answer.length; i++) System.out.println(answer[i]);
    }
}