package ar.com.entropia.pattern.singleton;

/**
 * This pattern is much like the Singleton, but the Initialization on Demand Holder has critical advantage over the Singleton: It is thread safe.
 * The getInstance() method from the Singleton pattern is not thread safe, not if you don't make it synchronized, so,
 * it can be instantiate more than once. If you do make your method synchronized, you are making your getInstance()
 * method slower than it could be if it were not.
 */
public class SingletonSample {

    private Integer number;

    private SingletonSample(){
        number = Integer.valueOf(1);
    }

    public static SingletonSample getInstance(){
        return SingletonSampleHolder.INSTANCE;
    }

    private static class SingletonSampleHolder {
        private static final SingletonSample INSTANCE = new SingletonSample();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
