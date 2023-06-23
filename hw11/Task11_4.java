package homeWork11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task11_4 {
    static class Generator{
        private long a;
        private long c;
        private long m;
        private long seed;
        public Generator seed(long seed){
            this.seed=seed;
            return this;
        }

        public Generator(long a, long c, long m) {
            this.a = a;
            this.c = c;
            this.m = m;
        }
        public long nextNumber(){
            return  ((a * seed + c) % m);
        }
    }

    public static void main(String[] args) {

        Generator generator = new Generator(25214903917L, 11, (long)Math.pow(2,48));
        Stream<Long> lStream = Stream.iterate(0L, (seed) -> generator.seed(seed).nextNumber());
        lStream.limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}
