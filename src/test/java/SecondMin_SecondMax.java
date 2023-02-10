import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondMin_SecondMax {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(-90, 1, 33, 54, 67, 12, 23, 45, 66);
        Integer secondHighest = list.stream()
        		.sorted(Collections.reverseOrder())
        		.distinct()
        		.skip(1)
        		.findFirst()
        		.get();
		System.out.println(secondHighest);
		  Integer secondLowest = list.stream().sorted().distinct().skip(1).findFirst().get();
			System.out.println(secondLowest);
	}

}
