import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Library {
   private String nameFile;//файл на диске
   private Map<String, String> states = new HashMap<String, String>();//будем хранить тут наш словарь

    public Library(String nameFile){
        this.nameFile=nameFile;
        ReadAllFromTxt();
    }

    public void ReadAllFromTxt() { //-	инициализировать мапу словарем
        String[] word;
        try( FileInputStream fstream = new FileInputStream(nameFile);){
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                if(!strLine.equals("")) {
                    word = strLine.split("-");
                    states.put(word[0], word[1]);
                }
            }

        }catch (Exception e){
            Console.OutError();
        }


    }
    public void PrintAll(){ //-	чтение списка пар из файла
        try{
            for(Map.Entry<String, String> pair : states.entrySet())
            {
                Console.OutConsole(pair.getKey(),pair.getValue());
            }
        }catch (Exception e){
            Console.OutError();
        }
    }

    public void ReadFromTxt(String key){//-	поиск записи по ключу
        try {
            for ( Map.Entry<String, String> entry : states.entrySet() ) {
                if (entry.getKey().equals(key)) {
                    Console.OutConsole(entry.getKey(),entry.getValue());
                }
            }
        }
        catch (Exception e){
            Console.OutError();
        }


    }

    public void DeleteFromTxt(String key){//-	удаление записи по ключу
            for (Iterator<Map.Entry<String, String>> it = states.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, String> entry = it.next();
                if (entry.getKey().equals(key)) {
                    it.remove();
                }
            }
            SaveToTxt();
           ReadAllFromTxt();
    }
    public void AddToTxt(String key,String value){//--	добавление записей при условии соответствия требованиям конкретного словаря
        states.put(key,value);
        SaveToTxt();
        ReadAllFromTxt();
    }

    public void SaveToTxt() {//сохранить мапу в документ
        try(PrintWriter pw = new PrintWriter(nameFile)) {
            for ( Map.Entry<String, String> entry : states.entrySet() ) {
                pw.println(entry.getKey() + "-" + entry.getValue());
                pw.append("\n");
            }
        } catch (Exception e) {
            Console.OutError();

        }





    }

}
