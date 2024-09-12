import java.util.Scanner;

public class CribaDeEratostenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();
        scanner.close();

        long startTime = System.nanoTime();

        boolean[] esPrimo = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            esPrimo[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (esPrimo[p]) {
                for (int j = p * p; j <= n; j += p) {
                    esPrimo[j] = false;
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Los numeros primos hasta " + n + " son:");
        for (int i = 2; i <= n; i++) {
            if (esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Tiempo de ejecucion: " + duration + " nanosegundos.");
    }
}

