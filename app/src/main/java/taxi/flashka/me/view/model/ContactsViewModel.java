package taxi.flashka.me.view.model;

import android.app.Application;
import android.support.annotation.NonNull;

import taxi.flashka.me.view.SingleLiveEvent;

public class ContactsViewModel extends ViewModel {

    private SingleLiveEvent<Void> emailEvent = new SingleLiveEvent<>()
            , messageEvent = new SingleLiveEvent<>()
            , phoneEvent = new SingleLiveEvent<>();

    public ContactsViewModel(@NonNull Application application) {
        super(application);
    }

    public void onClickedEmail() {
        emailEvent.call();
    }

    public void onClickedMessage() {
        messageEvent.call();
    }

    public void onClickedPhone() {
        phoneEvent.call();
    }

    public SingleLiveEvent<Void> getEmailEvent() {
        return emailEvent;
    }

    public SingleLiveEvent<Void> getMessageEvent() {
        return messageEvent;
    }

    public SingleLiveEvent<Void> getPhoneEvent() {
        return phoneEvent;
    }
}
