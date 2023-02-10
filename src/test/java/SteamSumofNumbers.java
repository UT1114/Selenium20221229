import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SteamSumofNumbers {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,23,45,66);
		Optional<Integer> sum = list.stream().reduce((a,b) -> a+b);
		System.out.println(sum.get());
		
		
	}
	
	
	
}
