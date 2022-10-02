import java.util.stream.IntStream;

public class Zadanie2 {

    public static void main(String[] args) {
        int x = 10;

        int[] numbers = IntStream.of(14, 10, 7, 3, 0).toArray();

        boolean result = new Zadanie2().search(numbers, x);
        System.out.println(result);
    }

    /**
     * Metoda zwraca informacje czy x znajduje się w tablicy numbers.
     * Szacowana złożoność obliczeniowa: O(log2(n))
     * Szacowana złożoność pamięciowa: O(1)
     *
     * @param numbers tablica liczb całkowitych do sprawdzenia
     * @param x liczba do znalezienia
     * @return wynik działania metody (true lub false)
     */
    private boolean search(int[] numbers, int x){
        int left = 0;
        int right = numbers.length-1;

        if(x > numbers[left] || x < numbers[right]){
            return false;
        }

        while(right > left + 1){
            int middle = (right + left) / 2;

            if(numbers[middle] < x){
                right = middle;
            }
            else{
                left = middle;
            }
        }

        return numbers[left] == x;
    }
}
