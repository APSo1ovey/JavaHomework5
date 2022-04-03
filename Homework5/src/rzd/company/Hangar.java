package rzd.company;
/*
Реализовать эмулятор стоянки самолётов-стэк.
Создайте класс Plane с полями класса – название  самолета и номер самолета.
В отдельном классе создайте  стоянку для самолетов (коллекция).
Размер стоянки ­ 5- мест. Работать должно быть следующим образом:
вводим в консоль бортовые номера самолётов, и программа их запоминает (“ставит” их на стоянку).
Если команду ADD введем, то пределагаю ввести название и номер самолета.
Эти данные записываем в объект и объект добавляем в коллекцию объектов.
При вводе команды “exitAll” программа должна распечатать номера самолётов в порядке покидания стоянки
(и удалить их все из памяти). При вводе “exitLast” ­ должна распечатать и удалить из памяти только тот самолёт,
который сейчас выезжает. Если стоянка заполнена полностью, следующему самолёту должно быть отказано во въезде.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Hangar {
    public static void main(String[] args) throws IOException {

        Stack<Plane> planes = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (; ; ) {
            System.out.println("Доступны команды: \n\tДобавление нового самолёта - add " +
                    "\n\tПоказать самолёты в ангаре - list " +
                    "\n\tУдаление последнего самолёта из ангара - exitLast " +
                    "\n\tУдаление всех самолётов из ангара - exitAll " +
                    "\n\tВыход из программы - exit");
            String userAnswer = reader.readLine();
            switch (userAnswer) {
                case "add":
                    if (planes.size() >= 5){
                        System.out.println("Ангар переполнен!");
                        break;
                    }
                    System.out.println("Введите бортовой номер самолёта: ");
                    Integer planeNumber = Integer.valueOf(reader.readLine());
                    System.out.println("Введите название самолёта: ");
                    String planeName = reader.readLine();
                    planes.push(new Plane(planeName,planeNumber));
                    break;
                case "exitLast":
                    System.out.println("Самолёт " + planes.pop() + " покинул ангар");
                    break;
                case "list":
                    System.out.println(planes);
                    break;
                case "exitAll":
                    while (planes.size() > 0){
                        System.out.println("Самолёт " + planes.pop() + " покинул ангар");
                    }
                    break;
                case "exit":
                    return;
                default:
            }
        }
    }
}

