package designpatterns.example.stracture.adaptor;

public class DataServiceAdaptor implements DataServiceV1 {

    private final DataServiceV2 dataServiceV2;

    public DataServiceAdaptor() {
        this.dataServiceV2 = new DataServiceV2Impl();
    }

    @Override
    public int saveText(int index, String text) {
        return (int) dataServiceV2.saveData(index, text);
    }

    @Override
    public String getText(int index) {
        return dataServiceV2.getData(index);
    }

}
