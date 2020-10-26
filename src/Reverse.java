public class Reverse {
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(-2147483648));
    }

    public int reverse(int x) {
        char[] num = Integer.toString(x).toCharArray();
        String result;
        if (num[0] == '-') {
            result = parse(num);
            result = "-" + result.substring(0, result.length() - 1);
        }else {
            result = parse( num);
        }
        Long s = Long.parseLong(result);
        if (s > Integer.MAX_VALUE || s<Integer.MIN_VALUE) {
            return 0;
        }
        return s.intValue();
    }

    public String parse(char[] chars) {
        for (int i = 0; i < chars.length/2; i++) {
            char a = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = a;
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

}
