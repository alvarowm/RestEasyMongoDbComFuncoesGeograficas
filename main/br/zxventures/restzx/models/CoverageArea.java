
package br.zxventures.restzx.models;

import java.util.List;

public class CoverageArea {

    private String type;
    private List<List<List<List<Integer>>>> coordinates = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<List<List<Integer>>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<List<List<Integer>>>> coordinates) {
        this.coordinates = coordinates;
    }
}
