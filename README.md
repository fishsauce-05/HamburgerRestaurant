# 🍔 BurgerRestaurant - Hệ Thống Quản Lý Đơn Hàng

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Principles-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Educational-green?style=for-the-badge)

## 📋 Mô Tả Dự Án

**BurgerRestaurant** là một dự án minh họa Lập trình Hướng đối tượng (OOP) mô phỏng hệ thống quản lý đơn hàng của một nhà hàng burger. Ứng dụng cho phép khách hàng tạo đơn hàng tùy chỉnh bằng cách lựa chọn burger, đồ uống và món phụ, với khả năng thêm topping và điều chỉnh kích cỡ.

### ✨ Tính Năng Chính

- 🍔 **Burger Tùy Chỉnh**: Thêm tối đa 3 topping cho burger thường hoặc 5 topping cho burger deluxe
- 🥤 **Kích Cỡ Đồ Uống Linh Hoạt**: Chọn từ Small, Medium, hoặc Large với điều chỉnh giá tự động
- 🍟 **Món Phụ**: Bao gồm các món phụ phổ biến như khoai tây chiên, hành tây chiên, hoặc salad
- 📦 **Combo Bữa Ăn**: Tạo bữa ăn hoàn chỉnh với burger, đồ uống và món phụ
- ⭐ **Gói Deluxe**: Giá trọn gói đặc biệt bất kể số lượng topping thêm vào
- 🧾 **Hóa Đơn Chi Tiết**: Tạo bảng phân tích giá chi tiết cho đơn hàng

### 🎓 Điểm Nổi Bật Kỹ Thuật

- ✅ Minh họa các nguyên lý OOP cốt lõi: **Encapsulation**, **Inheritance**, **Polymorphism**, **Abstraction**
- ✅ Triển khai các design pattern: **Template Method**, **Delegation**, **Factory**
- ✅ Sử dụng Java **Generics** và **Collections** để quản lý dữ liệu linh hoạt
- ✅ Áp dụng **Enum** để lựa chọn kích cỡ an toàn về kiểu dữ liệu

---

## 📁 Cấu Trúc Dự Án

```
BurgerRestaurant/
 └── src/
     └── com/
         └── burgers/
             ├── Main.java 
             ├── item/ 
             │   ├── Burger.java 
             │   ├── DeluxeBurger.java 
             │   ├── Drink.java 
             │   ├── Item.java 
             │   └── SideItem.java 
             └── order/ 
                 └── MealOrder.java
```

### 📦 Package Structure

| Package | Mô Tả |
|---------|-------|
| `com.burgers` | Package gốc chứa Main class |
| `com.burgers.item` | Chứa các lớp đại diện cho món ăn |
| `com.burgers.order` | Chứa các lớp quản lý đơn hàng |

---

## 🏗️ Kiến Trúc Class

### Class Diagram

```
Item (abstract)
├── Burger
│   └── DeluxeBurger
├── Drink
└── SideItem

MealOrder
├── HAS-A Burger
├── HAS-A Drink
└── HAS-A SideItem
```

### 📊 Bảng Mô Tả Class

| Class | Type | Mô Tả | Trách Nhiệm Chính |
|-------|------|-------|-------------------|
| `Item` | Abstract | Lớp cơ sở cho tất cả món ăn | Định nghĩa thuộc tính và hành vi chung |
| `Burger` | Concrete | Burger có thể thêm topping | Quản lý danh sách topping, tính giá |
| `DeluxeBurger` | Concrete | Burger cao cấp giá cố định | Override logic tính giá |
| `Drink` | Concrete | Đồ uống với nhiều size | Quản lý kích cỡ, tính phụ phí |
| `SideItem` | Concrete | Món phụ đơn giản | Lưu trữ thông tin món phụ |
| `MealOrder` | Concrete | Quản lý đơn hàng combo | Tổng hợp món ăn, tính tổng giá |

---

## 🔍 Phân Tích Danh Từ và Động Từ

### 📌 Danh Từ → Classes

| Danh Từ | Phân Loại | Thành Class? | Class Name | Lý Do |
|---------|-----------|--------------|------------|-------|
| **Đơn hàng** | Thực thể | ✅ Có | `MealOrder` | Đối tượng nghiệp vụ cốt lõi |
| **Burger** | Thực thể | ✅ Có | `Burger` | Sản phẩm chính có logic phức tạp |
| **Đồ uống** | Thực thể | ✅ Có | `Drink` | Có thuộc tính kích cỡ đặc biệt |
| **Món phụ** | Thực thể | ✅ Có | `SideItem` | Cần phân biệt type |
| **Topping** | Thực thể | ✅ Có | `Item` (anonymous) | Thực thể đơn giản |
| **Món ăn** | Thực thể | ✅ Có | `Item` (abstract) | Lớp cơ sở chung |
| **Kích cỡ** | Thuộc tính | ✅ Có | `Size` (enum) | Tập giá trị hạn chế |
| **Giá** | Thuộc tính | ❌ Không | - | Trở thành property |
| **Hóa đơn** | Hành vi | ❌ Không | - | Là method `printItemizedList()` |

### 🎬 Động Từ → Methods

| Động Từ | Thành Method? | Method Name | Class | Mô Tả |
|---------|---------------|-------------|-------|-------|
| **Tạo** | ✅ Có | Constructors | All | Khởi tạo objects |
| **Thêm** | ✅ Có | `addTopping()` | `Burger`, `MealOrder` | Thêm topping vào burger |
| **Chọn** | ✅ Có | `setSize()` | `Drink` | Chọn kích cỡ đồ uống |
| **Tính toán** | ✅ Có | `getAdjustedPrice()` | `Item` subclasses | Tính giá với các điều chỉnh |
| **Tính tổng** | ✅ Có | `getTotalPrice()` | `MealOrder` | Tính tổng giá đơn hàng |
| **In** | ✅ Có | `printItem()`, `printItemizedList()` | `Item`, `MealOrder` | Hiển thị thông tin |
| **Lấy** | ✅ Có | `getName()`, `getBasePrice()` | `Item` | Getter methods |
| **Kiểm tra** | ✅ Có | Logic in `addTopping()` | `Burger` | Validate max toppings |
| **Xóa** | ❌ Không | - | - | Chưa triển khai |
| **Thanh toán** | ❌ Không | - | - | Chưa triển khai |

---

## 🎯 Chi Tiết Các Class

### 1️⃣ Item.java - Abstract Base Class

```java
public abstract class Item {
    protected String name;
    protected String type;
    protected double price;
}
```

**Mục đích**: Lớp cha chung cho tất cả món ăn

**Key Methods**:
- `getAdjustedPrice()` - Tính giá với các điều chỉnh (polymorphism)
- `printItem()` - Template method cho việc hiển thị
- `getName()`, `getBasePrice()` - Getters

**Tại sao Abstract?**
- Món ăn chung chung không thể tồn tại độc lập
- Buộc các lớp con phải implement logic riêng
- Cho phép polymorphism khi xử lý danh sách món ăn

---

### 2️⃣ Burger.java - Customizable Burger

```java
public class Burger extends Item {
    private List<Item> toppings;
    private int maxToppings = 3;
}
```

**Mục đích**: Đại diện cho burger có thể thêm topping

**Key Features**:
- ✅ Quản lý danh sách topping với `List<Item>`
- ✅ Giới hạn tối đa 3 topping
- ✅ Tính giá = giá gốc + tổng giá topping
- ✅ Protected constructor cho DeluxeBurger

**Key Methods**:
- `addTopping(String name, double price)` - Thêm topping với validation
- `getAdjustedPrice()` - Override: giá burger + toppings
- `printItem()` - Override: hiển thị burger + từng topping

---

### 3️⃣ DeluxeBurger.java - Premium Package

```java
public class DeluxeBurger extends Burger {
    public DeluxeBurger(String name, double price) {
        super(name, price, 5); // 5 toppings max
    }
}
```

**Mục đích**: Burger cao cấp với giá cố định

**Đặc điểm**:
- ⭐ Cho phép 5 topping thay vì 3
- ⭐ Giá cố định dù thêm bao nhiêu topping
- ⭐ Giá đã bao gồm drink và side item

**Key Override**:
```java
@Override
public double getAdjustedPrice() {
    return super.getBasePrice(); // Luôn trả về giá gốc
}
```

---

### 4️⃣ Drink.java - Beverage with Size

```java
public class Drink extends Item {
    private Size size = Size.SMALL;
    
    public enum Size {
        SMALL(0.0), MEDIUM(0.5), LARGE(1.0);
    }
}
```

**Mục đích**: Đồ uống với nhiều size

**Key Features**:
- 🥤 Enum Size cho type-safety
- 🥤 Mỗi size có phụ phí riêng
- 🥤 Giá = giá gốc + phụ phí size

**Key Methods**:
- `setSize(Size size)` - Thay đổi size
- `getAdjustedPrice()` - Override: giá + size modifier

---

### 5️⃣ SideItem.java - Simple Side Dish

```java
public class SideItem extends Item {
    public SideItem(String name, double price) {
        super(name, "Side", price);
    }
}
```

**Mục đích**: Món phụ đơn giản (Fries, Salad, Onion Rings)

**Đặc điểm**:
- Không override method nào
- Sử dụng toàn bộ logic của Item
- Giá cố định, không thay đổi

---

### 6️⃣ MealOrder.java - Order Manager

```java
public class MealOrder {
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;
}
```

**Mục đích**: Quản lý đơn hàng combo hoàn chỉnh

**Key Features**:
- 📦 Aggregation pattern - gom các món thành combo
- 📦 Delegation pattern - ủy thác cho các item xử lý
- 📦 Business logic cho DeluxeBurger

**Key Methods**:
- `addBurgerTopping()` - Delegation to burger
- `setDrinkSize()` - Delegation to drink
- `getTotalPrice()` - Tính tổng với logic đặc biệt cho Deluxe
- `printItemizedList()` - Tạo hóa đơn chi tiết

**Logic Đặc Biệt**:
```java
public double getTotalPrice() {
    if (burger instanceof DeluxeBurger) {
        return burger.getAdjustedPrice(); // Chỉ tính giá burger
    }
    return burger.getAdjustedPrice() + 
           drink.getAdjustedPrice() + 
           sideItem.getAdjustedPrice();
}
```

---

## 🚀 Hướng Dẫn Sử Dụng

### Yêu Cầu Hệ Thống

- ☕ Java JDK 8 trở lên
- 💻 Command Line hoặc IDE (IntelliJ IDEA, Eclipse, VS Code)

### Biên Dịch và Chạy

Chạy file run.bat có sẵn

## 📺 Output Mẫu

```
--- Default Meal ---
------------------------------
Regular Burger       $ 4.00
 -> Cheese          $ 0.50
Coke (LARGE)         $ 2.50
Fries                $ 2.00
------------------------------
TOTAL:               $ 9.00
==============================

--- Custom Meal ---
Cannot add topping: Maximum number of toppings reached.
------------------------------
Beef Burger          $ 5.50
 -> Bacon           $ 1.00
 -> Avocado         $ 1.25
 -> Lettuce         $ 0.25
Pepsi (MEDIUM)       $ 2.00
Onion Rings          $ 2.50
------------------------------
TOTAL:               $12.50
==============================

--- Deluxe Meal ---
------------------------------
Deluxe Burger        $10.00
 -> Cheese          $ 0.50
 -> Bacon           $ 1.00
 -> Egg             $ 1.50
 -> Pickles         $ 0.25
 -> Onions          $ 0.25
   (Price includes toppings, drink and side item)
------------------------------
TOTAL:               $10.00
==============================
```

---

## 💡 Ví Dụ Sử Dụng

### Tạo Default Meal

```java
MealOrder defaultMeal = new MealOrder();
defaultMeal.addBurgerTopping("Cheese", 0.50);
defaultMeal.setDrinkSize(Drink.Size.LARGE);
defaultMeal.printItemizedList();
```

### Tạo Custom Meal

```java
Burger customBurger = new Burger("Beef", 5.50);
Drink customDrink = new Drink("Pepsi", 1.50);
SideItem customSide = new SideItem("Onion Rings", 2.50);

MealOrder customMeal = new MealOrder(customBurger, customDrink, customSide);
customMeal.addBurgerTopping("Bacon", 1.00);
customMeal.addBurgerTopping("Avocado", 1.25);
customMeal.setDrinkSize(Drink.Size.MEDIUM);
customMeal.printItemizedList();
```

### Tạo Deluxe Meal

```java
DeluxeBurger deluxeBurger = new DeluxeBurger("Deluxe", 10.00);
MealOrder deluxeMeal = new MealOrder(
    deluxeBurger, 
    new Drink("Juice", 0), 
    new SideItem("Salad", 0)
);
deluxeMeal.addBurgerTopping("Cheese", 0.50);
deluxeMeal.addBurgerTopping("Bacon", 1.00);
deluxeMeal.addBurgerTopping("Egg", 1.50);
deluxeMeal.printItemizedList();
```

---

## 🎓 Nguyên Lý OOP Được Áp Dụng

### 1. Encapsulation (Đóng gói)

```java
// Thuộc tính private, truy cập qua methods
private List<Item> toppings;

public void addTopping(String name, double price) {
    // Logic kiểm tra được ẩn bên trong
}
```

**Lợi ích**: Bảo vệ dữ liệu, dễ thay đổi implementation

---

### 2. Inheritance (Kế thừa)

```java
Item
