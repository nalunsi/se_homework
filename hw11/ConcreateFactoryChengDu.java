public class ConcreateFactoryChengDu implements HotSopt{

    @Override
    public HotSoptProduct produce()
    {
        return new ChengDuHotSopt();
    }
}
