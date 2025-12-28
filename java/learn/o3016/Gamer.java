package hnp.project.demoactivemq.test.o3016;

public class Gamer implements Comparable<Gamer> {
    private String code;
    private String name;
    private int totalMinutes;

    public Gamer(String code, String name, String inTime, String outTime) {
        this.code = code;
        this.name = name;
        this.totalMinutes = calculateTotalMinutes(inTime, outTime);
    }

    private int calculateTotalMinutes(String inTime, String outTime) {
        int inHour = Integer.parseInt(inTime.split(":")[0]);
        int inMinute = Integer.parseInt(inTime.split(":")[1]);
        int outHour = Integer.parseInt(outTime.split(":")[0]);
        int outMinute = Integer.parseInt(outTime.split(":")[1]);

        int totalInMinutes = inHour * 60 + inMinute;
        int totalOutMinutes = outHour * 60 + outMinute;

        return totalOutMinutes - totalInMinutes;
    }

    public String formatTimePlayed() {
        int hours = this.totalMinutes / 60;
        int minutes = this.totalMinutes % 60;
        return hours + " gio " + minutes + " phut";
    }

    @Override
    public String toString() {
        return code + " " + name + " " + formatTimePlayed();
    }

    @Override
    public int compareTo(Gamer other) {
        return Integer.compare(other.totalMinutes, this.totalMinutes);
    }
}
