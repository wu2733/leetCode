import java.util.*;

/**
 * ���ظ���ִ�
 * ����һ���ַ��������ҳ����в������ظ��ַ�������ִ����ȡ�
 */
public class LongestSubStr {

    static String s;

    static {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�����������ַ���:");
        if (scanner.hasNext()) {
            s = scanner.next();
            System.out.println("�����ַ���Ϊ:" + s);
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
