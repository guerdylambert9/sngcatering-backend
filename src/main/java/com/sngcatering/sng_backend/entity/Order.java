package com.sngcatering.sng_backend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    @JsonProperty("type")
    private String type;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "phone")
    @JsonProperty("phone")
    private String phone;

    @Column(name = "address")
    @JsonProperty("address")
    private String address;

    @Column(name = "event_date", nullable = true)
    @JsonProperty("eventDate")
    private LocalDate eventDate;

    @Column(name = "guests", nullable = true)
    @JsonProperty("guests")
    private Integer guests;

    @Column(name = "preferences", nullable = true)
    @JsonProperty("preferences")
    private String preferences;

    @Column(name = "total_price", nullable = false)
    @JsonProperty("totalPrice")
    private BigDecimal totalPrice;

    @Column(name = "payment_intent_id")
    @JsonProperty("paymentIntentId")
    private String paymentIntentId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    @JsonProperty("items")
    private List<OrderItem> items = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", eventDate=" + eventDate +
                ", guests=" + guests +
                ", preferences='" + preferences + '\'' +
                ", totalPrice=" + totalPrice +
                ", paymentIntentId='" + paymentIntentId + '\'' +
                ", items=" + items +
                '}';
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
    public String getPreferences() { return preferences; }
    public void setPreferences(String preferences) { this.preferences = preferences; }
    public Integer getGuests() { return guests; }
    public void setGuests(Integer guests) { this.guests = guests; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
    public String getPaymentIntentId() { return paymentIntentId; }
    public void setPaymentIntentId(String paymentIntentId) { this.paymentIntentId = paymentIntentId; }
}









//package com.sngcatering.sng_backend.entity;
//
//import jakarta.persistence.*;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "type", nullable = false)
//    @JsonProperty("type")
//    private String type;
//
//    @Column(name = "name")
//    @JsonProperty("name")
//    private String name;
//
//    @Column(name = "email")
//    @JsonProperty("email")
//    private String email;
//
//    @Column(name = "phone")
//    @JsonProperty("phone")
//    private String phone;
//
//    @Column(name = "address")
//    @JsonProperty("address")
//    private String address;
//
//    @Column(name = "event_date", nullable = true)
//    @JsonProperty("eventDate")
//    private LocalDate eventDate;
//
//    @Column(name = "guests", nullable = true)
//    @JsonProperty("guests")
//    private Integer guests;
//
//    @Column(name = "preferences", nullable = true)
//    @JsonProperty("preferences")
//    private String preferences;
//
//    @Column(name = "total_price", nullable = false)
//    @JsonProperty("totalPrice")
//    private BigDecimal totalPrice;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "order_id")
//    @JsonProperty("items")
//    private List<OrderItem> items = new ArrayList<>();
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", address='" + address + '\'' +
//                ", eventDate=" + eventDate +
//                ", guests=" + guests +
//                ", preferences='" + preferences + '\'' +
//                ", totalPrice=" + totalPrice +
//                ", items=" + items +
//                '}';
//    }
//
//    public String getType() { return type; }
//    public void setType(String type) { this.type = type; }
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//    public String getAddress() { return address; }
//    public void setAddress(String address) { this.address = address; }
//    public LocalDate getEventDate() { return eventDate; }
//    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
//    public String getPreferences() { return preferences; }
//    public void setPreferences(String preferences) { this.preferences = preferences; }
//    public Integer getGuests() { return guests; }
//    public void setGuests(Integer guests) { this.guests = guests; }
//    public List<OrderItem> getItems() { return items; }
//    public void setItems(List<OrderItem> items) { this.items = items; }
//    public BigDecimal getTotalPrice() { return totalPrice; }
//    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
//}









//package com.sngcatering.sng_backend.entity;
//
//import jakarta.persistence.*;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "type", nullable = false)
//    @JsonProperty("type")
//    private String type; // "regular" or "catering"
//
//    @Column(name = "name")
//    @JsonProperty("name")
//    private String name;
//
//    @Column(name = "email")
//    @JsonProperty("email")
//    private String email;
//
//    @Column(name = "phone")
//    @JsonProperty("phone")
//    private String phone;
//
//    @Column(name = "address")
//    @JsonProperty("address")
//    private String address;
//
//    @Column(name = "event_date", nullable = true)
//    @JsonProperty("eventDate")
//    private LocalDate eventDate;
//
//    @Column(name = "guests", nullable = true)
//    @JsonProperty("guests")
//    private Integer guests;
//
//    @Column(name = "preferences", nullable = true)
//    @JsonProperty("preferences")
//    private String preferences;
//
//    @Column(name = "total_price", nullable = false)
//    @JsonProperty("totalPrice")
//    private BigDecimal totalPrice;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "order_id")
//    @JsonProperty("items")
//    private List<OrderItem> items = new ArrayList<>();
//
//    public String getType() { return type; }
//
//    public String getName() { return name; }
//
//    public void setName(String name) { this.name = name; }
//
//    public String getEmail() { return email; }
//
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPhone() { return phone; }
//
//    public void setPhone(String phone) { this.phone = phone; }
//
//    public String getAddress() { return address; }
//
//    public void setAddress(String address) { this.address = address; }
//
//    public LocalDate getEventDate() { return eventDate; }
//
//    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
//
//    public String getPreferences() { return preferences; }
//
//    public void setPreferences(String preferences) {
//        this.preferences = preferences;
//    }
//
//    public Integer getGuests() { return guests; }
//
//    public List<OrderItem> getItems() { return items; }
//
//    public void setItems(List<OrderItem> items) { this.items = items; }
//
//    public BigDecimal getTotalPrice() { return totalPrice; }
//
//    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }
//
//}
