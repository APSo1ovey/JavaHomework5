package rzd.company;

/*
Создайте офис по созданию номеров автомобилей.
У номера авто есть свойства – номер, серия, регион и владелец.
Серию номер можно представить в виде трех букв(например, А111АА199,
в этом примере, серия это ААА, номер это 111, регион 199).
Заполнить коллекцию объектов и сделать поиск владельца авто по номеру авто.
Серию номера вводит юзер либо вручную либо генерирует автоматически.
 */
public class LicensePlate {
    private String seria;
    private String number;
    private String region;
    private String owner;

    public LicensePlate(String seria, String number, String region, String owner) {
        this.seria = seria;
        this.number = number;
        this.region = region;
        this.owner = owner;
    }

    public String getSeria() {
        return seria;
    }

    public String getNumber() {
        return number;
    }

    public String getRegion() {
        return region;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return  "Госномер: " + seria.substring(0,1) + number + seria.substring(1,3)+ " " + region +
                "; Владелец: " + owner;
    }
}
