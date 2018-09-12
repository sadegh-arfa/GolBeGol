package health.sport.oxygen.ui.Cell;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import health.sport.oxygen.R;

/**
 * Created by S_ on 4/7/2018.
 */
public class waterwidget extends FrameLayout {

    private TextView value;
    private TextView plus;
    private TextView minus;

    public waterwidget(@NonNull Context context) {
        super(context);


        LayoutInflater inflater = LayoutInflater.from(context);
        View root = inflater.inflate(R.layout.water_row, null, false);
        addView(root);

        value = root.findViewById(R.id.value);
        plus = root.findViewById(R.id.plus);
        minus = root.findViewById(R.id.minus);

    }


}