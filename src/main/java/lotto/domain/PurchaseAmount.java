package lotto.domain;

import static lotto.constants.ErrorCode.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.ErrorCode.NOT_INTEGER;
import static lotto.constants.LottoRule.MAX_PRICE;
import static lotto.constants.LottoRule.UNIT_PRICE;

public class PurchaseAmount {
    private int paidMoney;
    private int purchaseAmount;

    public PurchaseAmount(String input) {
        validatePurchaseAmount(input);
        this.paidMoney = convertToInt(input);
        this.purchaseAmount = getUnitAmount(input);
    }

    private int getUnitAmount(String input) {
        return convertToInt(input) / UNIT_PRICE.getValue();
    }

    private void validatePurchaseAmount(String input) {
        isInteger(input);
        validateRange(input);
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    private void validateRange(String input) {
        int purchase = convertToInt(input);
        if (purchase > MAX_PRICE.getValue() || purchase <= 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getPaidMoney() {
        return paidMoney;
    }

    public int getAmount() {
        return purchaseAmount;
    }
}
