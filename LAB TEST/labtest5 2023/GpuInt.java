public class GpuInt implements NumberInterface<GpuInt> {
    private int value;
    public GpuInt(){
        this.value=0;
    }
    public GpuInt(int i){
        this.value=i;
    }
    public GpuInt fromInteger(int value) {
        return new GpuInt(value);
    }
    public Integer toInteger(){
        return this.value;
    }
// Metadata
@Override
public String getIdentifier() {
    return "GpuInt";
}

    @Override
    public boolean isPositive() {
        return this.value >= 0;
    }

    @Override
    public boolean isEven() {
        return this.value % 2 == 0;
    }

    @Override
    public String toString() {
        return String.format("%s[%d]" , getDevice(), this.value);
    }
    public String getDevice() {
        return "GPU";
    }
    @Override
    public int getValue() {
        return this.value;
    }

    public GpuInt add(GpuInt o) {
        System.out.printf("GPU Debug: %d + %d = %d\n", this.value, o.value, this.value + o.value);
        return new GpuInt(this.value + o.value);
    }
    public GpuInt mul(GpuInt o) {
        System.out.printf("GPU Debug: %d * %d = %d\n", this.value, o.value, this.value * o.value);
        return new GpuInt(this.value * o.value);
    }
}
