package taxi.flashka.me.view.model;

import taxi.flashka.me.view.SingleLiveEvent;

public class PaymentViewModel extends ViewModel {

    private SingleLiveEvent<Void> cardEvent = new SingleLiveEvent<>()
            , walletEvent = new SingleLiveEvent<>();

    public void onClickedCard() {
        cardEvent.call();
    }

    public void onClickedWallet() {
        walletEvent.call();
    }

    public SingleLiveEvent<Void> getCardEvent() {
        return cardEvent;
    }

    public SingleLiveEvent<Void> getWalletEvent() {
        return walletEvent;
    }
}
