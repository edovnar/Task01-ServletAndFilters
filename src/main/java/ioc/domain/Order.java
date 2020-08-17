package ioc.domain;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Order {
    private String id;
    private LocalDateTime submittedAt;
    private LocalDateTime updatedAt;
    private String submittedBy;
    private String item;
    private Integer quantity;

    public Order(String id, LocalDateTime submittedAt, LocalDateTime updatedAt,
                 String submittedBy, String item, Integer quantity) {
        this.id = id;
        this.submittedAt = submittedAt;
        this.updatedAt = updatedAt;
        this.submittedBy = submittedBy;
        this.item = item;
        this.quantity = quantity;
    }


    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", submittedAt=" + submittedAt +
                ", updatedAt=" + updatedAt +
                ", submittedBy='" + submittedBy + '\'' +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
