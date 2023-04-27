package ProjectAkhir;

import static ProjectAkhir.Main.dataUser;
import static ProjectAkhir.Main.userAktif;

/**
 *
 * @author ASUS-GK
 */
public class ObatPil extends Obat implements Dosis {

    private String kode;

    public ObatPil(String kode, String namaObat, String dosisObatAnak, String dosisObatDewasa, int hargaObat, int stokObat) {
        super(namaObat, dosisObatAnak, dosisObatDewasa, hargaObat, stokObat);
        this.kode = "P" + kode;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    @Override
    public void tampil() {
        System.out.println("Code          : " + this.kode);
        System.out.println("    Name          : " + this.namaObat);
    }

    public void tampil(boolean showDosis) {
        if (showDosis) {
            tampil();
            System.out.println("    Child Dose    : " + this.dosisObatAnak);
            System.out.println("    Adult Dose    : " + this.dosisObatDewasa);
            System.out.println("    Price         : Rp." + this.hargaObat);
            System.out.println("    Stock         : " + this.stokObat);
            System.out.println("---------------------------------");
        } else {
            tampil();
            tampilDosis();
            System.out.println("    Price         : Rp." + this.hargaObat);
            System.out.println("    Stock         : " + this.stokObat);
            System.out.println("---------------------------------");
        }
    }

    @Override
    public void tampilDosis() {
        for (User cekUser : dataUser) {
            if (cekUser.getUsername().equals(userAktif)) {
                if (cekUser.getAge() < 17) {
                    System.out.println("    Dose          : " + this.dosisObatAnak);
                } else {
                    System.out.println("    Dose          : " + this.dosisObatDewasa);
                }
            }
        }
    }
}
