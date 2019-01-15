import java.io.*;

public class ServiceWorker {

    private char[] Latinsk = {'A', 'B', 'C', 'D', 'E', 'F', 'Z', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X'};
    private char[] Number = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private void Del(Library library) throws IOException{//метод для работы с методом удаление клаасс аLibrary
        System.out.println("введите ключ:");
        String key =Input();
        library.DeleteFromTxt(key);
    }

    private void Seacrh(Library library) throws IOException {//метод для работы с методом поиска по ключу клаасса Library
        System.out.println("введите ключ:");
        String key =Input();
        library.ReadFromTxt(key);
    }

    private void Add(Library library,int type)throws IOException {//метод для работы с методом добавление клаасса Library
        System.out.println("введите ключ:");
        String key =Input();
        System.out.println("введите слово:");
        String word =Input();
        if(Validation(type,key))
        library.AddToTxt(key,word);
        else System.out.println("несоответсвие правилам словаря ");
    }

    private void PrintAll(Library library){//метод для работы с методом печать всего словаря клаасса Library
        library.PrintAll();
    }

    private boolean SearchfromAlpha(String word,int num){//перебор по словарю нужного языка
        boolean flag=false;
        word=word.toUpperCase();
        if(num==1) {
            for (int i = 0; i < word.length(); i++) {
                flag = false;
                for (int j = 0; j < Latinsk.length; j++) {
                    if (word.charAt(i) == Latinsk[j]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    return false;
            }
            return true;
        }
       else if(num==2) {
            for (int i = 0; i < word.length(); i++) {
                flag = false;
                for (int j = 0; j < Number.length; j++) {
                    if (word.charAt(i) == Number[j]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    return false;
            }
            return true;
        }
        return false;
    }

    private Boolean Validation(int num,String key) {//проверка
        if(num==1){
          if(key.length()==4&SearchfromAlpha(key,1))//проверяем длину и принадлежность алфавиту
              return true;
          else return false;
        }
        else if(num==2){
            if(key.length()==5&SearchfromAlpha(key,2))
                return true;
            else return false;
        }
        return false;
    }


    public void Slovar(int num) throws IOException {
        boolean flag = true;
        if(num==1) System.out.println("Вы выбрали латинско-русский,введите местоположение файла на диске...");
        else if(num==2) System.out.println("Вы выбрали десятично-доичный,введите местоположение файла на диске...");
        String path = Input();
        Library library = new Library(path);
        while (true) {
            String Change;
            System.out.println("Выберите операцию:");
            System.out.println("удаление-1");
            System.out.println("поиск по ключу-2");
            System.out.println("добавление записи-3");
            System.out.println("вывод словаря-4");
            Change = Input();
            switch (Change) {
                case "1":Del(library);
                    break;
                case "2":Seacrh(library);
                    break;
                case "3":Add(library,num);
                    break;
                case "4":PrintAll(library);
                    break;
                default:System.out.println("неправильный ввод");
                    break;
            }
            System.out.println("Хотите продолжить?Введите:y");
            Change = Input();
            if (!Change.equals("y"))
                break;
        }

    }
    private String Input() throws IOException{//сделал чтобы не писать много кода
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return  bufferedReader.readLine();
    }


}

