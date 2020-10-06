package newgrailsproject

class TestController {

    def index() {
//        int[] arr =new int[4, 2, 4, 5, 2, 3, 1];
        int[] arr = new int[6];
        arr[0] = 5;
        arr[1] = 15;
        arr[2] = 25;
        arr[3] = 35;
        arr[4] = 45;
        arr[5] = 45;
        int arr_size = arr.length;
        printRepeating(arr, arr_size);

        System.out.println("Factorial of 5 is: "+factorial(5));
        render("This is a grails controller." + factorial(5))
    }



    static int factorial(int n){
        if (n == 1)
            return 1;
        else
            return(n * factorial(n-1));
    }

    void printRepeating(int[] arr, int size)
    {
        int i, j;
        System.out.println("Repeated Elements are :");
        for (i = 0; i < size; i++)
        {
            for (j = i + 1; j < size; j++)
            {
                if (arr[i] == arr[j])
                    System.out.print(arr[i] + " ");
            }
        }
    }

    def duplicates() {
        int[] arr = new int[7];
        arr[0] = 5;
        arr[1] = 15;
        arr[2] = 25;
        arr[3] = 35;
        arr[4] = 35;
        arr[5] = 45;
        arr[6] = 45;
//        int arr[] = { 1, 2, 5, 1, 7, 2, 4, 2 };
        render( "removeDuplicates "+ removeDuplicates(arr))
    }

    public static void removeDuplicates(int[] arr)
    {
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        // adding elements to LinkedHashSet
        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);

        // Print the elements of LinkedHashSet
        System.out.print(set);
    }

}
