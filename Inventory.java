import java.util.ArrayList;
import java.util.List;

public class Inventory {

  public static List<Item> generateMockItemData() {
    String data =
      "Clothes,Essentials,100,20\n" +
      "Soap,Essentials,200,5\n" +
      "Shampoo,Essentials,200,10\n" +
      "Milk,Essentials,100,5\n" +
      "Perfume,Luxury,50,50\n" +
      "Chocolates,Luxury,300,3\n" +
      "Handbag,Luxury,75,150\n" +
      "Wallet,Luxury,100,100\n" +
      "Bedsheet,Misc,150,75\n" +
      "Footware,Misc,200,25\n" +
      "HomeDecorPiece,Misc,100,40\n" +
      "pen,Misc,400,3\n" +
      "pencil,Misc,400,3\n";

      String[] rows = data.split("\n");
      List<Item> listOfItemData = new ArrayList<Item>();

      int i = 0;
      while (i < rows.length) {
        String[] row = rows[i].split(",");
        Item newItem = new Item(Category.valueOf(row[1]),row[0],Integer.parseInt(row[2]),Float.parseFloat(row[3]));
        listOfItemData.add(newItem);
        i++;
      }

      return listOfItemData;
  }

  public static List<Card> generateMockCardData() {
    String data =
      "5.41E+15\n" +
      "4.12E+12\n" +
      "3.41E+14\n" +
      "6.01E+15\n";

      String[] rows = data.split("\n");
      List<Card> listOfCardData = new ArrayList<Card>();

      int i = 0;
      while (i < rows.length) {
        String[] row = rows[i].split(",");
        Card newCard = new Card(row[0]);
        listOfCardData.add(newCard);
        i++;
      }

      return listOfCardData;
  }
}