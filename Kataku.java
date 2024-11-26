//Kataku
//TUGAS AKHIR PEMDAS SEMESTER 1 
//RAKAPAKSI SATRYA PUTRA
//245150701111034

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Kataku {
    public static void main(String[] args) {
        List <String> katakata = List.of("JAWA", "KODE", "KUNCI", "TEBAK", "BATAS", "FIKSI", "HURUF", "PANCA", "BERAT", "TARIK", "SAYA");
        int streaks =  0;// Buat nyimpan streak pemain

        int percobaanmax = 6;
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;

        while (lanjut) {
            String kata = katarandom(katakata, 4, 5);//nentuin jawaban

            System.out.println("Halo halo, Selamat datang di Kataku!");
            System.out.println("Coba tebak kata dalam " + percobaanmax + " kali percobaan.");
            boolean menang = false;

            for (int nyoba = 1; nyoba <= percobaanmax; nyoba++) {
                System.out.print("Percobaan ke-" + nyoba + ": ");
                String tebakan = input.nextLine().toUpperCase();

                if (tebakan.length() != kata.length()) {
                    System.out.println("Jawabannya tuh harus " + kata.length() + " huruf.");
                    nyoba--;
                    continue;
                }

                char[] hasil = new char[kata.length()];
                for (int i = 0; i < kata.length(); i++) {
                    if (tebakan.charAt(i) == kata.charAt(i)) {
                        hasil[i] = tebakan.charAt(i);
                    } else if (kata.indexOf(tebakan.charAt(i)) != -1) {
                        hasil[i] = '*';// kalau huruf cuma salah tempat maka output *
                    } else {
                        hasil[i] = '-';// kalau huruf tidak ada dijawaban maka output -
                    }
                }

                System.out.println("Hasil: " + String.valueOf(hasil));

                if (tebakan.equals(kata)) {
                    System.out.println("Cihuyyy, Kamu Berhasil Nebak Jawabannya");
                    menang = true;
                    streaks++;
                    if (streaks == 1) {
                        System.out.println("Asek! Ini merupakan kemenangan pertama kamu!");
                        break;
                    } else if (streaks > 1) {
                        System.out.println("Keren Banget bang, Kamu Menang " + streaks + " kali berturut-turut");
                        break;
                    }
                }
            }

            if (!menang) {
                System.out.println("Yah Kesempatanmu udah habis. Jawabannya tuh " + kata);
                System.out.println("Karena skill issue streakmu jadi 0 lagi deh");
                streaks = 0;
            }

            System.out.print("Mau main lagi? (y/n): ");
            String njawab = input.nextLine().toLowerCase();
            lanjut = njawab.equals("y");
        }

        input.close();
    }

    public static String katarandom(List<String> words, int panjangmin, int panjangmax) {
        List<String> katafilter = new ArrayList<>();
    
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() >= panjangmin && word.length() <= panjangmax) {
                katafilter.add(word);//buat filter kata biar nda kurang dr 4 atau lbih dri 5
            }
        }
    
        if (!katafilter.isEmpty()) {
            Random random = new Random();
            return katafilter.get(random.nextInt(katafilter.size()));//milih jawaban
        }
    
        return null;
    }
}
