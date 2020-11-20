package org.disco.pojo;

public class OutEvent {
    private String id = "";
    private Integer one = 0;
    private Integer zero = 0;

    public OutEvent(){}

    public OutEvent(InEvent e) {
        this.id = e.getId();
        this.one = e.getValue() == 1 ? 1 : 0;
        this.zero = e.getValue() == 0 ? 1 : 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer value) {
        this.one = value;
    }

    public Integer getZero() {
        return one;
    }

    public void setZero(Integer value) {
        this.zero = value;
    }

    @Override
    public String toString() {
        return "OutEvent{id='" + id + '\'' + ", one=" + one + ", zero=" + zero + '}';
    }
}
