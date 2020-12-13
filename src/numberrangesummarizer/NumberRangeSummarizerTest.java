package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class NumberRangeSummarizerTest {

    @Test
    public void testCollect() throws Exception {
        NumberRangeSummarizer number_summarizer = new Main();
        Collection<Integer> testList = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> list = number_summarizer.collect(input);
        assertArrayEquals(list.toArray(), testList.toArray());
    }

    @Test
    public void testSummarizeCollection() throws Exception {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        NumberRangeSummarizer number_summarizer = new Main();
        ArrayList<Integer> integers = (ArrayList<Integer>) number_summarizer.collect(input);
        assertEquals( "1, 3, 6-8, 12-15, 21-24, 31", number_summarizer.summarizeCollection(integers));
    }

    @Test
    public void testDuplicate() throws Exception {
        NumberRangeSummarizer number_summarizer = new Main();
        String input = "1,3,3,5,5,7,9,11,12,12,13,14,16";
        String compare = "1, 3, 5, 7, 9, 11-14, 16";
        Collection<Integer> output = number_summarizer.collect(input);
        String Result = number_summarizer.summarizeCollection(output);
        assertEquals(Result, compare);
    }

    @Test
    public void testNegative() throws Exception {
        NumberRangeSummarizer number_summarizer = new Main();
        String input = "-8,-6,-1,1,4,5,6,7,8,9,13";
        String compare = "-8, -6, -1, 1, 4-9, 13";
        Collection<Integer> output = number_summarizer.collect(input);
        String Result = number_summarizer.summarizeCollection(output);
        Assert.assertEquals(Result, compare);
    }

}
