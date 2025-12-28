package hnp.project.demoactivemq.test.all;

import java.util.*;
import java.util.stream.Collectors;

public class O1011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();

        while (t-- > 0) {
            int n = in.nextInt();
            in.nextLine();

            List<Integer> even = new ArrayList<>();
            List<Integer> odd = new ArrayList<>();

            String[] input = in.nextLine().split(" ");
            for (String s : input) {
                int rs = Integer.parseInt(s);
                if (rs % 2 == 0) {
                    even.add(rs);
                } else {
                    odd.add(rs);
                }
            }

            Set<Integer> evenSet = new HashSet<>(even);
            Set<Integer> oddSet = new HashSet<>(odd);

            even = new ArrayList<>(evenSet);
            odd = new ArrayList<>(oddSet);

            Collections.sort(even);

            Collections.sort(odd, Collections.reverseOrder());


            if (even.isEmpty()) {
                System.out.println("");
            } else {
                System.out.println(even.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
            }

            if (odd.isEmpty()) {
                System.out.println("");
            } else {
                System.out.println(odd.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
            }
        }
    }
}
