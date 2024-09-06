public class RecorrerArrayRecursividad {
    public static void main(String[] args) {
        // Recorrer un array de forma recursiva
        int[] vector = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int inicio = 0;
        int fin = vector.length - 1;
        recorrerArray(vector, inicio, fin);
    }

    private static void recorrerArray(int[] vector, int inicio, int fin) {
        if (inicio <= fin) {
            System.out.println(vector[inicio]);
            recorrerArray(vector, inicio + 1, fin);
        }
    }
}