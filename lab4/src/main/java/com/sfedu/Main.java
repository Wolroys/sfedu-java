package com.sfedu;

import com.sfedu.hashSet.WordWithDifference;
import com.sfedu.hashSet.WordWithHashSum;
import com.sfedu.treeSet.WordCompareByEqualsSymbols;
import com.sfedu.treeSet.WordCompareByFirstThreeSymbols;
import com.sfedu.treeSet.WordTreeSet;

import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================Test1========================");
        test1();
        System.out.println("=================================================");

        System.out.println("====================Test2========================");
        test2();
        System.out.println("=================================================");

        System.out.println("====================Test3========================");
        test3();
        System.out.println("=================================================");

        System.out.println("====================Test4========================");
        test4();
        System.out.println("=================================================");

        System.out.println("====================Test5========================");
        test5();
        System.out.println("=================================================");
    }

    public static void test1(){
        HashSet<WordWithDifference> hashSet = new HashSet<>();

        hashSet.add(new WordWithDifference("apple"));
        System.out.println("Apple's hashcode: " + new WordWithDifference("apple").hashCode());
        hashSet.add(new WordWithDifference("banana"));
        System.out.println("Banana's hashcode: " + new WordWithDifference("banana").hashCode());
        hashSet.add(new WordWithDifference("cherry"));
        System.out.println("Cherry's hashcode: " + new WordWithDifference("cherry").hashCode());
        hashSet.add(new WordWithDifference("mango"));
        System.out.println("Mango's hashcode: " + new WordWithDifference("mango").hashCode());
        hashSet.add(new WordWithDifference("orange"));
        System.out.println("Orange's hashcode: " + new WordWithDifference("orange").hashCode());
        hashSet.add(new WordWithDifference("pineapple"));
        System.out.println("Pineapple's hashcode: " + new WordWithDifference("pineapple").hashCode());
        hashSet.add(new WordWithDifference("banana"));
        System.out.println("Banana's hashcode: " + new WordWithDifference("banana").hashCode());
        hashSet.add(new WordWithDifference("bdsadsdsa"));
        System.out.println("bdsadsdsa's hashcode: " + new WordWithDifference("bdsadsdsa").hashCode());

        System.out.println(hashSet);
    }

    public static void test2() {
        HashSet<WordWithHashSum> hashSet = new HashSet<>();

        hashSet.add(new WordWithHashSum("apple"));
        System.out.println("Apple's hashcode: " + new WordWithHashSum("apple").hashCode());
        hashSet.add(new WordWithHashSum("banana"));
        System.out.println("Banana's hashcode: " + new WordWithHashSum("banana").hashCode());
        hashSet.add(new WordWithHashSum("cherry"));
        System.out.println("Cherry's hashcode: " + new WordWithHashSum("cherry").hashCode());
        hashSet.add(new WordWithHashSum("mango"));
        System.out.println("Mango's hashcode: " + new WordWithHashSum("mango").hashCode());
        hashSet.add(new WordWithHashSum("orange"));
        System.out.println("Orange's hashcode: " + new WordWithHashSum("orange").hashCode());
        hashSet.add(new WordWithHashSum("pineapple"));
        System.out.println("Pineapple's hashcode: " + new WordWithHashSum("pineapple").hashCode());
        hashSet.add(new WordWithHashSum("banana"));
        System.out.println("Banana's hashcode: " + new WordWithHashSum("banana").hashCode());

        System.out.println(hashSet);
    }

    public static void test3() {
        TreeSet<WordTreeSet> treeSet = new TreeSet<>();

        treeSet.add(new WordTreeSet("apple"));
        System.out.println("Apple's length: " + new WordTreeSet("apple").getWord().length());
        treeSet.add(new WordTreeSet("banana"));
        System.out.println("Banana's length: " + new WordTreeSet("banana").getWord().length());
        treeSet.add(new WordTreeSet("cherry"));
        System.out.println("Cherry's length: " + new WordTreeSet("cherry").getWord().length());
        treeSet.add(new WordTreeSet("mango"));
        System.out.println("Mango's length: " + new WordTreeSet("mango").getWord().length());
        treeSet.add(new WordTreeSet("orange"));
        System.out.println("Orange's length: " + new WordTreeSet("orange").getWord().length());
        treeSet.add(new WordTreeSet("pineapple"));
        System.out.println("Pineapple's length: " + new WordTreeSet("pineapple").getWord().length());
        treeSet.add(new WordTreeSet("banana"));
        System.out.println("Banana's length: " + new WordTreeSet("banana").getWord().length());

        System.out.println(treeSet);
    }

    public static void test4() {
        TreeSet<WordTreeSet> treeSet = new TreeSet<>(new WordCompareByFirstThreeSymbols());

        treeSet.add(new WordTreeSet("apple"));
        System.out.println("Apple's first three symbols: " + new WordTreeSet("apple").getWord().substring(0, Math.min(3, "apple".length())));
        treeSet.add(new WordTreeSet("banana"));
        System.out.println("Banana's first three symbols: " + new WordTreeSet("banana").getWord().substring(0, Math.min(3, "banana".length())));
        treeSet.add(new WordTreeSet("cherry"));
        System.out.println("Cherry's first three symbols: " + new WordTreeSet("cherry").getWord().substring(0, Math.min(3, "cherry".length())));
        treeSet.add(new WordTreeSet("mango"));
        System.out.println("Mango's first three symbols: " + new WordTreeSet("mango").getWord().substring(0, Math.min(3, "mango".length())));
        treeSet.add(new WordTreeSet("orange"));
        System.out.println("Orange's first three symbols: " + new WordTreeSet("orange").getWord().substring(0, Math.min(3, "orange".length())));
        treeSet.add(new WordTreeSet("pineapple"));
        System.out.println("Pineapple's first three symbols: " + new WordTreeSet("pineapple").getWord().substring(0, Math.min(3, "pineapple".length())));
        treeSet.add(new WordTreeSet("banana"));
        System.out.println("Banana's first three symbols: " + new WordTreeSet("banana").getWord().substring(0, Math.min(3, "banana".length())));

        System.out.println(treeSet);
    }

    public static void test5() {
        TreeSet<WordTreeSet> treeSet = new TreeSet<>(new WordCompareByEqualsSymbols());

        treeSet.add(new WordTreeSet("apple"));
        System.out.println("Apple's equal symbols: " + countEqualSymbols("apple"));
        treeSet.add(new WordTreeSet("banana"));
        System.out.println("Banana's equal symbols: " + countEqualSymbols("banana"));
        treeSet.add(new WordTreeSet("cherry"));
        System.out.println("Cherry's equal symbols: " + countEqualSymbols("cherry"));
        treeSet.add(new WordTreeSet("mango"));
        System.out.println("Mango's equal symbols: " + countEqualSymbols("mango"));
        treeSet.add(new WordTreeSet("orange"));
        System.out.println("Orange's equal symbols: " + countEqualSymbols("orange"));
        treeSet.add(new WordTreeSet("pineapple"));
        System.out.println("Pineapple's equal symbols: " + countEqualSymbols("pineapple"));
        treeSet.add(new WordTreeSet("banana"));
        System.out.println("Banana's equal symbols: " + countEqualSymbols("banana"));

        System.out.println(treeSet);
    }

    public static int countEqualSymbols(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (i != j && word.charAt(i) == word.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
