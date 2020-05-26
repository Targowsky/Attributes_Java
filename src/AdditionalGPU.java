import java.io.Serializable;

public class AdditionalGPU implements Serializable {

    private String firma;
    private String nazwa;

    AdditionalGPU(String firma, String nazwa){
        this.firma = firma;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return firma + ' ' + nazwa;
    }
}
