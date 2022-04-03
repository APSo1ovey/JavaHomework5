package rzd.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LicensePlateOffice {
    ArrayList<LicensePlate> licencePlate;
    BufferedReader reader;
    String seria;



    public LicensePlateOffice(int count) throws IOException {
        licencePlate = new ArrayList<LicensePlate>();
        reader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;

        generateSeria();
        getRandomRegion();
        String owner;
        while (num < count){//выполняем создание count паспортов
            String number = getRandomNumber(3);
            String region = getRandomRegion();
            if(isDublicate(number,seria,region)){
                continue;
            }else{
                System.out.println("Введите владельца госномера");
                owner = reader.readLine();
                LicensePlate licensePlate = new LicensePlate(seria,number,region,owner);//создали паспорт
                licencePlate.add(licensePlate);
                num++;
            }
        }
        System.out.println("Были созданы госномера:");
        show();
    }

    boolean isDublicate(String seria,String number,String region){
        for (LicensePlate licensePlate : licencePlate){
            if(licensePlate.getNumber().equalsIgnoreCase(number)
                    && licensePlate.getSeria().equalsIgnoreCase(seria)
                    && licensePlate.getRegion().equalsIgnoreCase(region)){
                return true;
            }
        }
        return false;
    }

    void show(){
        for(LicensePlate licensePlate : licencePlate){
            System.out.println(licensePlate);
        }
    }

    void searchOwnerByLicencePlate() throws IOException {
        System.out.println("Введите госномер вида A111AA 199");
        String str = reader.readLine();
        String str1 = str.substring(0,1);
        str1 += str.substring(4,6);
        str1 += " ";
        str1 += str.substring(1,4);
        str1 += str.substring(6,9);

        try{str1 += str.substring(9,10);}//вылавливаем ошибку по выходу за пределы строки при регионе из 2х цифр
        catch (StringIndexOutOfBoundsException e){}
//        System.out.println(str1);

        String masStr[] = str1.split(" ");//преобразовали строку в массив строк по пробелу
        String s = masStr[0];//серия
        String n = masStr[1];//номер
        String r = masStr[2];//регион
        for (LicensePlate licensePlate : licencePlate){
            if(licensePlate.getSeria().equalsIgnoreCase(s)
                    && licensePlate.getNumber().equalsIgnoreCase(n)
                    && licensePlate.getRegion().equalsIgnoreCase(r)){
                System.out.println("Владелец госномера: " + licensePlate.getOwner());
                return;
            }
        }
        System.out.println("Госномер не найден!");
    }

        boolean isDigit(String s){
            char mas[] = s.toCharArray();
            for (char item : mas){
                if(Character.isDigit(item)){
                    return false;
                }
            }
            return true;
        }

        private void generateSeria() throws IOException {
            System.out.println("Для ручного ввода серии госномера введите команду 'h', для автоматического расчёта введите 'a'");
            String answer = reader.readLine();//получаем ответ из консоли
            if(answer.equalsIgnoreCase("h")){
                String seriaUser = "";
                do {
                    System.out.println("Введите серию госномера");
                    seriaUser = reader.readLine();
                }while (seriaUser.length() != 3 || !isDigit(seriaUser));
                seria = seriaUser;
            }else{//если серию заполняем автоматически
                seria = getRandomSeria(3);
            }
        }

        static String getRandomSeria(int count){
            String masSer[] = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "X", "Y"};
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i < count;i++){
                builder.append(masSer[(int) (Math.random() * masSer.length)]);
            }
            return builder.toString();
        }

    static String getRandomRegion(){
        Integer masReg[] = {77, 97, 99, 177, 197, 199, 777, 797, 799};//Коды Москвы и области
        StringBuilder builder = new StringBuilder();
        builder.append(masReg[(int) (Math.random() * masReg.length)]);
        return builder.toString();
    }

    static String getRandomNumber(int count){
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < count;i++){
            int x = (int) (Math.random() * 10);
            builder.append(Integer.toString(x));
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        LicensePlateOffice office = new LicensePlateOffice(5);
        office.searchOwnerByLicencePlate();
    }
    }

