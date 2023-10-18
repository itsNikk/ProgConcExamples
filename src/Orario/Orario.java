package Orario;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ScheduledFuture;

public class Orario {

    private enum Suffixes {
        AM,
        FM
    }

    private int ore;
    private int minuti;

    private static char sep = ':';
    private static boolean format24 = true;

    public Orario() {
        GregorianCalendar now = new GregorianCalendar();
        ore = now.get(Calendar.HOUR_OF_DAY);
        minuti = now.get(Calendar.MINUTE);
    }

    public Orario(String s) {
        if (s.length() >= 8) throw new OrarioException("OrarioException: Stringa troppo lunga.");
        if (s.length() >= 6) setFormat24(false);
        ore = Integer.parseInt(s.substring(0, 2));
        minuti = Integer.parseInt(s.substring(3, 5));
    }

    public Orario(int hh, int mm) {
        if (hh < 0 || mm < 0) throw new OrarioException("OrarioException: DATI NON VALIDI");
        ore = hh;
        minuti = mm;
    }

    public static Orario parseOrario(String s) {
        if (isFormat24Active()) {
            //21:32
            int ore = Integer.parseInt(s.substring(0, 2));
            int minuti = Integer.parseInt(s.substring(3, 5));
            char sep = s.charAt(2);
            setSeparatore(sep);
            return new Orario(ore, minuti);
        } else {
            return new Orario();
        }
    }

    public boolean equals(Orario other) {
        return this.ore == other.ore && this.minuti == other.minuti;
    }

    public boolean isMinore(Orario other) {
        return ore < other.ore || (ore == other.ore && minuti < other.minuti);
    }

    public boolean isMaggiore(Orario other) {
        return ore > other.ore || (ore == other.ore && minuti < other.minuti);
    }

    public int quantoManca(Orario other) {
        return (other.ore - ore) * 60 + other.minuti - minuti;
    }

    public static boolean isFormat24Active() {
        return format24;
    }

    public static void setFormat24(boolean b) {
        format24 = b;
    }

    public static void setSeparatore(char newSep) {
        sep = newSep;
    }


    public static char getSep() {
        return sep;
    }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    @Override
    public String toString() {
        //String min = minuti < 10 ? "0" + minuti : "" + minuti;
        String res;
        String stringaMin = (minuti < 10 ? "0" : "") + minuti;
        if (format24) res = String.valueOf(ore) + sep + stringaMin;
        else {
            String suffisso;
            int oraRisultato;
            if (ore == 0) {
                oraRisultato = 12;
                suffisso = Suffixes.FM.toString().toLowerCase();
            } else if (ore > 0 && ore < 12) {
                oraRisultato = ore;
                suffisso = Suffixes.AM.toString().toLowerCase();
            } else if (ore == 12) {
                oraRisultato = 12;
                suffisso = Suffixes.FM.toString().toLowerCase();
            } else {
                oraRisultato = ore - 12;
                suffisso = Suffixes.FM.toString().toLowerCase();
            }
            res = String.valueOf(oraRisultato) + sep + stringaMin + suffisso;
        }
        return res;

    }
}
