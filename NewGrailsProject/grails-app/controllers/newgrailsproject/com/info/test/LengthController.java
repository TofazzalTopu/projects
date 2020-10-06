package newgrailsproject.com.info.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequestMapping(value = "/findInteger")
public class LengthController {

    @RequestMapping(value = "/findPositiveInteger")
    public static int solutionn(int[] A) {
        int res = 0;
        int[] arr = {1, 3, 6, 4, 1, 2};
        HashSet<Integer> list = new HashSet<>();

        for (int i : arr) list.add(i);
        for (int i = 1; i < 1000000; i++) {
            if(!list.contains(i)){
                res = i;
                break;
            }
        }
        return res;
    }

    public int solution(int m, int n) {
        // write your code in Java SE 8
        int[] patternTracker;

        if(m % 2 == 0)
            patternTracker = new int[] {n, 1, n^1, 0};
        else
            patternTracker = new int[] {m, m^n, m-1, (m-1)^n};

        return patternTracker[(n-m) % 4];
    }

}