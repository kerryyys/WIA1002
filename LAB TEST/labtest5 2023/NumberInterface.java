public interface NumberInterface<T extends NumberInterface<T>> {

        public String getDevice();
        public int getValue();

        public T fromInteger(int value);
        public Integer toInteger();
        public T add(T o);
        public T mul(T o);

    // Metadata
    String getIdentifier();

    boolean isPositive();

    boolean isEven();

}
