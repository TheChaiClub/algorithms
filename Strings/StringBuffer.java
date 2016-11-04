import java.util.Arrays;

public class StringBuffer {
	private char [] bufferArray;
	private int size = 0;
	
	public StringBuffer(int paramInt){
		bufferArray = new char[paramInt];
	}
	
	public void append(String s){
		ensureCapacity(size+s.length());
		System.arraycopy(s, 0, bufferArray, size, s.length());
		size += s.length();
	}

	private void ensureCapacity(int paramInt) {
		if(paramInt <= bufferArray.length)
			return;
		grow(paramInt);
	}

	private void grow(int paramInt) {
		int newSize = paramInt << 1;
		bufferArray = Arrays.copyOf(bufferArray, newSize);
	}
	
	public String toString(){
		return String.valueOf(bufferArray);
	}

	public void append(char char1) {
		ensureCapacity(size+1);
		bufferArray[size++] = char1;
	}
	
}
