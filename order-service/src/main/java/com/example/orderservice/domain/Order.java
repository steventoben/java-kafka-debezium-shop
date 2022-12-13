package com.example.orderservice.domain;

import java.math.BigDecimal;

/**
 * Order should represent a snapshot in time
 * So if something changes (price, customer address,product name, etc.),
 * It won't affect the order stored in persistence.
 *
 * An order should be immutable once finalized
 *
 */
public class Order {
    private Long orderId;
    //private String orderNumber;
    private String customerId;
    private String customerName;
    private Long shippingAddressId;
    private Long billingAddressId;
    private BigDecimal totalPrice;
}
