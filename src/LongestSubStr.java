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
}
