package swing;

import javax.swing.*;
import java.awt.*;

public class FunfactPanel extends JPanel {

    public FunfactPanel() {
        setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.GRAY));
        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 4, 10, 10)); 
        contentPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        contentPanel.setBackground(Color.decode("#DBD4CE"));

        // Daftar fun facts
        FunFactItem[] facts = {
            new FunFactItem("Kumis Kucing", "kumis kucing.jpg", "Kumis kucing itu bukan cuma hiasan, lho! Kumis mereka adalah sensor super sensitif yang bisa mendeteksi perubahan kecil di lingkungan sekitar. Kumis ini membantu kucing mengukur celah sempit, merasakan gerakan udara, dan bahkan menangkap getaran mangsa. Jangan pernah memotongnya ya, karena bisa bikin kucing bingung atau stres!"),
            new FunFactItem("Kucing Suka Kotak", "kucing suka kotak.jpg", "Kenapa kucing suka banget masuk kardus? Karena kotak memberikan rasa aman dan nyaman seperti “tempat persembunyian” dari predator. Plus, kardus itu punya tekstur empuk dan bisa menyerap panas tubuh, jadi pas banget buat tempat tidur atau main."),
            new FunFactItem("Kucing Tidur Hingga 16 Jam", "kucing tidur.jpg", "Kucing dikenal sebagai sleeping champion! Mereka bisa tidur 12–18 jam sehari, terutama kucing dewasa. Tidur adalah cara mereka menyimpan energi, karena secara alami mereka adalah predator yang perlu tenaga besar saat berburu (meskipun sekarang buruannya cuma makanan kaleng 😺)."),
            new FunFactItem("Paw Kucing Super Sensitif", "paw kucing.jpg", "Telapak kaki kucing itu bukan hanya lucu, tapi juga fungsional! Mereka punya bantalan empuk (paw pads) yang membantu meredam suara langkah saat mengintai. Paw juga punya kelenjar bau, jadi saat kucing menggaruk, dia sedang menandai wilayahnya juga."),
            new FunFactItem("Ras Sphynx Tidak Berbulu", "botak.jpg", "Sphynx adalah ras kucing unik tanpa bulu karena mutasi genetik. Tapi bukan berarti mereka benar-benar polos — biasanya mereka punya bulu halus mirip beludru. Karena tak punya bulu pelindung, mereka butuh perlindungan ekstra dari suhu dingin dan harus sering dimandikan karena kulitnya mudah berminyak."),
            new FunFactItem("Kucing Putih & Mata Biru", "kucing putih.jpg", "Kucing putih bermata biru memang cantik, tapi mereka juga punya kecenderungan mengalami tunarungu (tuli), terutama jika dua matanya biru. Ini terjadi karena mutasi genetik yang memengaruhi pigmentasi dan pendengaran. Tapi jangan khawatir, mereka tetap bisa hidup bahagia dan aktif!"),
            new FunFactItem("Ekor Kucing", "ekor kucing.jpg", "Ekor kucing adalah alat komunikasi dan keseimbangan. Saat ekornya berdiri lurus: tandanya dia senang dan ramah. Kalau menggeliat atau memukul lantai: hati-hati, dia lagi kesal! Ekor juga bantu jaga keseimbangan saat lompat atau berjalan di tempat sempit."),
            new FunFactItem("Mata Kucing", "mata kucing.jpg", "Mata kucing bisa melihat dalam gelap lebih baik dari manusia, berkat lapisan reflektif di belakang retina yang disebut tapetum lucidum. Itu sebabnya mata mereka sering tampak menyala di malam hari. Pupil yang bisa melebar besar juga bantu mereka menangkap cahaya maksimal di kondisi minim cahaya."),
            new FunFactItem("Warna Bulu Terkait Suhu", "foto siamese.jpg", "Pada ras seperti Siamese atau Birman, warna bulu bisa dipengaruhi suhu tubuh! Gen mereka membuat bulu lebih gelap di area yang lebih dingin (seperti ujung telinga, kaki, ekor). Jadi, kucing ini bisa punya \"warna\" yang berubah tergantung suhu lingkungan!"),
            new FunFactItem("Kucing Hitam", "hitam.jpg", "Kucing hitam sering dianggap membawa sial di beberapa budaya, tapi sebenarnya mereka pembawa keberuntungan di tempat lain (contohnya di Jepang dan Inggris). Menariknya, warna hitam juga bisa menyamarkan penyakit dan membuat mereka tampak lebih \"sehat\", jadi banyak bertahan hidup lebih lama di alam liar."),
            new FunFactItem("90% Calico Adalah Betina", "nala.jpg", "Kucing calico (berwarna putih, oranye, dan hitam) hampir semuanya betina karena pola warnanya ditentukan oleh kromosom X. Betina punya dua kromosom X, jadi bisa \"menampilkan\" dua warna (oranye dan hitam). Jantan hanya punya satu kromosom X, jadi sangat jarang yang bisa jadi calico. Jantan calico biasanya steril dan langka!")
        };

        for (FunFactItem fact : facts) {
            contentPanel.add(new FunFactCard(fact.title, fact.imageName, fact.description));
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    static class FunFactItem {
        String title;
        String imageName;
        String description;

        public FunFactItem(String title, String imageName, String description) {
            this.title = title;
            this.imageName = imageName;
            this.description = description;
        }
    }
}
