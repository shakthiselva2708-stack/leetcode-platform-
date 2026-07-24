import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> loss = new HashMap<>();

        for (int[] match : matches) {
            loss.putIfAbsent(match[0], 0);
            loss.put(match[1], loss.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int player : loss.keySet()) {
            if (loss.get(player) == 0)
                zeroLoss.add(player);
            else if (loss.get(player) == 1)
                oneLoss.add(player);
        }

        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);

        return ans;
    }
}
