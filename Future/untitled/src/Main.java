public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.run();
    }
}

class Solution{

    public void run(){
        Number n = new Number(1);
        doSomething(n);
        System.out.println(n);
    }

    private void doSomething(Number n) {
        n = new Number(2);
//        n.setNum(2);
    }
}

class Number{
    int num;

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "Number{" +
                "num=" + num +
                '}';
    }
}