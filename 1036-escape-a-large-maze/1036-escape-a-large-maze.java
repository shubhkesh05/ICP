import java.util.*;

class Solution {
    private static final int LIMIT = 1000000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockSet = new HashSet<>();
        for (int[] b : blocked) {
            long code = ((long)b[0] << 20) | b[1];
            blockSet.add(code);
        }
        return dfs(blockSet, source[0], source[1], target[0], target[1], new HashSet<>())
            && dfs(blockSet, target[0], target[1], source[0], source[1], new HashSet<>());
    }

    private boolean dfs(Set<Long> blockSet, int sx, int sy, int tx, int ty, Set<Long> seen) {
        if (sx < 0 || sx >= LIMIT || sy < 0 || sy >= LIMIT) return false;
        long code = ((long)sx << 20) | sy;
        if (blockSet.contains(code) || seen.contains(code)) return false;
        if (sx == tx && sy == ty) return true;
        seen.add(code);
        if (seen.size() > (blockedMaxSize(blockSet) * blockedMaxSize(blockSet)) / 2) return true;
        if (dfs(blockSet, sx + 1, sy, tx, ty, seen)) return true;
        if (dfs(blockSet, sx - 1, sy, tx, ty, seen)) return true;
        if (dfs(blockSet, sx, sy + 1, tx, ty, seen)) return true;
        if (dfs(blockSet, sx, sy - 1, tx, ty, seen)) return true;
        return false;
    }

    private int blockedMaxSize(Set<Long> blockSet) {
        return blockSet.size();
    }
}
