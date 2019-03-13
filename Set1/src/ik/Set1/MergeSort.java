package ik.Set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


public class MergeSort {

    public static void main(String[] args)
    {
        List<Integer> arr = new ArrayList<Integer>();
        for (String s: args) {
            try {
                arr.add(Integer.parseInt(s));
                System.out.println("Argument "+s+" added to the list");
            } catch (NumberFormatException e) {
                System.out.println("Argument "+s+" is not a number; skipping");
            }
        }
        if (arr.size() > 1) {
            DoSort(arr, 0, arr.size()-1);

        }
    }

    public static void DoSort(List<Integer> arr, int start, int end) {
        if (start < end) {
            int mid = start + (end-start)/2;
            System.out.println("Split element from "+start+" to "+end+" resulting in mid "+mid);
            DoSort(arr, start, mid);
            DoSort(arr, mid+1, end);
            Merge(arr, start, end, mid);
            PrintList(arr);
        }
    }

    public static void Merge(List<Integer> arr, int start, int end, int mid) {
        List<Integer> a = arr.subList(start, mid);
        int sizeA = a.size();
        List<Integer> b = arr.subList(mid+1, end);
        int sizeB = b.size();
        int i=0, j =0, k = start;
        while (i<sizeA && j<sizeB) {
            if (a.get(i)<=b.get(j)) {
                arr.set(k++, a.get(i++));
            } else {
                arr.set(k++, b.get(j++));
            }
        }
        while (i<sizeA) {
            arr.set(k++, a.get(i++));
        }
        while (j<sizeB) {
            arr.set(k++, b.get(j++));
        }

    }

    public static void PrintList(List<Integer> arr) {
        System.out.print("Current List: ");
        for (Integer e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

}
