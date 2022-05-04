public class ConcreateFactoryChongQing implements HotSopt{

    @Override
    public HotSoptProduct produce()
    {
        return new ChongQingHotSopt();
    }
}