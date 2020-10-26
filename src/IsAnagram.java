public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ints = new int[26], intt = new int[26];
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i] - 'a']++;
            intt[chars1[i] - 'a']++;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != intt[i]) {
                return false;
            }
        }
        return true;
    }
}
