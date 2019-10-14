package com.sanket.nhl.Model;

public class TimeZone {
    private int offset;
    private String tz;
    private String id;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "TimeZone{" +
                        "offset = '" + offset + '\'' +
                        ",tz = '" + tz + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
