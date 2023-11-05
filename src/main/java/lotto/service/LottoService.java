package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;

public class LottoService {
    private final NumberGenerator generator;
    private PurchaseAmount purchaseAmount;
    private List<Lotto> lottoTickets;
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public LottoService(NumberGenerator generator) {
        this.generator = generator;
        lottoTickets = new ArrayList<>();
    }

    public List<Lotto> buyLottoTickets(String money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        purchaseAmount = new PurchaseAmount(money);

        for (int i = 0; i < purchaseAmount.getAmount(); ++i) {
            lottoTickets.add(createSingleLotto());
        }
        this.lottoTickets = lottoTickets;
        return Collections.unmodifiableList(lottoTickets);
    }

    private Lotto createSingleLotto() {
        return new Lotto(generator.generateLotto());
    }

    public void getWinningLotto(String winningNumber, String bonus) {
        winningLotto = new Lotto(winningNumber);
        bonusNumber = LottoNumber.from(bonus);
    }
}
