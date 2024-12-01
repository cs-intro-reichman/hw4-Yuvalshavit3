public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]) + 1;
        boolean[] arr = new boolean[n];
        for(int i = 2; i < n; i++){
            arr[i] = true;
        }

        int i = 2;
        while (i < n) {
            int j = i + 1;
            while(j < n){
                if(j % i == 0){
                    arr[j] = false;
                }
                j++;
            }

            i++;
        }
        System.out.println("Prime numbers up to " + n + ":");

        int primeCount = 0;
        for(int m = 0; m < n; m++){
            if(arr[m] == true){
                System.out.println(m);
                primeCount++;
            }
        }

        int percent = primeCount * 100 / n;
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + percent + "% are primes)");

        }
    }
    
