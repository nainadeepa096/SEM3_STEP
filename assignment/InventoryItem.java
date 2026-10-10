public class InventoryItem {
    private final String itemCode;
    private int quantity;
    private final double unitPrice;

    public InventoryItem(String itemCode, int initialQuantity, double unitPrice) {
        this.itemCode = itemCode;
        this.quantity = Math.max(0, initialQuantity);
        this.unitPrice = Math.max(0.0, unitPrice);
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void restock(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    public boolean reduceStock(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    public double getTotalValue() {
        return quantity * unitPrice;
    }
}