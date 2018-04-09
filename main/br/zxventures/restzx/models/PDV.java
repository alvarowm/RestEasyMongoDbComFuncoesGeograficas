
package br.zxventures.restzx.models;

public class PDV {

    private Integer id;
    private String tradingName;
    private String ownerName;
    private String document;
    private CoverageArea coverageArea;
    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

	public CoverageArea getCoverageArea() {
		return coverageArea;
	}

	public void setCoverageArea(CoverageArea coverageArea) {
		this.coverageArea = coverageArea;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
