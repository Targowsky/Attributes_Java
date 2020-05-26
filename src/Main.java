import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /*zapisuje następnie wczytuje wszystkie dane w extensji*/
    private static void testExtentManual() {
        final String extentFile = "d:\\studia\\MAS\\MP1.bin";
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new BufferedOutputStream(new
                    FileOutputStream(extentFile)));
            Komputer.writeExtent(OOS);
            OOS.close();
            ObjectInputStream OIS = new ObjectInputStream(new BufferedInputStream(new
                    FileInputStream(extentFile)));
            Komputer.readExtent(OIS);
            OIS.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Komputer komputer = new Komputer("SUPERTURBO2000", new AdditionalGPU("nVidia", "gtx2700"), null, 7000, Arrays.asList("スーパーターボ2000", "超级涡轮2000", "2000סופר טורבו"));
        Komputer komputer0 = new Komputer("ProfessionalPC", new AdditionalGPU("Amd", "radeon5700xt"), 5500, Arrays.asList("プロフェッショナル", "专业的", "מקצועי"));
        Komputer komputer1 = new Komputer("BasicPC", new AdditionalGPU("nVidia", "gtx1060ti"), 3000, Arrays.asList("基本的な", "基本", "בסיסי"));
        Komputer.showExtent();
        testExtentManual();
        System.out.println(Komputer.wybierzZestawTanszyNiz(5600));
        //Komputer.wyswietlNajdrozszy();
        //Komputer.
        //Komputer.zwiekszCeneZestawu(500);
        //Komputer.showExtent();
    }
}
