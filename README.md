# E-Commerce Order Management API – What the APIs Do

This backend application provides REST APIs to manage **customers**, **orders**, and **order items** for a simple e-commerce system.

Below is a **plain, human‑friendly explanation** of what each API does.

---

## 👤 Customer APIs

### 1. Create Customer – `POST /customers`

This API creates a new customer in the system.

You provide:

* First name
* Last name
* Contact details (address, city, state, postal code, phone, email)

**Example use:**

> When a new user signs up or is registered in the system.

![#1_customer_creation.png](images/customer_api/%231_customer_creation.png)

---

### 2. Get Customer Details – `GET /customers/{customerId}`

This API fetches customer information using the customer ID.

It returns:

* Customer name
* All contact addresses linked to the customer

**Example use:**

> To view customer profile or address details.

![#2_get_customer_by_id.png](images/customer_api/%232_get_customer_by_id.png)

---

### 3. Update Customer – `PUT /customers/{customerId}`

This API updates basic customer information.

You can update:

* First name
* Last name

**Example use:**

> When a customer edits their profile details.

![#3_update_customer.png](images/customer_api/%233_update_customer.png)

---

### 4. Delete Customer – `DELETE /customers/{customerId}`

This API removes a customer from the system.

**Example use:**

> When a customer account is permanently deleted.

![#4_delete_customer_by_id.png](images/customer_api/%234_delete_customer_by_id.png)

---

## 🛒 Order APIs

### 5. Create Order – `POST /orders`

This API creates a new order for a customer.

You provide:

* Order date
* Customer ID
* Shipping address ID
* Billing address ID
* List of products with quantity and status

**Example use:**

> When a customer places a new order.

![#1_order_creation.png](images/order_api/%231_order_creation.png)

---

### 6. Get Order Details – `GET /orders/{orderId}`

This API retrieves full details of an order.

It returns:

* Order information
* Customer details
* Shipping and billing address
* All items in the order

**Example use:**

> To show order summary or order tracking information.

![#2_get_order_by_id.png](images/order_api/%232_get_order_by_id.png)

---

### 7. Update Order – `PUT /orders/{orderId}`

This API updates an existing order.

You can update:

* Shipping address
* Billing address

**Example use:**

> When a customer changes delivery or billing address after ordering.

![#5_update.png](images/order_api/%235_update.png)

---

### 8. Delete Order – `DELETE /orders/{orderId}`

This API deletes an order completely.

All order items linked to the order are also deleted automatically.

**Example use:**

> When an order is cancelled.

![#3_delete_order.png](images/order_api/%233_delete_order.png)

---

## 📦 Order Item APIs

### 9. Add Item to Order – `POST /orders/{orderId}/items`

This API adds a new product to an existing order.

You provide:

* Product ID
* Quantity
* Status

**Example use:**

> When a customer adds another product to the same order.

![#4_item_creation.png](images/order_api/%234_item_creation.png)

---

### 10. Update Order Item – `PUT /orders/{orderId}/items/{itemId}`

This API updates a specific item in an order.

You can update:

* Quantity
* Status

**Example use:**

> When a customer changes the quantity of a product.

![#5_update.png](images/order_api/%235_update.png)

---

### 11. Delete Order Item – `DELETE /orders/{orderId}/items/{itemId}`

This API removes a product from an order.

**Example use:**

> When a customer removes an item from their order.

![#6_delete.png](images/order_api/%236_delete.png)

---

## ⚠️ Error Handling

All APIs return **clear and user‑friendly error messages** if:

* Required data is missing
* Invalid data is provided
* A resource is not found
* Request format is incorrect

---

## 🎯 Summary

* Customer APIs manage users and their contact details
* Order APIs manage the overall order
* Order Item APIs manage individual products inside an order
* The system supports full **CRUD (Create, Read, Update, Delete)** operations

---

**Project Type:** Back end Assignment / Academic Project
