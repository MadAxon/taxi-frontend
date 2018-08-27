package taxi.flashka.me.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private final int mColor;
    private final int mHeight;
    private final Paint paint;

    public ItemDecoration(Context context) {
        this.mColor = context.getResources().getColor(android.R.color.white);
        this.mHeight = 2;
        this.paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mHeight;

            paint.setColor(mColor);
            c.drawRect(left, top, right, bottom, paint);

        }
    }

}
