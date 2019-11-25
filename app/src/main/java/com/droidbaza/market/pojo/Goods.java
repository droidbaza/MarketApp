
package com.droidbaza.market.pojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by droidbaza on 25/11/19.
 */


public class Goods {

    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;
    @SerializedName("queryTime")
    @Expose
    private String queryTime;
    @SerializedName("totalTime")
    @Expose
    private String totalTime;
    @SerializedName("partial")
    @Expose
    private Boolean partial;
    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getPartial() {
        return partial;
    }

    public void setPartial(Boolean partial) {
        this.partial = partial;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}