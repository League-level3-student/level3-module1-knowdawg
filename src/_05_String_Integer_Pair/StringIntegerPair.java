package _05_String_Integer_Pair;



import java.sql.Array;

public class StringIntegerPair {
	//1. create a private array of Strings called keys. Don't initialize it.
	private String[] keys;
	//2. create a private array of integers called values.
	private Integer[] values;
	StringIntegerPair(){
		//3. initialize both member arrays to a length of 0
		keys = new String[0];
		values = new Integer[0];
	}
	
	// 4. Complete the steps in the put method
	public void put(String key, int value) {
		//A. iterate through the keys. If you find a key that matches
		//   the passed in String, set the value at that location to the
		//   passed in value and return from the method.
		
		for (int i = 0; i < keys.length; i++) {
			if(keys[i].equals(key)) {
				values[i] = value;
				break;
			}
		}
		
		//B. create a String array that is one element longer than the keys
		String[] newKeys = new String[keys.length + 1];
		//C. create an Integer array that is one element longer than values
		Integer[] newValues = new Integer[values.length + 1];
		//D. set the last element of the new String array to the passed in key
		newKeys[keys.length + 1] = keys[keys.length];
		//E. set the last element of the new int array to the passed in value
		newValues[values.length + 1] = values[values.length];
		//F. iterate through the keys and values and copy the elements to the new arrays
		for (int i = 0; i < values.length; i++) {
			newValues[i] = values[i];
			newKeys[i] = keys[i];
		}
		//G. Set the keys and values arrays equal to the new arrays created in steps B and C.
		keys = newKeys;
		values = newValues;
	}
	
	//5. Complete the method so it returns the value located at the passed in key.
	//   If the key does not exist, return Integer.MIN_VALUE.
	public int get(String key) {
		
		int placeHolder = -1;
		for (int i = 0; i < keys.length; i++) {
			if(key.equals(keys[i])) {
				placeHolder = i;
			}
		}
		if(placeHolder == -1) {
			return Integer.MIN_VALUE;
		}else {
			return values[placeHolder];
		}
	}
	
	//6. Complete the containsKey method so that it returns true if the
	//   passed in keys is contained in the keys array
	public boolean containsKey(String key) {
		
		for (int i = 0; i < keys.length; i++) {
			if (key.equals(keys[i])) {
				return true;
			}
		}
		return false;
	}
	
	//7. Complete the containsValue method so that it returns true if the
	//   passed in value is contained in the values array
	public boolean containsValue(int value) {
		
		for (int i = 0; i < values.length; i++) {
			if (value == values[i]) {
				return true;
			}
		}
		return false;
	}
	
	//8. Complete the getKeysMethod so it returns the keys as an array
	public String[] getKeys() {
		return keys;
	}
	
	//9. Complete the getValues so it returns the values as an array
	public int[] getValues() {
		return null;
	}
}
