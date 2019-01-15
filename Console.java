public class Console {//сделан для облегчения жизни
    public static void OutConsole(String out2){
        System.out.println("Слово:");
    }
    public static void OutConsole(String out1,String out2){
        System.out.println("Ключ:"+out1+" "+"Слово:"+out2);
    }

    public static void OutError(){
        System.out.println("Ошибка");
        System.exit(0);
    }
}
