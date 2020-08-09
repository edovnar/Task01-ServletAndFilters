package domain;

import java.util.Date;

public class Order {
    private String id;
    private Date submittedAt;
    private Date updatedAt;
    private String submittedBy;
    private String item;
    private Integer quantity;
//todo generate on server
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Date getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(Date submittedAt) { this.submittedAt = submittedAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

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
