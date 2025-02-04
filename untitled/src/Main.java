import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int mod = 998244353;
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static long gcd(long x, long y){
        return (y == 0L ? x : gcd(y, x % y));
    }

    public static long lcm(long x, long y){
        long nr = x * y;
        long dr = gcd(x, y);
        return Math.floorDiv(nr, dr);
    }

    //    get prime factors of a number
    public static List<Long> getPrimeFactors(long x){
        Set<Long> result = new HashSet<>();

        while(x % 2L == 0L){
            result.add(2L);
            x /= 2L;
        }

        for(long i = 3;i <= Math.sqrt(x);i += 2){
            while(x % i == 0L){
                result.add(i);
                x = Math.floorDiv(x, i);
            }
        }

        if(x > 2){
            result.add(x);
        }
        return new ArrayList<>(result);
    }

    //    calculate |z|, S.T  z <= x and z % y[i] != 0 for all i
    public static long getNonDivisibleNos(long x, List<Long> y){
        long ans = 0;
        long n = y.size();
        for(long i = 1;i < (1 << n);++i){
            long value = 1;
            for(int j = 0;j < n;++j){
                if((i & (Long)(1L << j)) > 0L){
                    value = lcm(value, y.get(j));
                }
            }
            value = Math.floorDiv(x, value);
            long sign = ((Long.bitCount(i)) % 2L > 0L ? 1L : -1L);
            long add = ((sign * value)) % mod;
            ans = (ans + add) % mod;
        }
        ans = (x - ans) % mod;
        return ans;
    }

    //    calculate |x|, S.T x is coprime with y and 0 < x <= limit
    //the prime factors of y are also prime factors of a[0]
    //as a[i - 1] / a[i] = y
    public static long calcCoPrimes(long y, long limit, List<Long> allPrimeFactors){
        List<Long> primeFactors = new ArrayList<>();
        for(Long x : allPrimeFactors){
            if(y % x == 0){
                primeFactors.add(x);
            }
        }
        return getNonDivisibleNos(limit, primeFactors);
    }

    public static long getMult(long a, long ap, long M, List<Long> allPrimeFactors){
        //This function calculates the no. of elements X(|X| = x) S.T gcd(ap, x) = a
        if(ap % a > 0L){
            //a(i) is not divisible by a(i - 1)
            return 0;
        }
        long y = Math.floorDiv(ap , a), lim_y = Math.floorDiv(M, a);
        return calcCoPrimes(y, lim_y, allPrimeFactors);
    }

    public static void calc(FastReader fastReader){

    }
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int tc = fastReader.nextInt();
        while(tc > 0){
            calc(fastReader);
            tc --;
        }
    }
}