package org.example.doitone.domain;

import java.util.List;
import lombok.Getter;

@Getter
public class ListResponseWrapper<T> {
    private List<T> result;

    public ListResponseWrapper(List<T> result) {
        this.result = result;
    }
}
