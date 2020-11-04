package other;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class BloomFilter {
    private static final int DEFAULT_SIZE = 2 << 24;//布隆过滤器的比特长度
    private static final int[] seeds = new int[]{5, 7, 11, 13, 31, 37, 61};//这里要选取质数，能很好的降低错误率
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public BloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String value) {
        for (SimpleHash f : func) {//将字符串value哈希为8个或多个整数，然后在这些整数的bit上变为1
            bits.set(f.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (SimpleHash f : func) {//这里其实没必要全部跑完，只要一次ret==false那么就不包含这个字符串
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    // 内部类，simpleHash
    public static class SimpleHash {
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {//字符串哈希，选取好的哈希函数很重要
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return (cap - 1) & result;
        }
    }

    public static void main(String[] args) {
        BloomFilter bf = new BloomFilter();
        List<String> strs = new ArrayList<String>();
        strs.add("123456");
        strs.add("hello word");
        strs.add("transDocId");
        strs.add("123456");
        strs.add("transDocId");
        strs.add("hello word");
        strs.add("test");
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            boolean bl = bf.contains(s);
            if (bl) {
                System.out.println(i + "," + s);
            } else {
                bf.add(s);
            }
        }

    }
}
