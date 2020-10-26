import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * 无重复最长字串
 * 给定一个字符串，请找出其中不含有重复字符串的最长字串长度。
 */
public class LongestSubStr {

    static String s;

    static {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入任意字符串:");
        if (scanner.hasNext()) {
            s = scanner.next();
            System.out.println("输入字符串为:" + s);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        LongestSubStr longestSubStr = new LongestSubStr();
        Long begin = System.currentTimeMillis();
        Integer solution = longestSubStr.solution();
        System.out.println("Time:" + (System.currentTimeMillis() - begin) + "mm, length:" + solution);
    }

    private Integer solution() {
        HashSet<Character> result = new HashSet<Character>();
        int ans = 0,rk = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                result.remove(s.charAt(i-1));
            }
            while (rk < s.length() && !result.contains(s.charAt(rk))) {
                result.add(s.charAt(rk));
                ++rk;
            }
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i)>0) {
                map.put(i, map.get(i) - 1);
                result.add(i);
            }
        }
        int[] num = new int[result.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = result.get(i);
        }
        return num;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result = new int[]{map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, char[]> h = new HashMap<>();
        Map<Integer, char[]> z = new HashMap<>();
        Map<Integer, char[]> hz = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            h.put(i, board[i]);
            char[] chars = new char[9];
            if (z.get(i) != null) {
                System.arraycopy(z.get(i), 0, chars, 0, 9);
            }
            for (int j = 0; j < 9; j++) {
                chars[j] = board[j][i];
            }
            z.put(i, chars);
        }
        for (int index = 0; index < 9; index++) {
            for (int i = 0; i < 3; i++) {
                char[] chars = new char[9];
                if(hz.get(index)!=null){
                    System.arraycopy(hz.get(index), 0, chars, 0, 9);
                }
                for (int j = 0; j < 3; j++) {
                    chars[i * 3 + j] = board[i + (index / 3) * 3][(index % 3) * 3 + j];
                }
                hz.put(index, chars);
            }
        }
        return check(h) || check(z) || check(hz);
    }

    public boolean check(Map<Integer, char[]> map) {
        boolean result = true;
        for (Map.Entry<Integer, char[]> entry : map.entrySet()) {
            char[] value = entry.getValue();
            Set<Integer> nums = new HashSet<>();
            for (char c : value) {
                if (Character.isDigit(c)) {
                    if (nums.contains(c)) {
                        result = false;
                    }else {
                        nums.add((int) c);
                    }
                }
            }
        }
        return result;
    }
}
