public class Card {
  private String number;

  public Card(String number){
    this.number = number;
  }

  protected String getNumber() {
    return this.number;
  }
}