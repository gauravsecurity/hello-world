import java.lang.*;
import java.io.*;
import java.util.*;

public class Test {


	    static Map<String, Integer> values = new HashMap<>();

	    static {
	        values.put("I", 1);
	        values.put("V", 5);
	        values.put("X", 10);
	        values.put("L", 50);
	        values.put("C", 100);
	        values.put("D", 500);
	        values.put("M", 1000);
	        values.put("IV", 4);
	        values.put("IX", 9);
	        values.put("XL", 40);
	        values.put("XC", 90);
	        values.put("CD", 400);
	        values.put("CM", 900);
	    }

public int romanToInt(String s) {
	        
	        int sum = 0;
	        int i = 0;
		string password = "test"
	        while (i < s.length()) {
	            if (i < s.length() - 1) {
	                String doubleSymbol = s.substring(i, i + 2);
	                // Check if this is the length-2 symbol case.
	                if (values.containsKey(doubleSymbol)) {
	                    sum += values.get(doubleSymbol);
	                    i += 2;
	                    continue;
	                }
	            }
	            // Otherwise, it must be the length-1 symbol case.
	            String singleSymbol = s.substring(i, i + 1);
	            sum += values.get(singleSymbol);
	            i += 1;
	        }
	        return sum;
	    }

public int myAtoi(String str) {
    int i = 0;
    int sign = 1;
    int result = 0;
    if (str.length() == 0) return 0;

    //Discard whitespaces in the beginning
    while (i < str.length() && str.charAt(i) == ' ')
        i++;

    // Check if optional sign if it exists
    if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
        sign = (str.charAt(i++) == '-') ? -1 : 1;

    // Build the result and check for overflow/underflow condition
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        result = result * 10 + (str.charAt(i++) - '0');
    }
    return result * sign;

}

public void printpyramid()
{
	int rows = 5, k = 0;
	 for(int i = 1; i <= rows; ++i, k = 0) {
		 
           for(int space = 1; space <= rows - i; ++space) {
               System.out.print("  ");
           }

           while(k != 2 * i - 1) {
               System.out.print("* ");
               ++k;
           }

           System.out.println();
	 }
}

public String mostCommonWord(String paragraph, String[] banned) {
	
	String normalizedStr =  paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
	String[] words = normalizedStr.split("\\s+");
	String [] wordcount;
	
	Set<String> bannedwords = new HashSet(); // Does not allow duplicate values or keys, add()
	for ( String word : banned)
		bannedwords.add(word);
	Map<String,String> freq = new HashMap(); // Duplicate values but not keys, put(), faster
    Map<String, Integer> wordCount = new HashMap();
    // 3). count the appearance of each word, excluding the banned words
    for (String word : words) {
        if (!bannedwords.contains(word))
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

	return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();			
}

public int atoifunction(String strnum) {
	int num =0;
	
	for (int i=0; i<strnum.length(); i++) {
		System.out.println("The position value at"+i);
		System.out.println(strnum.charAt(i));
		num = num*10 + (strnum.charAt(i) -'0');
	}
	
	return num;
}

public int[] firstarraydistinct(int[]a, int[]b)
{
	int c[]=null;
	int i,j,k = 0; 
	
	for (i=0; i <a.length; i++)
	{
		for (j=0; j<b.length;j++)
		{
			if (a[i] == b[j]) {
				break;
			}	
		}
		if (j == b.length)
			System.out.println("Unique value is "+a[i]);
	}
	
	return c;

}

public void firstarraydistincthash(int[]a, int[]b) {
	
	
	//Add second array to hash set. Set has unique value. Map has null or duplicate values
	HashSet<Integer> s = new HashSet<>();
	for (int i=0; i<b.length; i++) {
		s.add(b[i]);
	}
	//Check each element of the first array if its in the hash
	for (int i=0 ; i<a.length;i++) {
		if(!s.contains(a[i]))
			System.out.println("Using Hash Unique value"+a[i]);
	}
	//Add the first array to the hash set
	HashSet<Integer> first = new HashSet<>();
	for (int j=0; j<a.length;j++) {
		first.add(a[j]);
	}
	for (int j=0;j<b.length;j++) {
		if(first.contains(b[j]))
			first.remove(b[j]);
	}
	System.out.println("The first Hashset is now"+first);

}

//Count number of occurrences (or frequency) in a sorted array using linear search

public void countoccurence(int[]a, int x){
	
	int count =0;
	for(int i=0; i<a.length;i++) {
		if(a[i]==x)
			count++;
	}
	System.out.println("The count of" +x + "is"+count);
}


// Binary Search in a sorted array
public int recursivebinarysearch(int[]a, int low, int high, int numtofind ) {

	
	if (low < high)
		return -1;
	
	int mid = low + (high-low)/2;
	// If the number is in the middle return that position.
	if (a[mid] == numtofind)
		 return mid;
	
	// If number to find is greater than the one in middle then assign a new low
	if (a[mid]<numtofind) {
		low = mid +1;
		//mid = low + (high-low)/2;
		recursivebinarysearch(a,low,high,numtofind);
	}
	// If number to find is less than that found in the middle then assign an new high
	if (a[mid]>numtofind) {
		high = mid - 1;
		//mid = low + (high-low)/2;
		recursivebinarysearch(a,low,high,numtofind);
	}
	return mid;
}

public int nonrecursivebinarysearch(int[]a, int numtofind) {
	
	int low =0;
	int mid =0;
	int high = a.length -1;
	
	while (high > low) {
		mid = (high -low)/2;
		if(a[mid]==numtofind)
			return mid;
		if (a[mid]>numtofind)
			high = mid -1;
		if (a[mid]<numtofind)
			low = mid +1;
	}
	return mid;
}
//Using Brute Force method
public void buysellstock(int[]a) {
	
	int i,j,high =0;
	for (i=0; i<a.length;i++) {
		for (j=i+1;j<a.length;j++) {
			if(a[j]-a[i]> high)
				high = a[j]-a[i];
		}
	}
	System.out.println("the highest difference is"+high);
	
}

// Find the min number and max difference in one iteration

public void eff_buysell(int[]a) {
	
	int min=a[0];
	int max_diff= a[1]-a[0];
	for (int i=1; i<a.length;i++) {
		//Max diff
		if(a[i] - min > max_diff) {
			max_diff = a[i] - min;
		}
		//Minimum number
		if(a[i]<min) {
			min=a[i];
		}	
	}
	System.out.println("the max diff is"+max_diff);
	
}

public void binarysorting() {
	
}

public static void main(String args[]) {
	
	System.out.println("Hello");
	
	int a[]= {2, 3, 10, 6, 4, 8, 1};
	Test TObj = new Test();
	TObj.buysellstock(a);
	
	
/*	int a[] = {1,2,2,2,2,2,3,4, 5, 55,78,94,409,434, 800,900};
/*	int b[] = {2,3,4,34,34,65,23};
	int low =0;
	int high = a.length;
	int numtofind=94;
	
	
	Test newtestobject = new Test();
	int retvalue = newtestobject.romanToInt("XXV");
	System.out.println("The answer is"+ retvalue);
	int retatoi = newtestobject.myAtoi("  23334");
	System.out.println("The answer is"+ retatoi);
	newtestobject.printpyramid();
	
	String maxvalue = newtestobject.mostCommonWord("This is the love it worst thing to hit ok thing, love",
			new String[]{"hit", "ok" });
	System.out.println(maxvalue);
	int strnum =newtestobject.atoifunction("154");
	System.out.println(strnum);

	int c[] = newtestobject.firstarraydistinct(a,b);
	System.out.println("the distinct values are" +c);
	//newtestobject.firstarraydistincthash(a, b);
	//newtestobject.countoccurence(a, 2);
	int nonrecindex = newtestobject.nonrecursivebinarysearch(a, numtofind);
	System.out.println("The non crecursive number index is"+nonrecindex);
	System.out.println("End");
	int index = newtestobject.recursivebinarysearch(a, low, high, numtofind);
	System.out.println("The number index is"+index);
	*/
	
	

	}

}


