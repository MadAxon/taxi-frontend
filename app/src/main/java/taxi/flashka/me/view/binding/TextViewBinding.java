package taxi.flashka.me.view.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import taxi.flashka.me.R;

public class TextViewBinding {

    @BindingAdapter({"enum"})
    public static void setText(TextView textView, String enumString) {
        String text;
        switch (enumString) {
            case "SUCCESSFUL":
                text = textView.getContext().getString(R.string.transaction_status_success);
                break;
            case "PENDING":
                text = textView.getContext().getString(R.string.transaction_status_pending);
                break;
            case "CANCELLED":
                text = textView.getContext().getString(R.string.transaction_status_cancelled);
                break;
            case "FAILED":
                text = textView.getContext().getString(R.string.transaction_status_failed);
                break;
            case "WINNER_EXISTS":
                text = textView.getContext().getString(R.string.winner_status_exist);
                break;
            case "WINNER_PENDING":
                text = textView.getContext().getString(R.string.winner_status_pending);
                break;
            case "WINNER_DOESNT_EXIST":
                text = textView.getContext().getString(R.string.winner_status_doesnt_exist);
                break;
            case "PURCHASE":
                text = textView.getContext().getString(R.string.transaction_type_purchase);
                break;
            case "PAYOUT":
                text = textView.getContext().getString(R.string.transaction_type_payout);
                break;
            case "WINNER":
                text = textView.getContext().getString(R.string.transaction_type_winner);
                break;
            default:
                text = enumString;
        }
        textView.setText(text);
    }

}
