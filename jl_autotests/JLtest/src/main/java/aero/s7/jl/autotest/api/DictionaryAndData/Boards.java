package aero.s7.jl.autotest.api.DictionaryAndData;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Boards {
    @JsonProperty("aircraft_id")
    private int aircraftId;

    @JsonProperty("board_id")
    private int boardId;

    private String reg;
    private CapacityBoards capacity;

    public Boards() {
    }

    public int getAircraftId() {
        return aircraftId;
    }
    public int getBoardId() {
        return boardId;
    }
    public String getReg() {
        return reg;
    }
    public CapacityBoards getCapacity() {
        return capacity;
    }
}
