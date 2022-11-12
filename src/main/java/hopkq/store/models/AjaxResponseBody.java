package hopkq.store.models;

import lombok.Data;

import java.util.List;

@Data
public class AjaxResponseBody<T> {

    List<T> listData;
    String msg;

}
