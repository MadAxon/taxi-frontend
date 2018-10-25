package taxi.flashka.me.repository.service;

import android.os.Handler;

import java.util.Locale;

import taxi.flashka.me.interfaces.ITimerListener;

public class TimerService implements Runnable {

    private long endTime;

    private Handler timerHandler = new Handler();

    private ITimerListener timerListener;

    public TimerService(ITimerListener timerListener, long endTime) {
        this.endTime = endTime;
        this.timerListener = timerListener;
    }

    @Override
    public void run() {
        long millis = endTime - System.currentTimeMillis();
        if (millis <= 0) {
            timerListener.createNextTimer();
            timerHandler.removeCallbacks(this);
        }
        int seconds = (int) (millis / 1000);

        timerListener.updateTimer(String.format(Locale.getDefault(),
                "%02d:%02d:%02d",
                seconds / 3600,
                (seconds % 3600) / 60,
                seconds % 60));

        timerHandler.postDelayed(this, 500);
    }

    public void postDelayed() {
        timerHandler.postDelayed(this, 0);
    }

    public void removeCallbacks() {
        timerHandler.removeCallbacks(this);
    }

}
