import java.util.Arrays;
import java.util.List;

public class FilterAverage {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 23, 45, 66);

		double average = list.stream().map(e -> e*e).filter(e -> e>100).mapToInt(e -> e).average().getAsDouble();
		System.out.println("The average is : " + average);

	}
}
