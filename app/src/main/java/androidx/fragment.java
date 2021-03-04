package androidx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class fragment extends View {
    public fragment(Context context) {
        this(context, null);
    }

    public fragment(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public fragment(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
