package Views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * Created by jinfei on 08/02/2017.
 */

public class ViewTest extends View {

    Paint paint = new Paint();

    public ViewTest(Context context) {
        super(context);

    }

    public ViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(50);
        canvas.drawText("ViewTest draw text", 0 , 80 , paint);

        canvas.drawLine(0 ,90 ,300 , 90 ,paint);

        canvas.drawRect(0, 100, 300, 150, paint);

        canvas.drawCircle(50, 250, 50, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(0, 400, 50, 450, 10, 10, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(0, 500, 50, 550, 10, 10, paint);

        Log.i("attr_color", String.valueOf(paint.getColor()));
        canvas.drawRect(0, 600, 150, 650, paint);
//        getResources().getColor(android.R.color.darker_gray, null);
    }
}
