public class MyTest {

    public static void main(String[] args) {
        HotSopt factoryA = new ConcreateFactoryChengDu();
        HotSoptProduct product1 = factoryA.produce();
        product1.method("毛肚");
    }
}
