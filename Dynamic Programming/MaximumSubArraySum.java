import java.util.*;

public class MaximumSubArraySum {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
			int sizeOfArray = scanner.nextInt();
			List<Integer> numbers = new ArrayList<>(sizeOfArray);
			for(int i = 0; i < sizeOfArray; i++){
				numbers.add(scanner.nextInt());
			}
			if(!numbers.isEmpty()){
				System.out.println("An array have a sub-array with maximum sum of "+ getMaxSubarraySum(numbers));
			}
		}
	}

	public static int getMaxSubarraySum(List<Integer> numbers){
		int maxSum= 0, carryingSum= 0; 
		for(int currentNumber : numbers){

			if((carryingSum + currentNumber) >= currentNumber){
				carryingSum +=  currentNumber;
			} else {
				carryingSum = currentNumber;
			}

			if(carryingSum > maxSum){
				maxSum = carryingSum;
			}
		}
		return maxSum;
	}
}