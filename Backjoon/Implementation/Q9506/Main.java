package Backjoon.Implementation.Q9506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        ArrayList<Integer> cds = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while ((n=Integer.parseInt(br.readLine()))!=-1) {
            int sum = 0;

            for (int i=1; i<=n; i++) {
                if (i==n) {
                    if (sum!=n) {
                        cds.clear();
                        sb.append(n).append(" is NOT perfect.\n");
                        break;
                    }

                    else if (sum==n) {
                        sb.append(n).append(" = ");

                        for (int j=0; j<cds.size(); j++) {
                            sb.append(cds.get(j));
                            if (j!=cds.size()-1) sb.append(" + ");
                        }

                        sb.append("\n");
                        cds.clear();
                        break;
                    }
                }

                if (n%i==0) {
                    sum+=i;
                    cds.add(i);
                }
            }
        }

        System.out.println(sb);
    }
}
