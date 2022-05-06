enum Category {
  Essentials,
  Luxury,
  Misc
}

public class Item {
  private Category category;
  private String item;
  private int quantity;
  private float price;

  public Item(Category category, String item, int quantity, float price){
      this.category = category;
      this.item = item;
      this.quantity = quantity;
      this.price = price;
  }

  protected Category getCategory() {
    return this.category;
  }

  protected String getItem() {
    return this.item;
  }

  protected int getQuantity() {
    return this.quantity;
  }

  protected float getPrice() {
    return this.price;
  }
}