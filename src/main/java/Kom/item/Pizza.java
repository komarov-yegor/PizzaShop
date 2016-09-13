package Kom.item;

import java.math.BigDecimal;

public class Pizza {
    private int id;
    private String title;
    private BigDecimal price;
    private String preview;
    private String previewLarge;
    private String description;

    public Pizza() {

    }

    public Pizza(int id, String title, BigDecimal price, String preview, String previewLarge, String description) {
	this.id = id;
	this.title = title;
	this.price = price;
	this.preview = preview;
	this.previewLarge = previewLarge;
	this.description = description;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public BigDecimal getPrice() {
	return price;
    }

    public void setPrice(BigDecimal price) {
	this.price = price;
    }

    public String getPreview() {
	return preview;
    }

    public void setPreview(String preview) {
	this.preview = preview;
    }

    public String getPreviewLarge() {
	return previewLarge;
    }

    public void setPreviewLarge(String previewLarge) {
	this.previewLarge = previewLarge;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "Pizza: " + this.title;
    }
}
