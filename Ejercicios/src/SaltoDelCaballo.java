public class SaltoDelCaballo {
    // Tamaño del tablero
    private static final int N = 8;

    // Movimientos posibles del caballo
    private static final int[] movX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] movY = {1, 2, 2, 1, -1, -2, -2, -1};

    // Método para imprimir el tablero
    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Método para verificar si una posición (x, y) es válida en el tablero
    private static boolean esValido(int x, int y, int[][] tablero) {
        return (x >= 0 && x < N && y >= 0 && y < N && tablero[x][y] == -1);
    }

    // Método para resolver el problema del salto del caballo usando backtracking
    private static boolean resolverSaltoCaballo(int[][] tablero, int paso, int x, int y) {
        if (paso == N * N) {
            return true; // Se ha recorrido todo el tablero
        }

        // Probar los 8 movimientos posibles del caballo
        for (int i = 0; i < 8; i++) {
            int siguienteX = x + movX[i];
            int siguienteY = y + movY[i];

            if (esValido(siguienteX, siguienteY, tablero)) {
                tablero[siguienteX][siguienteY] = paso;

                // Recursión para intentar resolver el siguiente paso
                if (resolverSaltoCaballo(tablero, paso + 1, siguienteX, siguienteY)) {
                    return true;
                } else {
                    // Backtracking: deshacer el movimiento
                    tablero[siguienteX][siguienteY] = -1;
                }
            }
        }

        return false; // Si no se encuentra solución, se regresa false
    }

    public static void main(String[] args) {
        // Inicializar el tablero con -1
        int[][] tablero = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = -1;
            }
        }

        // Posición inicial del caballo
        int xInicial = 0, yInicial = 0;
        tablero[xInicial][yInicial] = 0; // Primer paso

        // Resolver el problema
        if (resolverSaltoCaballo(tablero, 1, xInicial, yInicial)) {
            imprimirTablero(tablero); // Imprimir el tablero si hay solución
        } else {
            System.out.println("No se encontró solución.");
        }
    }
}