package reponse;

/**
 * Created by Administrator on 2017/7/27.
 */
public class ResponseBase<T> {
    private T flag;

    public T getFlag() {
        return flag;
    }

    public void setFlag(T flag) {
        this.flag = flag;
    }
}
