package doctor.clinic.entity;

public class Reason {
    private String name;
    private int time;
    private int money;

    public Reason(String name, int time, int money) {
        this.name = name;
        this.time = time;
        this.money = money;
    }

    public Reason() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Reason{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", money=" + money +
                '}';
    }
}
