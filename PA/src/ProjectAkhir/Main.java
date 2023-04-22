package ProjectAkhir;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<User> dataUser = new ArrayList<>() {
        {
            add(new User("dinda", "061", "Jl. Jalan", "dinda@gmail.com", 1));
            add(new User("mahsa", "065", "Jl. Jalan", "mahsa@gmail.com", 1));
            add(new User("ikhwan", "066", "Jl. Jalan", "ikhwan@gmail.com", 1));
            add(new User("muchlis", "069", "Jl. Jalan", "muchlis@gmail.com", 1));
        }
    };

    static ArrayList<ObatCair> cair = new ArrayList<>() {
        {
            add(new ObatCair("0", "Paracetamol Cair", "10-15 mg/kgBB/setiap 4-6 jam", "500-1000 mg/setiap 4-6 jam", 30000, 10));
            add(new ObatCair("1", "Ibuprofen Cair", "5-10 mg/kgBB/setiap 6-8 jam", "200-400 mg/setiap 4-6 jam", 60000, 10));
            add(new ObatCair("2", "Cetirizine Cair", "2,5-5 mg/setiap 12 jam", "5-10 mg/setiap 12-24 jam", 20000, 10));
        }
    };
    
    static ArrayList<ObatKapsul> kapsul = new ArrayList<>() {
        {
            add(new ObatKapsul("0", "Amoxicillin", "20-50 mg/kgBB/hari", "250-500 mg setiap 8 jam atau 500-875 mg setiap 12 jam", 250000, 10));
            add(new ObatKapsul("1", "Cephalexin", "25-50 mg/kgBB/hari", "250-500 mg setiap 6 jam atau 1-4 gram setiap 12 jam", 18000, 10));
            add(new ObatKapsul("2", "Omeprazole", "0,7-3 mg/kgBB/hari", "20-40 mg setiap hari", 6000, 10));
        }
    };

    static ArrayList<ObatPil> pil = new ArrayList<>() {
        {
            add(new ObatPil("0", "Tramadol", "Tidak disarankan untuk anak-anak di bawah usia 12 tahun", " 50-100 mg setiap 4-6 jam", 50000, 10));
            add(new ObatPil("1", "Naproxen", "Tidak disarankan untuk anak-anak di bawah usia 12 tahun", "250-500 mg setiap 12 jam", 17500, 10));
            add(new ObatPil("2", "Furosemide", "1-2 mg/kg berat badan per hari", " 20-80 mg per hari", 430000, 10));
        }
    };

    public static void main(String[] args) throws IOException {

        String pilih = "a";
        while (!"E".equals(pilih)) {
            System.out.println("""
                               O========================================O
                               |     Aplikasi Apotek Chemical Farma     |
                               O========================================O
                               | 1. Registration                        |
                               | 2. Login                               |
                               | E. Exit                                |
                               O========================================O""");
            System.out.print("  Input choice : ");
            pilih = input.readLine();
            if (null == pilih) {
                System.out.println("O========================================O");
                System.out.println("|             Invalid choice             |");
                System.out.println("O========================================O");
                System.out.print("Press [enter] to continue...");
                new java.util.Scanner(System.in).nextLine();
            } else {
                switch (pilih) {

                    case "1" ->
                        regis();

                    case "2" -> {
                        if (login() == true) {
                            System.out.println("");
                        } else {
                            System.out.println("  Account not found!!! ");
                        }
                        break;
                    }

                    case "E" -> {
                        System.out.println("O========================================O");
                        System.out.println("|         Thank you for visiting         |");
                        System.out.println("O========================================O");
                        System.out.print("Press [enter] to continue...");
                        new java.util.Scanner(System.in).nextLine();
                    }

                    default -> {
                        System.out.println("O========================================O");
                        System.out.println("|             Invalid choice             |");
                        System.out.println("O========================================O");
                        System.out.print("Press [enter] to continue...");
                        new java.util.Scanner(System.in).nextLine();
                    }
                }
            }
        }
    }

    public static int kodeObatCair() {
        int x = 0;
        if (cair.size() < 1) {
            x = 0;
        } else {
            for (int i = 0; i < cair.size(); i++) {
                x++;
            }
        }
        return x;
    }

    public static int kodeObatKapsul() {
        int x = 0;
        if (kapsul.size() < 1) {
            x = 0;
        } else {
            for (int i = 0; i < kapsul.size(); i++) {
                x++;
            }
        }
        return x;
    }

    public static int kodeObatPil() {
        int x = 0;
        if (pil.size() < 1) {
            x = 0;
        } else {
            for (int i = 0; i < pil.size(); i++) {
                x++;
            }
        }
        return x;
    }

    public static boolean login() throws IOException {
        String user, pass;
        System.out.println("""
                                O========================================O
                                |     Aplikasi Apotek Chemical Farma     |
                                |                 Login!                 |
                                O========================================O""");
        System.out.print("  Username : ");
        user = input.readLine();
        System.out.print("  Password : ");
        pass = input.readLine();
        if (user.equals("admin") && pass.equals("admin")) {
            menuAdmin();
        }
        for (User cekUser : dataUser) {
            if (cekUser.getUsername().equals(user) && cekUser.getPassword().equals(pass)) {
                if (dataUser.get(0).getUsername().equals(user) && dataUser.get(0).getPassword().equals(pass)) {
                    menuUser();
                } else {
                    System.out.println("Welcome " + user);
                    menuUser();
                    return true;
                }
            }
        }
        return false;
    }

    public static void regis() throws IOException {
        String user, pass, alamat, email;
        int age;

        System.out.println("""
                               O========================================O
                               |              Registration              |
                               O========================================O""");
        System.out.print("  Username : ");
        user = input.readLine();
        System.out.print("  Password : ");
        pass = input.readLine();
        System.out.print("  Address  : ");
        alamat = input.readLine();
        System.out.print("  Email    : ");
        email = input.readLine();
        System.out.print("  Age      : ");
        age = Integer.parseInt(input.readLine());
        System.out.println("  Successful Registration!!! ");
        User addUser = new User(user, pass, alamat, email, age);
        dataUser.add(addUser);
    }

    public static void menuAdmin() throws IOException {
        String pilih = "a";
        while (!"E".equals(pilih)) {
            System.out.println("""
                               O========================================O
                               |     Aplikasi Apotek Chemical Farma     |
                               O========================================O
                               | 1. Create Data                         |
                               | 2. Read Data                           |
                               | 3. Update Data                         |
                               | 4. Delete Data                         |
                               | E. Exit                                |
                               O========================================O""");
            System.out.print("  Input choice : ");
            pilih = input.readLine();
            if (null == pilih) {
                System.out.println("O========================================O");
                System.out.println("|             Invalid choice             |");
                System.out.println("O========================================O");
                System.out.print("Press [enter] to continue...");
                new java.util.Scanner(System.in).nextLine();
            } else {
                switch (pilih) {

                    case "1" ->
                        createDataObat();

                    case "2" ->
                        readData();

                    case "3" ->
                        updateData();

                    case "4" ->
                        deleteData();

                    case "E" -> {
                        System.out.println("O========================================O");
                        System.out.println("|         Thank you for visiting         |");
                        System.out.println("O========================================O");
                        System.out.print("Press [enter] to continue...");
                        new java.util.Scanner(System.in).nextLine();
                    }

                    default -> {
                        System.out.println("O========================================O");
                        System.out.println("|             Invalid choice             |");
                        System.out.println("O========================================O");
                        System.out.print("Press [enter] to continue...");
                        new java.util.Scanner(System.in).nextLine();
                    }
                }
            }
        }
    }

    public static void createDataObat() throws IOException {
        String pilihtipe = "a", nama, kode, dosisAnak, dosisDewasa;
        int stok, harga;

        while (!"E".equals(pilihtipe)) {
            System.out.println("""
                                O===============================O
                                |         Tambah Obat           |
                                O===============================O
                                | 1. Obat Cair                  |
                                | 2. Obat Kapsul                |
                                | 3. Obat Pil                   |
                                | E. Exit                       |
                                O===============================O""");
            System.out.print("  Input choice : ");
            pilihtipe = input.readLine();
            if (null == pilihtipe) {
                System.out.println(" Wrong Input! ");

            } else {
                switch (pilihtipe) {
                    case "1", "Obat Cair" -> {
                        System.out.println("""
                               O================================O
                               |          Tambah Obat           |
                               O================================O""");
                        int kodeCair = kodeObatCair();
                        kode = "" + kodeCair;

                        System.out.print("  Nama Obat          : ");
                        nama = input.readLine();
                        System.out.print("  Dosis Anak         : ");
                        dosisAnak = input.readLine();
                        System.out.print("  Dosis Dewasa       : ");
                        dosisDewasa = input.readLine();
                        System.out.print("  Harga Obat         : Rp.");
                        harga = Integer.parseInt(input.readLine());
                        System.out.print("  Stok Obat          : ");
                        stok = Integer.parseInt(input.readLine());

                        ObatCair addCair = new ObatCair(kode, nama, dosisAnak, dosisDewasa, harga, stok);
                        cair.add(addCair);
                        break;
                    }

                    case "2", "Obat Kapsul" -> {
                        System.out.println("""
                               O================================O
                               |          Tambah Obat           |
                               O================================O""");
                        int kodeKapsul = kodeObatKapsul();
                        kode = "" + kodeKapsul;

                        System.out.print("  Nama Obat          : ");
                        nama = input.readLine();
                        System.out.print("  Dosis Anak         : ");
                        dosisAnak = input.readLine();
                        System.out.print("  Dosis Dewasa       : ");
                        dosisDewasa = input.readLine();
                        System.out.print("  Harga Obat         : Rp.");
                        harga = Integer.parseInt(input.readLine());
                        System.out.print("  Stok Obat          : ");
                        stok = Integer.parseInt(input.readLine());

                        ObatKapsul addKapsul = new ObatKapsul(kode, nama, dosisAnak, dosisDewasa, harga, stok);
                        kapsul.add(addKapsul);
                        break;
                    }

                    case "3", "Obat Pil" -> {
                        System.out.println("""
                               O================================O
                               |          Tambah Obat           |
                               O================================O""");
                        int kodePil = kodeObatPil();
                        kode = "" + kodePil;

                        System.out.print("  Nama Obat          : ");
                        nama = input.readLine();
                        System.out.print("  Dosis Anak         : ");
                        dosisAnak = input.readLine();
                        System.out.print("  Dosis Dewasa       : ");
                        dosisDewasa = input.readLine();
                        System.out.print("  Harga Obat         : Rp.");
                        harga = Integer.parseInt(input.readLine());
                        System.out.print("  Stok Obat          : ");
                        stok = Integer.parseInt(input.readLine());

                        ObatPil addPil = new ObatPil(kode, nama, dosisAnak, dosisDewasa, harga, stok);
                        pil.add(addPil);
                        break;
                    }

                    case "E" -> {
                        System.out.println("");
                        break;
                    }

                    default -> {
                        System.out.println("  Wrong Type, Input Again!!!");
                        break;
                    }
                }
            }
        }
    }

    public static void readData() throws IOException {
        String pilihtipe = "a";

        while (!"E".equals(pilihtipe)) {
            System.out.println("""
                                O===============================O
                                |          Lihat Data           |
                                O===============================O
                                | 1. Lihat Data User            |
                                | 2. Lihat Data Obat            |
                                | E. Exit                       |
                                O===============================O""");
            System.out.print("  Input choice : ");
            pilihtipe = input.readLine();
            if (null == pilihtipe) {
                System.out.println(" Wrong Input! ");

            } else {
                switch (pilihtipe) {
                    case "1", "Lihat Data Obat" ->
                        readDataUser();

                    case "2", "Obat Kapsul" ->
                        readDataObat();

                    case "E" -> {
                        System.out.println("");
                        break;
                    }

                    default -> {
                        System.out.println("  Wrong Type, Input Again!!!");
                        break;
                    }
                }
            }
        }
    }

    public static void readDataUser() {
        if (cair.size() < 1) {
            System.out.println("""
                            O===============================O
                            |      Data Tidak Ditemukan     |
                            O===============================O""");
            System.out.print("Press [enter] to continue...");
            new java.util.Scanner(System.in).nextLine();
        } else {
            System.out.println("""
                            O==============================O
                            |             User             |
                            O==============================O""");
            for (int i = 1; i < dataUser.size(); i++) {
                System.out.println("  Username           : " + dataUser.get(i).getUsername());
                System.out.println("  Password           : " + dataUser.get(i).getPassword());
                System.out.println("  Address            : " + dataUser.get(i).getAddress());
                System.out.println("  Email              : " + dataUser.get(i).getEmail());
                System.out.println("--------------------------------");
            }
            System.out.println("O==============================O");
            System.out.print("Press [enter] to continue...");
            new java.util.Scanner(System.in).nextLine();
        }
    }

    public static void readDataObat() throws IOException {

        String pilihtipe = "a";
        while (!"E".equals(pilihtipe)) {
            System.out.println("""
                                O===============================O
                                |           Lihat Obat          |
                                O===============================O
                                | 1. Obat Cair                  |
                                | 2. Obat Kapsul                |
                                | 3. Obat Pil                   |
                                | E. Exit                       |
                                O===============================O""");
            System.out.print("  Input choice : ");
            pilihtipe = input.readLine();
            if (null == pilihtipe) {
                System.out.println(" Wrong Input! ");
            } else {
                switch (pilihtipe) {
                    case "1", "Obat Cair" -> {
                        if (cair.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                            System.out.print("Press [enter] to continue...");
                            new java.util.Scanner(System.in).nextLine();
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |            Obat Cair          |
                                            O===============================O""");
                            for (int i = 0; i < cair.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + cair.get(i).getKode());
                                System.out.println("    Nama Obat     : " + cair.get(i).getNamaObat());
                                System.out.println("    Dosis Anak    : " + cair.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa  : " + cair.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat    : Rp." + cair.get(i).getHargaObat());
                                System.out.println("    Stok Obat     : " + cair.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }

                            System.out.println("=================================");
                            System.out.print("Press [enter] to continue...");
                            new java.util.Scanner(System.in).nextLine();
                        }
                    }
                    case "2", "Obat Kapsul" -> {
                        if (cair.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                            System.out.print("Press [enter] to continue...");
                            new java.util.Scanner(System.in).nextLine();
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |           Obat Kapsul         |
                                            O===============================O""");
                            for (int i = 0; i < kapsul.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + kapsul.get(i).getKode());
                                System.out.println("    Nama Obat     : " + kapsul.get(i).getNamaObat());
                                System.out.println("    Dosis Anak    : " + kapsul.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa  : " + kapsul.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat    : Rp." + kapsul.get(i).getHargaObat());
                                System.out.println("    Stok Obat     : " + kapsul.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print("Press [enter] to continue...");
                            new java.util.Scanner(System.in).nextLine();
                        }
                    }
                    case "3", "Obat Pil" -> {
                        if (cair.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                            System.out.print("Press [enter] to continue...");
                            new java.util.Scanner(System.in).nextLine();
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |            Obat Pil           |
                                            O===============================O""");
                            for (int i = 0; i < pil.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + pil.get(i).getKode());
                                System.out.println("    Nama Obat     : " + pil.get(i).getNamaObat());
                                System.out.println("    Dosis Anak    : " + pil.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa  : " + pil.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat    : Rp." + pil.get(i).getHargaObat());
                                System.out.println("    Stok Obat     : " + pil.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print("Press [enter] to continue...");
                            new java.util.Scanner(System.in).nextLine();
                        }
                    }
                    case "E" ->
                        System.out.println("");
                    default ->
                        System.out.println(" Wrong Input! ");
                }
            }
        }
    }

    public static void updateData() throws IOException {
        String pilihtipe = "a", nama, kode, dosisAnak, dosisDewasa;
        int stok, harga;

        while (!"E".equals(pilihtipe)) {
            System.out.println("""
                                O==============================O
                                |          Ubah Obat           |
                                O==============================O
                                | 1. Obat Cair                 |
                                | 2. Obat Kapsul               |
                                | 3. Obat Pil               |
                                | E. Exit                      |
                                O==============================O""");
            System.out.print("  Input choice : ");
            pilihtipe = input.readLine();
            if (null == pilihtipe) {
                System.out.println(" Wrong Input! ");
            } else {
                switch (pilihtipe) {
                    case "1", "Digital" -> {
                        if (cair.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |            Obat Cair          |
                                            O===============================O""");
                            for (int i = 0; i < cair.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + cair.get(i).getKode());
                                System.out.println("    Nama Obat          : " + cair.get(i).getNamaObat());
                                System.out.println("    Dosis Anak         : " + cair.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa       : " + cair.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat         : Rp." + cair.get(i).getHargaObat());
                                System.out.println("    Stok Obat          : " + cair.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print(" Input Code : ");
                            String no = input.readLine();
                            for (ObatCair obatCair : cair) {
                                if (obatCair.getKode().equals(no)) {
                                    int kodeCair = kodeObatCair();
                                    kode = "C" + kodeCair;
                                    obatCair.setKode(kode);

                                    System.out.print("  Nama Obat          : ");
                                    obatCair.setNamaObat(input.readLine());
                                    System.out.print("  Dosis Anak         : ");
                                    obatCair.setDosisObatAnak(input.readLine());
                                    System.out.print("  Dosis Dewasa       : ");
                                    obatCair.setDosisObatDewasa(input.readLine());
                                    System.out.print("  Harga Obat         : Rp.");
                                    obatCair.setHargaObat(Integer.parseInt(input.readLine()));
                                    System.out.print("  Stok Obat          : ");
                                    obatCair.setStokObat(Integer.parseInt(input.readLine()));

                                    System.out.println("""
                                   O===============================O
                                   |     Data Berhasil Diubah      |
                                   O===============================O""");
                                    System.out.print("Press [enter] to continue...");
                                    new java.util.Scanner(System.in).nextLine();
                                    pilihtipe = "E";
                                }
                            }
                        }
                        break;
                    }

                    case "2", "Obat Kapsul" -> {
                        if (kapsul.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |           Obat Kapsul         |
                                            O===============================O""");
                            for (int i = 0; i < kapsul.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + kapsul.get(i).getKode());
                                System.out.println("    Nama Obat          : " + kapsul.get(i).getNamaObat());
                                System.out.println("    Dosis Anak         : " + kapsul.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa       : " + kapsul.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat         : Rp." + kapsul.get(i).getHargaObat());
                                System.out.println("    Stok Obat          : " + kapsul.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print(" Input Code : ");
                            String no = input.readLine();
                            for (ObatKapsul obatKapsul : kapsul) {
                                if (obatKapsul.getKode().equals(no)) {
                                    int kodeKapsul = kodeObatKapsul();
                                    kode = "K" + kodeKapsul;
                                    obatKapsul.setKode(kode);

                                    System.out.print("  Nama Obat          : ");
                                    obatKapsul.setNamaObat(input.readLine());
                                    System.out.print("  Dosis Anak         : ");
                                    obatKapsul.setDosisObatAnak(input.readLine());
                                    System.out.print("  Dosis Dewasa       : ");
                                    obatKapsul.setDosisObatDewasa(input.readLine());
                                    System.out.print("  Harga Obat         : Rp.");
                                    obatKapsul.setHargaObat(Integer.parseInt(input.readLine()));
                                    System.out.print("  Stok Obat          : ");
                                    obatKapsul.setStokObat(Integer.parseInt(input.readLine()));

                                    System.out.println("""
                                   O===============================O
                                   |     Data Berhasil Diubah      |
                                   O===============================O""");
                                    System.out.print("Press [enter] to continue...");
                                    new java.util.Scanner(System.in).nextLine();
                                    pilihtipe = "E";
                                }
                            }
                        }
                        break;
                    }

                    case "3", "Obat Pil" -> {
                        if (pil.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |            Obat Pil           |
                                            O===============================O""");
                            for (int i = 0; i < pil.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + pil.get(i).getKode());
                                System.out.println("    Nama Obat          : " + pil.get(i).getNamaObat());
                                System.out.println("    Dosis Anak         : " + pil.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa       : " + pil.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat         : Rp." + pil.get(i).getHargaObat());
                                System.out.println("    Stok Obat          : " + pil.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print(" Input Code : ");
                            String no = input.readLine();
                            for (ObatPil obatPil : pil) {
                                if (obatPil.getKode().equals(no)) {
                                    int kodePil = kodeObatPil();
                                    kode = "P" + kodePil;
                                    obatPil.setKode(kode);

                                    System.out.print("  Nama Obat          : ");
                                    obatPil.setNamaObat(input.readLine());
                                    System.out.print("  Dosis Anak         : ");
                                    obatPil.setDosisObatAnak(input.readLine());
                                    System.out.print("  Dosis Dewasa       : ");
                                    obatPil.setDosisObatDewasa(input.readLine());
                                    System.out.print("  Harga Obat         : Rp.");
                                    obatPil.setHargaObat(Integer.parseInt(input.readLine()));
                                    System.out.print("  Stok Obat          : ");
                                    obatPil.setStokObat(Integer.parseInt(input.readLine()));

                                    System.out.println("""
                                   O===============================O
                                   |     Data Berhasil Diubah      |
                                   O===============================O""");
                                    System.out.print("Press [enter] to continue...");
                                    new java.util.Scanner(System.in).nextLine();
                                    pilihtipe = "E";
                                }
                            }
                        }
                        break;
                    }

                    case "E" -> {
                        System.out.println("");
                        break;
                    }

                    default -> {
                        System.out.println("  Wrong Type, Input Again!!!");
                        break;
                    }
                }
            }
        }
    }

    public static void deleteData() throws IOException {
        String pilihtipe = "a";

        while (!"E".equals(pilihtipe)) {
            System.out.println("""
                                O==============================O
                                |          Hapus Obat          |
                                O==============================O
                                | 1. Obat Cair                 |
                                | 2. Obat Kapsul               |
                                | 3. Obat Pil                  |
                                | E. Exit                      |
                                O==============================O""");
            System.out.print("  Input choice : ");
            pilihtipe = input.readLine();
            if (null == pilihtipe) {
                System.out.println(" Wrong Input! ");
            } else {
                switch (pilihtipe) {
                    case "1", "Digital" -> {
                        if (cair.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |         Data Tidak Ada        |
                                            O===============================O""");
                            System.out.print("Press [enter] to continue...");
                            new java.util.Scanner(System.in).nextLine();
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |            Obat Cair          |
                                            O===============================O""");
                            for (int i = 0; i < cair.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + cair.get(i).getKode());
                                System.out.println("    Nama Obat          : " + cair.get(i).getNamaObat());
                                System.out.println("    Dosis Anak         : " + cair.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa       : " + cair.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat         : Rp." + cair.get(i).getHargaObat());
                                System.out.println("    Stok Obat          : " + cair.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print(" Input Code : ");
                            String no = input.readLine();
                            for (int i = 0; i < cair.size(); i++) {
                                if (cair.get(i).getKode().equals(no)) {
                                    cair.remove(i);
                                    System.out.println("""
                                   O===============================O
                                   |     Obat Berhasil Dihapus     |
                                   O===============================O""");
                                    System.out.print("Press [enter] to continue...");
                                    new java.util.Scanner(System.in).nextLine();
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case "2", "Analog" -> {
                        if (kapsul.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |           Obat Kapsul         |
                                            O===============================O""");
                            for (int i = 0; i < kapsul.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + kapsul.get(i).getKode());
                                System.out.println("    Nama Obat          : " + kapsul.get(i).getNamaObat());
                                System.out.println("    Dosis Anak         : " + kapsul.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa       : " + kapsul.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat         : Rp." + kapsul.get(i).getHargaObat());
                                System.out.println("    Stok Obat          : " + kapsul.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print(" Input Code : ");
                            String no = input.readLine();
                            for (int i = 0; i < kapsul.size(); i++) {
                                if (kapsul.get(i).getKode().equals(no)) {
                                    kapsul.remove(i);
                                    System.out.println("""
                                   O===============================O
                                   |     Obat Berhasil Dihapus     |
                                   O===============================O""");
                                    System.out.print("Press [enter] to continue...");
                                    new java.util.Scanner(System.in).nextLine();
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case "3", "Obat Pil" -> {
                        if (pil.size() < 1) {
                            System.out.println("""
                                            O===============================O
                                            |      Data Tidak Ditemukan     |
                                            O===============================O""");
                        } else {
                            System.out.println("""
                                            O===============================O
                                            |            Obat Pil           |
                                            O===============================O""");
                            for (int i = 0; i < pil.size(); i++) {
                                System.out.println("[" + (i + 1) + "] Kode Obat     : " + pil.get(i).getKode());
                                System.out.println("    Nama Obat          : " + pil.get(i).getNamaObat());
                                System.out.println("    Dosis Anak         : " + pil.get(i).getDosisObatAnak());
                                System.out.println("    Dosis Dewasa       : " + pil.get(i).getDosisObatDewasa());
                                System.out.println("    Harga Obat         : Rp." + pil.get(i).getHargaObat());
                                System.out.println("    Stok Obat          : " + pil.get(i).getStokObat());
                                System.out.println("---------------------------------");
                            }
                            System.out.println("=================================");
                            System.out.print(" Input Code : ");
                            String no = input.readLine();
                            for (int i = 0; i < pil.size(); i++) {
                                if (pil.get(i).getKode().equals(no)) {
                                    pil.remove(i);
                                    System.out.println("""
                                   O===============================O
                                   |     Obat Berhasil Dihapus     |
                                   O===============================O""");
                                    System.out.print("Press [enter] to continue...");
                                    new java.util.Scanner(System.in).nextLine();
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case "E" -> {
                        System.out.println("");
                        break;
                    }

                    default -> {
                        System.out.println("  Wrong Type, Input Again!!!");
                        break;
                    }
                }
            }
        }
    }

    public static void menuUser() throws IOException {
        String pilih = "a";
        while (!"E".equals(pilih)) {
            System.out.println("""
                               O========================================O
                               |     Aplikasi Apotek Chemical Farma     |
                               O========================================O
                               | 1. Menu 1                              |
                               | 2. Menu 2                              |
                               | 3. Menu 3                              |
                               | E. Exit                                |
                               O========================================O""");
            System.out.print("  Input choice : ");
            pilih = input.readLine();
            if (null == pilih) {
                System.out.println("O========================================O");
                System.out.println("|             Invalid choice             |");
                System.out.println("O========================================O");

            } else {
                switch (pilih) {

                    case "1" ->
                        System.exit(0);

                    case "2" ->
                        System.exit(0);

                    case "3" ->
                        System.exit(0);

                    case "E" -> {
                        System.out.println("O========================================O");
                        System.out.println("|         Thank you for visiting         |");
                        System.out.println("O========================================O");
                    }

                    default -> {
                        System.out.println("O========================================O");
                        System.out.println("|             Invalid choice             |");
                        System.out.println("O========================================O");
                    }
                }
            }
        }
    }
}