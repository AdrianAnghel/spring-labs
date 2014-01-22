package savings.model;

import org.joda.money.Money;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class Purchase {

    private Money amount;

    private String creditCardNumber;

    private String merchantNumber;

    @DateTimeFormat()
    private DateTime date;

    public Purchase(Money amount, String creditCardNumber, String merchantNumber, DateTime date) {
        this.amount = amount;
        this.creditCardNumber = creditCardNumber;
        this.merchantNumber = merchantNumber;
        this.date = date;
    }

    public Purchase() {

    }

    public Money getAmount() {
        return amount;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public DateTime getDate() {
        return date;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;

        return amount.equals(purchase.amount) &&
                creditCardNumber.equals(purchase.creditCardNumber) &&
                date.equals(purchase.date) &&
                merchantNumber.equals(purchase.merchantNumber);
    }

    @Override
    public int hashCode() {
        return amount.hashCode() + creditCardNumber.hashCode() + merchantNumber.hashCode() + date.hashCode();
    }

    @Override
    public String toString() {
        return "Purchase of " + amount + " charged to '" + creditCardNumber + "' by '" + merchantNumber + "' on " + date;
    }
}
