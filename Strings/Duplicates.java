import java.util.HashSet;
import java.util.Set;

public class Duplicates {
	
	public static <T extends Comparable<?>> boolean containsDuplicates(Collection<T> elements){
		Set<T> elementsSet = new HashSet<>();
		for(T element: elements){
			if(!elementsSet.add(element)){
				return true;
			}
		}
		return false;
	}
}