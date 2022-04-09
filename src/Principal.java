import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		List<Integer> smallestList = new ArrayList<Integer>();
		
		//String numbers = "51 98 12 31 09 21 20 77 65 10";

		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite os números para a pirâmide:");
		String numbers = teclado.nextLine();
		String splitNumbers[] = numbers.split(" ");
		
		
		while(!isTriangular(splitNumbers.length)){
			System.out.println(splitNumbers.length + " não é um número triangular, ou seja essa quantidade de números "
					+ "não pode ser transformada em uma pirâmide!\n");
			System.out.println("Digite novamente outros números:");
			numbers = teclado.nextLine();
			splitNumbers = numbers.split(" ");
		}

		teclado.close();

		int array[] = convertArray(splitNumbers);
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<array.length;i++) {
			if(isTriangular(i + 1)) {
				list.add(array[i]);
				
				smallestList.add(getSmallestNumber(list));
				
				for (int x : list) {
					String number = x < 10 ? "0" + Integer.toString(x) : Integer.toString(x);
					
					System.out.print(number + " ");
				}
				System.out.print("\n");
				
				
				list = new ArrayList<Integer>();
				continue;
			}
			list.add(array[i]);
		}
		
		
		System.out.print("Soma: ");
		for (int i = 0; i < smallestList.size(); i++) {
			System.out.print(smallestList.get(i) + " ");
			if(i == smallestList.size() - 1) {
				System.out.print("= " + sumAllList(smallestList));
				break;
			}
			System.out.print("+ ");
		}
	}
	
	static int[] convertArray(String numbers[]) {
		int array[] = new int[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			array[i] = Integer.parseInt(numbers[i]);
		}
		return array;
	}
	
	static boolean isTriangular(int num){
        if (num < 0)
            return false;
     
        int sum = 0;
         
        for (int i = 1; sum <= num; i++)
        {
            sum = sum + i;
            if (sum == num)
                return true;
        }
     
        return false;
    }
	
	static int getSmallestNumber(List<Integer> list) {
		
		if(list.size() == 1)
			return list.get(0);
		
		int aux = Integer.MAX_VALUE;
		
		for(int i : list) {
			if(i < aux)
				aux = i;
		}
		return aux;
	}
	
	static int sumAllList(List<Integer> list) {
		int x=0;
		for(int i : list) {
			x+=i;
		}
		return x;
	}
}
