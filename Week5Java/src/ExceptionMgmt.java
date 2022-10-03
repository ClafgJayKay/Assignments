public class ExceptionMgmt {
    public ExceptionMgmt() {
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{1, 3, 5};

        try {
            System.out.println(isExists(myArr, 5));
        } catch (CustException asdf) {
            asdf.printStackTrace();
        }

    }

    public static boolean isExists(int[] myArr, int index) throws CustException {
        if (index > myArr.length) {
            throw new CustException("error found");
        } else {
            return true;
        }
    }
}
