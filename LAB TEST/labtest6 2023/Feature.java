import java.util.List;
import java.util.Comparator;

public abstract class Feature<T extends Comparable<T>> {
    private List <Data<T>> data;

    Feature(List<Data<T>> data){
        this.data=data;
    }

    public abstract Feature<T> dataCleaning();  //abstract method dont need method code

    //merge method quite confusing
    public <U extends Comparable<U>> Feature<T> merge(Feature<U> other, Transformer<U, T> converter){
        for(Data<U> otherData : other.getData())
            data.add(new Data<>(otherData.getUser(), converter.convertFrom(otherData.getData()), otherData.getDate()));
        return this;
    }
    public List<Data<T>> sortByDate(){
        data.sort(Comparator.comparingInt(Data::getDate));
        return data;
    }
public List<Data<T>> getData(){
        return data;
    }
}
