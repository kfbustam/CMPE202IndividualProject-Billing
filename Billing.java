import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Billing {  
  public static void main(String args[]) throws FileNotFoundException, IOException {  
    ArrayList<Item> items = new ArrayList<Item>(Inventory.generateMockItemData());
    ArrayList<Card> cards = new ArrayList<Card>(Inventory.generateMockCardData());
    
    try {
      if (args.length == 0) {
        System.err.println("Invalid arguments count:" + args.length);
        System.exit(1);
      }
      
      BufferedReader br = new BufferedReader(new FileReader(args[0]));

      try {
        ArrayList<String> outputCSVData = new ArrayList<String>();
        ArrayList<String> incorrectOutput = new ArrayList<String>();
        String line;

        while ((line = br.readLine()) != null) {
          String[] row = line.split(",");
          String itemName = row[0]; // item
          int quantity = Integer.parseInt(row[1]); // quantity

          if (row.length > 2) {
            int i = 0;
            while (i < cards.size()) {
              i++;
            }
            if (i == cards.size()) {
              cards.add(new Card(row[2]));
            }
          }

          for (Item item : items) {
            if (item.getItem().equals(itemName)) {
              // validate quantity in inventory
              if (item.getQuantity() < quantity) {
                incorrectOutput.add(line);
              }

              outputCSVData.add(itemName + "," + row[1] + "," + Float.toString(item.getPrice() * quantity));
            }
          }
        }

        if (incorrectOutput.size() > 0) {
          incorrectOutput.add(0,"Please correct quantities.");
          FileWriter writer = new FileWriter("output.txt");

          String collect = incorrectOutput.stream().collect(Collectors.joining("\n"));
          writer.write(collect);
          writer.close();
          return;
        }

        int totalPrice = 0;

        for (String outputLine : outputCSVData) {
          String[] row = outputLine.split(",");
          Float price = Float.parseFloat(row[2]);
          totalPrice += price;
        }

        String firstLine = outputCSVData.get(0);
        outputCSVData.set(0, firstLine + "," + Float.toString(totalPrice));

        outputCSVData.add(0,"Item,Quantity,Price,TotalPrice");

        FileWriter writer = new FileWriter("output.csv");

        String collect = outputCSVData.stream().collect(Collectors.joining("\n"));
        writer.write(collect);
        writer.close();
      } finally {
        br.close();
      }

    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
  }
}