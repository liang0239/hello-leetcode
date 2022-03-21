package exe;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author LH
 * @create 2021-11-04 15:53
 * @description
 **/
public class Hello {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3","4","5");

        List<String> futures = list.stream().map(num -> "hello:"+num ).collect(Collectors.toList());
        for (String num : futures) {
            System.out.println(num);

        }

    }

    private static CompletableFuture<String> doSomeThing(String num) {
        System.out.println(num);
        return CompletableFuture.supplyAsync(() -> "hello:"+ num);
    }
}
