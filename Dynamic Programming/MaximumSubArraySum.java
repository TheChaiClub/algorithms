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
				printSubArrayWithMaxSum(numbers);
			}
		}
	}

	public static void printSubArrayWithMaxSum(List<Integer> numbers){
		int startIndex =0, endIndex=0;
		int maxSum= 0, carryingSum= 0; 
		for(int i = 0; i < numbers.size(); i++){
			int currentNumber = numbers.get(i);

			if((carryingSum + currentNumber) >= currentNumber){
				carryingSum +=  currentNumber;
			} else {
				carryingSum = currentNumber;
				startIndex = i;
			}

			if(carryingSum > maxSum){
				maxSum = carryingSum;
				endIndex = i;
			}
		}
		System.out.println("An array have sub-array "+ getSubArray(numbers, startIndex, endIndex)+ " with maximum sum " +  maxSum);
	}

	public static String getSubArray(List<Integer> numbers, int startIndex, int endIndex){
		StringBuffer subArray = new StringBuffer();
		subArray.append("[ ");
		for(int i = startIndex; i <= endIndex; i++){
			subArray.append(numbers.get(i) + " ");
		}
		subArray.append("]");
		return subArray.toString();
	}
}