package com.product;

public class Category {
    private final int category_id;
    private final String category;
    private final String tag;
    private int status;

    public Category(int category_id, String category, String tag) {
        this.category_id = category_id;
        this.category = category;
        this.tag = tag;
        status = 1;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory() {
        return category;
    }

    public String getTag() {
        return tag;
    }   

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status == 0 || status == 1) {
            this.status = status;
        } else {
            System.out.println("El estatus debe 0 or 1");
        }
    }

    @Override
    public String toString() {
        return String.format("{%d,%s,%s,%d}", category_id, category, tag, status);
    }
}