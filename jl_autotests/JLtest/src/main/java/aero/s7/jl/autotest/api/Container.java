package aero.s7.jl.autotest.api;

import java.util.List;

public class Container<T> {
    private List<T> content;

    public Container() {
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

}
