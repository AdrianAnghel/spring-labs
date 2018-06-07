package savings.service.impl;

import org.joda.money.Money;
import savings.model.*;
import savings.repository.AccountRepository;
import savings.repository.MerchantRepository;
import savings.repository.PaybackRepository;

/**
 * Created by Frank on 6/5/2018.
 */
public class PaybackBookKeeperImpl {
    private AccountRepository accountRepository;
    private MerchantRepository merchantRepository;
    private PaybackRepository paybackRepository;

    public PaybackBookKeeperImpl(AccountRepository accountRepository, MerchantRepository merchantRepository,
                                 PaybackRepository paybackRepository){
        this.accountRepository = accountRepository;
        this.merchantRepository = merchantRepository;
        this.paybackRepository = paybackRepository;
    }

    PaybackConfirmation registerPaybackFor(Purchase purchase){
        Account account = accountRepository.findByCreditCard(purchase.getCreditCardNumber());
        Merchant merchant = merchantRepository.findByNumber(purchase.getMerchantNumber());
        Money paybackMoney = merchant.calculatePaybackFor(account, purchase);
        AccountIncome accountIncome = account.addPayback(paybackMoney);

        return paybackRepository.save(accountIncome, purchase);
    }


}
