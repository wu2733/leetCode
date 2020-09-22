import java.util.*;

/**
 * 给定一个整数数组nums和一个目标值target,在该数组中找出和为目标值的那两个整数,并返回他们的数组下标
 */
public class SumOf2Num {
    private static Integer target;
    private static Integer[] nums;
    private static Integer[] result;

    public static void main(String[] args) throws InterruptedException {
        SumOf2Num sumOf2Num = new SumOf2Num();
        sumOf2Num.init();
        long begin = System.currentTimeMillis();
        result = sumOf2Num.bruteForce(nums, target);
        System.out.println("result:" + result[0] + ":" + nums[result[0]] + "+" + "result:" + result[1] + ":" + nums[result[1]] +
                "= target :" + target +
                "bruteForce:" + (System.currentTimeMillis() - begin) + "mm");
        begin = System.currentTimeMillis();
        result = sumOf2Num.hash(nums, target);
        System.out.println("result:" + result[0] + ":" + nums[result[0]] + "+" + "result:" + result[1] + ":" + nums[result[1]] +
                "= target :" + target +
                "hash:" + (System.currentTimeMillis() - begin) + "mm");
    }

    public Integer[] bruteForce(Integer[] nums, Integer target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new Integer[]{i, j};
                }
            }
        }
        return new Integer[]{-1, -1};
    }

    public Integer[] hash(Integer[] nums, Integer target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new Integer[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        return new Integer[]{-1, -1};
    }

    public void init() {
        target = new Random().nextInt(1000000);
        Set<Integer> list = new HashSet<Integer>();
        for (int i = 0; i < 10000000; i++) {
            int anInt = new Random().nextInt(100000000);
            if (anInt > 100) {
                list.add(anInt);
            }
        }
        nums = new Integer[list.size()];
        nums = list.toArray(nums);
    }
}
