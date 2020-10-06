package newgrailsproject.com.info

class PalindromeController {

    def index() {
        String original, reverse = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = scanner.nextLine();
        int length = original.length();

        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }

        if (original.equals(reverse)) {
            System.out.println("Entered string is a palindrome");
        } else {
            System.out.println("Entered string is not a palindrome");
        }

        respond "index", [status: "Entered string is " + original];
    }

    def show() {
        respond "show";
    }


}
