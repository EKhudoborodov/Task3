import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // TASK №1
        System.out.printf("solutions(1, 0, -1) -> %d\n", solutions(1, 0, -1));
        System.out.printf("solutions(1, 0, 0) -> %d\n", solutions(1, 0, 0));
        System.out.printf("solutions(1, 0, 1) -> %d\n\n", solutions(1, 0, 1));
        // TASK №2
        System.out.printf("findZip(\"all zip files are zipped\") -> %d\n", findZip("all zip files are zipped"));
        System.out.printf("findZip(\"all zip files are compressed\") -> %d\n\n", findZip("all zip files are compressed"));
        // TASK №3
        System.out.printf("checkPerfect(6) -> %b\n", checkPerfect(6));
        System.out.printf("checkPerfect(28) -> %b\n", checkPerfect(28));
        System.out.printf("checkPerfect(496) -> %b\n", checkPerfect(496));
        System.out.printf("checkPerfect(12) -> %b\n", checkPerfect(12));
        System.out.printf("checkPerfect(97) -> %b\n\n", checkPerfect(97));
        // TASK №4
        System.out.printf("flipEndChars(\"Cat, dog, and mouse.\") -> \"%s\"\n", flipEndChars("Cat, dog, and mouse."));
        System.out.printf("flipEndChars(\"ada\") -> \"%s\"\n", flipEndChars("ada"));
        System.out.printf("flipEndChars(\"Ada\") -> \"%s\"\n", flipEndChars("Ada"));
        System.out.printf("flipEndChars(\"z\") -> \"%s\"\n\n", flipEndChars("z"));
        // TASK №5
        System.out.printf("isValidHexCode(\"#CD5C5C\") -> %b\n", isValidHexCode("#CD5C5C"));
        System.out.printf("isValidHexCode(\"#EAECEE\") -> %b\n", isValidHexCode("#EAECEE"));
        System.out.printf("isValidHexCode(\"#eaecee\") -> %b\n", isValidHexCode("#eaecee"));
        System.out.printf("isValidHexCode(\"#CD5C58C\") -> %b\n", isValidHexCode("#CD5C58C"));
        System.out.printf("isValidHexCode(\"#CD5C5Z\") -> %b\n", isValidHexCode("#CD5C5Z"));
        System.out.printf("isValidHexCode(\"#CD5C&C\") -> %b\n", isValidHexCode("#CD5C&C"));
        System.out.printf("isValidHexCode(\"CD5C5C\") -> %b\n\n", isValidHexCode("CD5C5C"));
        // TASK №6
        System.out.printf("same([1, 3, 4, 4, 4], [2, 5, 7]) -> %b\n", same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.printf("same([9, 8, 7, 6], [4, 4, 3, 1]) -> %b\n", same(new int[]{9, 8, 7, 6}, new int[] {4, 4, 3, 1}));
        System.out.printf("same([2], [3, 3, 3, 3, 3]) -> %b\n\n", same(new int[]{2}, new int[] {3, 3, 3, 3, 3}));
        // TASK №7
        System.out.printf("isKaprekar(3) -> %b\n", isKaprekar(3));
        System.out.printf("isKaprekar(5) -> %b\n", isKaprekar(5));
        System.out.printf("isKaprekar(297) -> %b\n\n", isKaprekar(297));
        // TASK №8
        System.out.printf("longestZero(\"01100001011000\") -> \"%s\"\n", longestZero("01100001011000"));
        System.out.printf("longestZero(\"100100100\") -> \"%s\"\n", longestZero("100100100"));
        System.out.printf("longestZero(\"11111\") -> \"%s\"\n\n", longestZero("11111"));
        // TASK №9
        System.out.printf("nextPrime(12) -> %d\n", nextPrime(12));
        System.out.printf("nextPrime(24) -> %d\n", nextPrime(24));
        System.out.printf("nextPrime(11) -> %d\n\n", nextPrime(11));
        // TASK №10
        System.out.printf("rightTriangle(3, 4, 5) -> %b\n", rightTriangle(3, 4, 5));
        System.out.printf("rightTriangle(145, 105, 100) -> %b\n", rightTriangle(145, 105, 100));
        System.out.printf("rightTriangle(70, 130, 110) -> %b\n", rightTriangle(70, 130, 110));

    }
    // TASK №1
    public static int solutions(int a, int b, int c){ // количество решений квадратного уравнения ax^2+bx+c=0
        if (b*b-4*a*c>0){
            return 2;
        }else if (b*b-4*a*c==0){
            return 1;
        }else {
            return 0;
        }
    }
    // TASK №2
    public static int findZip(String s){ // найти индекс второго "zip" в строке s
        int check=0, tmp=0, res=0;
        /*int a = s.indexOf("zip");
        int b = s.indexOf("zip", a);
        return b;*/
        for(int i=0;i<s.length();i++){
            if(tmp == 0) { // До этого момента "zip" не было
                if (s.charAt(i) == 'z'){
                    check = 1;
                }else if(s.charAt(i) == 'i' && check == 1){
                    check = 2;
                }else if(s.charAt(i) == 'p' && check == 2){
                    tmp = 1;
                    check=0;
                }else{
                    check = 0;
                }
            }else{ // "zip" уже был один раз
                if (s.charAt(i) == 'z'){
                    check = 1;
                    res=i;
                }else if(s.charAt(i) == 'i' && check == 1){
                    check = 2;
                }else if(s.charAt(i) == 'p' && check == 2){
                    break;
                }else{
                    res = 0;
                    check = 0;
                }
            }
            //System.out.println(s.charAt(i) + " " + check + " " + tmp + " " + res);
        }
        if(res == 0 && check != 2) {
            return -1;
        }else{ return res; }
    }
    // TASK №3
    public static boolean checkPerfect(int s){ // сумма делителей числа является самим числом
        int cnt=1;
        for(int i=2; i<=s/2; i++){
            if(s%i==0){cnt += i;}
        }
        return cnt==s;
    }
    // TASK №4
    public static String flipEndChars(String s){ // поменять первый и последний символ строки (если не совпадают и длина больше 2)
        if(s.length() < 2){ // проверка длины
            return "Incompatible.";
        }
        else if(s.charAt(0) == s.charAt(s.length()-1)){ // проверка совпадения символлов
            return "Two's a pair.";
        }else{ // замена символов
            String new_s = "";
            char tmp = s.charAt(0);
            for(int i=0; i<s.length();i++){
                if(i == 0){
                    new_s += s.charAt(s.length()-1);
                }else if(i == s.length()-1){
                    new_s += tmp;
                }else{
                    new_s+=s.charAt(i);
                }
            }
            return new_s;
        }
    }
    // TASK №5
    public static boolean isValidHexCode(String s) { // начинается с '#', после 6 цифр
        if (s.charAt(0) != '#') {
            return false;
        } else if (s.length() != 7) {
            return false;
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    if (s.charAt(i) < 'a' || s.charAt(i) > 'f') {
                        if(s.charAt(i)<'A' || s.charAt(i) > 'F'){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
    // TASK №6
    public static boolean same(int[] a, int[] b){ // равны ли количества уникальных значений в массивах a и b
        Set<Integer> new_a = new HashSet<Integer>();
        Set<Integer> new_b = new HashSet<Integer>();
        for (int i : a) {
            new_a.add(i);
        }
        for (int i : b) {
            new_b.add(i);
        }
        return new_a.size()==new_b.size();
    }
    // TASK №7
    public static boolean isKaprekar(int s){ // разделить квадрат числа s на цифры пополам и проверить является ли сумма этих двух чисел самим числом s
        int a=s*s, cnt=0, sum1=0, sum2=0;
        while(a>0){
            cnt++;
            a/=10;
        }
        a=s*s;
        if(cnt%2==0) {
            for (int i = 0; i < cnt / 2; i++) {
                sum1 += a % 10*Math.pow(10,i);
                a /= 10;
            }
            for (int i = 0; i < cnt / 2; i++) {
                sum2 += a % 10*Math.pow(10,i);
                a /= 10;
            }
        }else{
            for (int i = 0; i <= cnt / 2; i++) {
                sum1 += a % 10*Math.pow(10,i);
                a /= 10;
            }
            for (int i = 0; i < cnt / 2; i++) {
                sum2 += a % 10*Math.pow(10,i);
                a /= 10;
            }
        }
        //System.out.println(sum1 + " " + sum2);
        return sum1+sum2==s;
    }
    // TASK №8
    public static String longestZero(String s){ // вывести наибольшую последовательность из '0'
        String new_s="", res="";
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                new_s+='0';
            }else{
                if(new_s.length()>res.length()){
                    res=new_s;
                }
                new_s="";
            }
        }
        if(new_s.length()>res.length()){
            res=new_s;
        }
        return res;
    }
    // TASK №9
    public static boolean isPrime(int s){ // поиск простого числа
        for (int i = 2; i<=s/2; i++){
            if(s%i==0){
                return false;
            }
        }
        return  true;
    }
    public static int nextPrime(int s){ // перебор чисел через +1, пока не найдётся простое
        int check = 0;
        while(check==0){
            if(isPrime(s)){
                check = 1;
            }else{
                s++;
            }
        }
        return s;
    }
    // TASK №10
    public static boolean rightTriangle(int a, int b, int c){ // Проверить является ли треугольник сос тронами a, b, c прямоугольным
        if(a>=b&&a>=c){ // поиск гипотенузы
            return a*a==b*b+c*c;
        }else if(b>=a&&b>=c){
            return b*b==a*a+c*c;
        }else{ return c*c==a*a+b*b; }
    }
}