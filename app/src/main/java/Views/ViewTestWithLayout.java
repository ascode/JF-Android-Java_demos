package Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinfei on 08/02/2017.
 */

public class ViewTestWithLayout extends View {

    Paint paint = new Paint();

    public ViewTestWithLayout(Context context) {
        super(context);
    }

    public ViewTestWithLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("ViewTest draw text", 0 , 80 , paint);

        canvas.drawLine(0 ,90 ,300 , 90 ,paint);

        canvas.drawRect(0, 100, 300, 150, paint);
    }
}
