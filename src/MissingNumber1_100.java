import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MissingNumber1_100 {
	
/*	static int getMissingNo(int a[], int n)
    {
        int i, total;
        total = (n + 1) * (n + 2) / 2;
        System.out.println(total);
        for (i = 0; i < n; i++)
            total -= a[i];
        return total;
    }*/
	
	static int getMissingNo(int a[],int n) {
		int total = n *(n+1)/2;
		System.out.println(total);
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum += a[i];
		}
		return total-sum;
	}
	
	
	static int[] copyArray(int a[]) {
		int a2[] = new int[a.length];
		for(int i=0;i<a.length;i++)
			a2[i] = a[i];
		
		return a2;
	}
	
	
	static void frequencyCount(int a[]) {
		int freqCount[] = new int[a.length];
		int count=0;
		int visited = -1;
		for(int i=0;i<a.length;i++) {
			count = 1;
			for(int j=i+1;j<a.length;j++) {
				if(a[i] == a[j]) {
					count++;
					freqCount[j] = visited;
				}
			}
			if(freqCount[i]!=visited) {
				System.out.println(freqCount[i]);
				freqCount[i] = count;
			}
		}
		
		for(int i = 0; i < freqCount.length; i++){  
            if(freqCount[i] != visited)  
                System.out.println("    " + a[i] + "    |    " + freqCount[i]);  
        }  
		
	}
	
	static void printStar(){
		for(int i=5;i>0;i--) {
			for(int j=i;j<5-i;j++) {
				System.out.println(" ");
			}
		}
	}
	
	static int [] leftRotate(int a[]){
		int temp = a[0];
		for(int i=0;i<a.length-1;i++) {
			a[i] = a[i+1];
		}
		a[a.length-1] = temp;
		
		return a;
	}
	
	static void rightRotate(int a[]){
		int temp = a[a.length-1];
		for(int i=0;i<a.length-1;i++) {
			a[i+1] = a[i];
		}
		a[0] = temp;
		
		for(int e : a)
			System.out.print(e + " ");
	}
	
	static int findIndex(int a[] , int e) {
		int index = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i] == e) {
				index = i+1;
				break;
			}	
			else
				index = -1;
		}
		return index;
	}
	
	static int [] removeElement(int a[] , int e) {
		boolean flag = false;
		int index = 0;
		int newArray[] = new int[a.length-1];
		for(int i=0;i<a.length;i++) {
			if(a[i] == e) {
				flag = true;
			    index = i;
				break;
			}
			else
				flag = false;
		}
		
		if(flag == true) {
			for(int i=0,k=0;i<a.length;i++) {
				if(i == index) 
					continue;
				newArray[k++] = a[i];
			}
				
		}
		else
			System.out.println("element not found");
		
		return newArray;
	}
	
	static int[] insertElement(int a[] , int t , int e) {
		int newArray[] = new int[a.length+1];
		for(int i=0;i<newArray.length;i++) {
			if(i<t-1)
				newArray[i] = a[i];
			else if(i == t-1)
				newArray[i] = e;
			else
				newArray[i] = a[i-1];
		}
		return newArray;	
	}
	
	static int[] reverseArray(int a[]) {
		int newArray[] = new int[a.length];
		for(int i=a.length-1,k=0;i>=0;i--,k++) {
			newArray[k] = a[i];
		}
		return newArray;	
	}

	static void duplicateElement(int a[]) {
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i] == a[j]) {
					System.out.println("duplicate elements : " + a[j]);
				}
			}
		}
	}

	static void duplicateString() {
		String s[] = {"java" , "c" , "java" , "c++" , "c"};
		for(int i=0;i<s.length;i++) {
			for(int j=i+1;j<s.length;j++) {
				if(s[i].equals(s[j]))
					System.out.println("duplicate element is : " + s[j]);
			}
		}
	}
	
	static void duplicateStringUsingMap() {
		String s[] = {"java" , "c" , "java" , "c++" , "c" , "java"};
		HashMap<String , Integer> map = new HashMap<>();
		for(int i=0;i<s.length;i++) {
			if(map.containsKey(s[i]))
				map.put(s[i], map.get(s[i])+1);
			else
				map.put(s[i], 1);
		}
		
		for(String s1 : map.keySet()) {
				if(map.get(s1)>1)
					System.out.println(s1 + " occuring : " + map.get(s1) + " times");
		}
	}
	
	static void commonElements(int a[] , int b[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int temp : a)
			set.add(temp);
		
		for(int temp : b) {
			if(set.contains(temp))
				System.out.println(temp);
		}
	}
	
	static void commonElementsWithoutSet(int a[] , int b[]) {
		Arrays.sort(a);
		Arrays.sort(b);
		int len1 = a.length;
		int len2 = b.length;
		int i=0,j=0;
		while(i < len1 && j < len2) {
			if(a[i] > b[j])
				j++;
			else if(b[j] > a[i])
				i++;
			else {
				System.out.println(a[i]);
				i++;
				j++;
			}
		}
	}
	
	static void commonString() {
		String s1[] = {"java" , "c" , "c++" , "py"};
		String s2[] = {"c" , "aa" , "java" ,"bb"};
		HashSet<String> set = new HashSet<String>();
		for(String str1 : s1) {
			for(String str2 : s2) {
				if(str1.equals(str2))
					set.add(str1);
			}
		}
		System.out.println(set);
	}
	
	static void segrate0And1(int a[]) {
	/*	Arrays.sort(a);
		for(int arr : a)
			System.out.print(arr+" ");
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int arr :a)
			list.add(arr);
		Collections.sort(list);
		System.out.println(list);*/
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>=a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int arr : a)
			System.out.print(arr+" ");
		System.out.println();
		
		int cnt=0;
		for(int i=0;i<a.length;i++) {
			if(a[i] == 0)
				cnt++;
		}
		for(int i=0;i<cnt;i++)
			a[i] = 0;
		for(int i=cnt;i<a.length;i++)
			a[i] = 1;
		for(int arr : a)
			System.out.print(arr+" ");
			
	}
	
	static void stringQus1() {
		String s1 = "matrix";
		for(int i=0;i<s1.length();i++) {
			System.out.println(s1);
			s1 = s1.substring(1)+s1.charAt(0);
		}
	}
	
	static void stringQus2() {
		String s1= "matrix is a coaching";
		
		String s[] = s1.split(" ");
		for(String str : s)
			System.out.println(str);
		for(int i=1;i<s1.length();i++) {
			System.out.println(s1.substring(0, i));
		}
		for(int i=s1.length()-1;i>0;i--)
			System.out.println(s1.substring(0, i));
	}
	
	static void delete(int a[], int n) {
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i] == n) {
					a[i] = a[j];
					break;
				}
			}
		}
		for(int arr : a)
			System.out.println(arr);
	}
	
	static void pattern(int a[]) {
		int cnt=1;
		for(int i=0;i<a.length;i++) {
			if(cnt<=3) {
				System.out.print(a[i] + ",");
				cnt++;
			}
			else {
				
				System.out.println();
				System.out.print(a[i] + ",");
				cnt=2;
			}
		}
	}
	
	static void powerOfNumber(){
		int n = 151;
		int cnt=0;
		int sum=0;
		int mul=1;
		int digit = 0;
		int temp=n;
		while(temp>0) {
			temp = temp/10;
			cnt++;
		}
		System.out.println("digit is: " +cnt);
		while(n>0) {
			digit = n % 10;
			while(cnt>0) {
			mul = mul * digit;
			cnt--;
			}
			sum+=mul;
			n = n / 10;
		}
		
		System.out.println("sum is : " + sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 4, 5, 2, 2, 4, 6};
		int b[] = {1, 2, 9, 8, 4, 7, 6};
	/*	int n = a.length+1;
		System.out.println(n);
        int miss = getMissingNo(a,n	);
        System.out.println(miss);
        
        
        int a2[] = copyArray(a);
        for(int arr : a2)
        	System.out.print(arr);
        
        
        frequencyCount(a);
        printStar();*/
		
	/*	int arr[] = leftRotate(a);
		for(int e : arr)
			System.out.print(e + " ");*/
		
	//	System.out.println();
		
	//	rightRotate(a);
		
	//	int index = findIndex(a,5);
	//	System.out.println("index of element is : " + index);
		
	/*	int arr[] = removeElement(a , 5);
		for(int e : arr)
			System.out.println(e);*/
		
	/*	int arr[] = insertElement(a , 2 , 9);
		for(int e : arr)
			System.out.println(e);	*/
		
	/*	int arr[] = reverseArray(a);
		for(int e : arr)
			System.out.println(e);*/
		
	//	duplicateElement(a);
	//	duplicateString();
	//	duplicateStringUsingMap();
	//	commonElements(a , b);
	//	commonElementsWithoutSet(a , b);
	//	commonString();
	/*	int c[] = {0,1,0,0,1,1,0,1};
		segrate0And1(c);*/
	//	stringQus1();
	//	stringQus2();
	//	delete(a,2);
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
	//	pattern(arr);
		powerOfNumber();
	}

}
