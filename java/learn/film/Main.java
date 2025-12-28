package hnp.project.demoactivemq.test.film;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int m = in.nextInt();
        in.nextLine();
        int i = 1;
        List<TypeFilm> typeFilms = new ArrayList<>();
        while (n-- > 0) {
            String code = genCode(i);
            String type = in.nextLine();
            TypeFilm typeFilm = new TypeFilm(code, genType(i)+type);
            typeFilms.add(typeFilm);
            i++;
        }
        List<Film> films = new ArrayList<>();
        while (m-- > 0) {
            String type = in.nextLine();
            String gen = typeFilm(typeFilms, type);
            Film film = new Film(gen, convertToDate(in.nextLine()), in.nextLine(), in.nextInt());
            in.nextLine();
            films.add(film);
            System.out.println("done 1");
        }
        films.sort(Comparator.comparing(Film::getFilmDateStart));
        for(Film e : films){
            System.out.println(e.display());
        }
    }

    private static Date convertToDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    private static String genCode(int i) {
        if (i < 10) return "TL00" + i;
        if (i < 100) return "TL0" + i;
        if (i < 1000) return "TL" + i;
        return "" + i;
    }

    private static String genType(int i) {
        if (i < 10) return "P00" + i;
        if (i < 100) return "P0" + i;
        if (i < 1000) return "P" + i;
        return "" + i;
    }

    private static String typeFilm(List<TypeFilm> typeFilms, String code){
        for(TypeFilm tf : typeFilms){
            if(tf.getCode().equals(code)){
                return tf.getType();
            }
        }
        return "";
    }
}
