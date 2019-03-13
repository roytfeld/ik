package ik.Set5;

import java.io.*;
import java.util.*;

public class WordBreak {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 0;
        try {
            n = Integer.parseInt(in.nextLine().trim());
            bw.write("Loading dictionary of the size "+n);
            bw.newLine();
            List<String> dictionary = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String item = in.nextLine();
                dictionary.add(item);
                bw.write(item);
                bw.newLine();
            }
            String txt = in.nextLine().trim();
            bw.write("txt ="+txt);
            bw.newLine();
            List<String> res = solver(n, dictionary, txt);
            bw.write("Words break:");
            bw.newLine();
            for(String item: res) {
                bw.write(item);
                bw.newLine();
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static List<String> solver(int dictionaryCount, List<String> dictionary, String txt) {
        // Write your code here
        return wordBreakDPV2(txt, new HashSet<>(dictionary), new HashMap<>());
    }

    public static List<String> wordBreakDPV2(String s, Set<String> dictionary, Map<String, List<String>> DP) {
        for (int i = s.length()-1; i >= 0; i--) {
            String suffix = s.substring(i);
            List<String> result = new ArrayList<>();
            for (String d : dictionary) {
                if (suffix.startsWith(d)) {
                    String remainingS = suffix.substring(d.length());
                    if (remainingS.isEmpty()) {
                        result.add(d);
                    } else {
                        List<String> phrases = DP.get(remainingS);
                        for (String phrase : phrases)
                            result.add(d + " " + phrase);
                    }
                }
            }
            DP.put(suffix, result);
        }
        return DP.get(s);
    }
}
