package hotel.app.android.hotel0.ui.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kymjs.kjframe.ui.KJFragment;

import hotel.app.android.hotel0.R;

/**
 * Created by Administrator on 2016-12-5.
 */
public class DetailsFrag extends KJFragment {
    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.frag_details_layout,container,false);
    }
}
