package numberrangesummarizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Scanner;
import java.util.Collections;

public class Main implements NumberRangeSummarizer {
    public static void main(String[] args) {
        boolean completed = false;
        do {
            try {
                System.out.println("Enter a list of Values:");
                Scanner Obj = new Scanner(System.in);
                String input = Obj.nextLine();
                NumberRangeSummarizer rangeMethod = new Main();
                Collection<Integer> output = rangeMethod.collect(input);
                String Result = rangeMethod.summarizeCollection(output);
                System.out.println(Result);
                completed = true;
            } catch (Exception e) {
                System.out.println("Incorrect Input. Enter numbers separated by comma with no spaces");
            }
        } while(!completed);

    }

    @Override
    public Collection<Integer> collect(String input) {

        //Create collection of integers
        Collection<Integer> integers = new ArrayList<>();
        //Split the input string at (,) delimiter
        String []list = input.split(",");
        //Add each integer into the collection
        for (String num: list) {
            integers.add(Integer.parseInt(num));
        }
        Collections.sort((List<Integer>) integers);
        return integers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        String output = "";
        //Initialize variables for previous, current, range start and range end
        int prev , cur, start = ((List<Integer>)input).get(0), end = ((List<Integer>)input).get(0);
        output += start;

        for (int i=0; i<input.size(); i++) {
            cur = ((List<Integer>)input).get(i);
            if(i != 0) {
                prev = ((List<Integer>)input).get(i-1);
            }else {
                prev = ((List<Integer>)input).get(i);
            }
            if (i == 0) {
                start = cur;
            }
            if (cur - prev <= 1) {
                end = cur;
            } else {
                if (start == end) {
                    output+=", ";
                }else if(end > start) {
                    output+="-"+end+", ";
                }else if (start > end) {
                    output+=", ";
                }
                start = cur;
                output+=start;
            }
        }
        return output;
    }
}
