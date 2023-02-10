import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMinNumberwithStream {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(-90, 1, 33, 54, 67, 12, 23, 45, 66);

		Integer maxNum = list.stream().max(Comparator.comparing(Integer::valueOf)).get();

		System.out.println("Maximum Number is : " + maxNum);

		Integer minValue = list.stream().min(Comparator.comparing(Integer::valueOf)).get();

		System.out.println("Minimum Number is : " + minValue);

	}

}
