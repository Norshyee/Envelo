import java.util.stream.IntStream;

public class Zadanie2 {

    public static void main(String[] args) {
        int x = 10;

        int[] numbers = IntStream.of(14, 10, 7, 3, 0).toArray();

        boolean result = new Zadanie2().search(numbers, x);
        System.out.println(result);
    }

    public boolean searchNumber(int[] numbers, int x){
        return search(numbers, x);
    }

    /**
     * Metoda zwraca informacje czy x znajduje się w tablicy numbers.
     * Szacowana złożoność obliczeniowa: O(log n)
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

        while(left <= right){
            int middle = (right + left) / 2;

            if (numbers[middle] == x)
                return true;

            if(numbers[middle] < x){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }

        return false;
    }
}
