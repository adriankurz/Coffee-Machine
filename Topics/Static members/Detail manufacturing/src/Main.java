class ManufacturingController {

    static int numberOfProducts = 0;

    public static String requestProduct(String product) {
        // write your code here
        numberOfProducts += 1;
        return numberOfProducts + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        // write your code here
        return numberOfProducts;
    }
}