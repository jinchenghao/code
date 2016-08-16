
public class charuSort {
	static void  insertionSort(int a[]){
		int i,j,t,h;
		
		for(i = 1;i<a.length;i++)
		{
			t = a[i];
			j = i-1;
			while(j >= 0 && t<a[j])
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = t;
		}
		for(h = 0; h<a.length; h++)
		{
			System.out.print(" "+a[h]);
		}
		System.out.print("\n");
		
	}

	public static void main(String[] args){
		int[] a = {8,6,9,5,7,1,3,7,5};
		insertionSort(a);
	}

}
