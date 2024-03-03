import com.sfedu.hashSet.WordWithDifference;
import com.sfedu.hashSet.WordWithHashSum;
import com.sfedu.treeSet.WordCompareByEqualsSymbols;
import com.sfedu.treeSet.WordCompareByFirstThreeSymbols;
import com.sfedu.treeSet.WordTreeSet;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {

    @Test
    void hashSetTest(){
        HashSet<WordWithHashSum> hashSums = new HashSet<>();

        hashSums.add(new WordWithHashSum("black"));
        hashSums.add(new WordWithHashSum("white"));
        hashSums.add(new WordWithHashSum("green"));
        hashSums.add(new WordWithHashSum("purple"));

        assertEquals(4, hashSums.size());
        System.out.println(hashSums);

        HashSet<WordWithDifference> hashDiff = new HashSet<>();

        hashDiff.add(new WordWithDifference("black"));
        hashDiff.add(new WordWithDifference("white"));
        hashDiff.add(new WordWithDifference("green"));
        hashDiff.add(new WordWithDifference("purple"));

        assertEquals(4, hashDiff.size());
        System.out.println(hashDiff);
    }

    @Test
    void TreeSetTestByLength(){
        TreeSet<WordTreeSet> treeSet = new TreeSet<>();

        treeSet.add(new WordTreeSet("black"));
        treeSet.add(new WordTreeSet("white"));
        treeSet.add(new WordTreeSet("green"));
        treeSet.add(new WordTreeSet("purple"));

        System.out.println(treeSet);
    }

    @Test
    void TreeSetByFirstThreeSymbols(){
        TreeSet<WordTreeSet> treeSet = new TreeSet<>(new WordCompareByFirstThreeSymbols());

        treeSet.add(new WordTreeSet("black"));
        treeSet.add(new WordTreeSet("white"));
        treeSet.add(new WordTreeSet("green"));
        treeSet.add(new WordTreeSet("purple"));

        System.out.println(treeSet);
    }

    @Test
    void TreeSetByByEqualsSymbols(){
        TreeSet<WordTreeSet> treeSet = new TreeSet<>(new WordCompareByEqualsSymbols());

        treeSet.add(new WordTreeSet("black"));
        treeSet.add(new WordTreeSet("white"));
        treeSet.add(new WordTreeSet("green"));
        treeSet.add(new WordTreeSet("purple"));

        System.out.println(treeSet);
    }

}
