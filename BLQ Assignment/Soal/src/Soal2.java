import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Soal2 {

    public static void main(String[] args) {
        // Buat scanner untuk input
        Scanner scanner = new Scanner(System.in);


        System.out.print("Waktu masuk (dd-MM-yyyy HH:mm:ss): ");
        String waktuMasukString = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime waktuMasuk = LocalDateTime.parse(waktuMasukString, dateTimeFormatter);


        System.out.print("Waktu keluar (dd-MM-yyyy HH:mm:ss): ");
        String waktuKeluarString = scanner.nextLine();
        LocalDateTime waktuKeluar = LocalDateTime.parse(waktuKeluarString, dateTimeFormatter);

        System.out.println();


        Duration durasiParkir = Duration.between(waktuMasuk, waktuKeluar);
        System.out.println(durasiParkir);


        long biayaParkir = 0;

        if (durasiParkir.toHours() <= 8) {
            biayaParkir = durasiParkir.toHours() * 1000;
        } else if (durasiParkir.toHours() <= 24) {
            biayaParkir = 8000;
        } else {
            biayaParkir = 15000 + (durasiParkir.toHours() - 24) * 1000;
        }

        // Tampilkan biaya parkir
        System.out.println("Biaya parkir: Rp" + biayaParkir);
    }
}