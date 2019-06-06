import java.util.List;

public class Core {
    private Medium medium = new DatabaseMedium();

    public void addAmount(String client, float amount) throws Exception {
        System.out.println(amount);
        float balance = this.getBalance(client);

        if (balance + amount < 0) {
            System.out.println("Wrong Amount");
        } else {
            long dataId = System.currentTimeMillis();
            medium.write(client, dataId, Float.toString(amount));
        }
    }

    public void getAmount(String client, float amount) throws Exception {
        this.addAmount(client, -amount);
    }

    public void transferAmount(String fromClient, String toClient, float amount) throws Exception {
        this.getAmount(fromClient, amount);
        this.addAmount(toClient, amount);
    }

    public float getBalance(String client) throws Exception {
        float balance = 0;
        List<String> operations = medium.read(client);

        for (String operation : operations) {
            balance += Float.valueOf(operation);
        }

        return balance;
    }
}
