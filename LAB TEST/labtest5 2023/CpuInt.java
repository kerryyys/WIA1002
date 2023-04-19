public class CpuInt implements NumberInterface<CpuInt> {
    private int value;

    public CpuInt(){
        this.value=0;
    }
    public CpuInt(int i){
        this.value=i;
    }
    public CpuInt fromInteger(int value) {
        return new CpuInt(value);
    }
    public Integer toInteger(){
        return this.value;
    }
    public String getIdentifier(){
        return "CpuInt";
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
        public String toString () {
        return String.format("%s[%d]", getDevice(), this.value);
    }
        public String getDevice () {
        return "CPU";
    }
    @Override
    public int getValue() {
        return this.value;
    }

        public CpuInt add (CpuInt o){
        System.out.printf("CPU Debug: %d + %d = %d\n", this.value, o.value, this.value + o.value);
        return new CpuInt(this.value + o.value);
    }
        public CpuInt mul (CpuInt o){
        System.out.printf("CPU Debug: %d * %d = %d\n", this.value, o.value, this.value * o.value);
        return new CpuInt(this.value * o.value);
    }
}